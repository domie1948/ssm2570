package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.ZhuyuanEntity;

import com.service.ZhuyuanService;
import com.entity.view.ZhuyuanView;
import com.service.BingrenService;
import com.entity.BingrenEntity;
import com.service.ChuangweiService;
import com.entity.ChuangweiEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 住院
 * 后端接口
 * @author
 * @email
 * @date 2021-04-08
*/
@RestController
@Controller
@RequestMapping("/zhuyuan")
public class ZhuyuanController {
    private static final Logger logger = LoggerFactory.getLogger(ZhuyuanController.class);

    @Autowired
    private ZhuyuanService zhuyuanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private BingrenService bingrenService;
    @Autowired
    private ChuangweiService chuangweiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "医生".equals(role)){
            params.put("yishengId",request.getSession().getAttribute("userId"));
        }
        if(StringUtil.isNotEmpty(role) && "护士".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        params.put("orderBy","id");
        PageUtils page = zhuyuanService.queryPage(params);

        //字典表数据转换
        List<ZhuyuanView> list =(List<ZhuyuanView>)page.getList();
        for(ZhuyuanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhuyuanEntity zhuyuan = zhuyuanService.selectById(id);
        if(zhuyuan !=null){
            //entity转view
            ZhuyuanView view = new ZhuyuanView();
            BeanUtils.copyProperties( zhuyuan , view );//把实体数据重构到view中

            //级联表
            BingrenEntity bingren = bingrenService.selectById(zhuyuan.getBingrenId());
            if(bingren != null){
                BeanUtils.copyProperties( bingren , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setBingrenId(bingren.getId());
            }
            //级联表
            ChuangweiEntity chuangwei = chuangweiService.selectById(zhuyuan.getChuangweiId());
            if(chuangwei != null){
                BeanUtils.copyProperties( chuangwei , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setChuangweiId(chuangwei.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZhuyuanEntity zhuyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhuyuan:{}",this.getClass().getName(),zhuyuan.toString());
        Wrapper<ZhuyuanEntity> queryWrapper = new EntityWrapper<ZhuyuanEntity>()
            .eq("bingren_id", zhuyuan.getBingrenId())
            .eq("chuangwei_id", zhuyuan.getChuangweiId())
            .eq("zhuyuan_money", zhuyuan.getZhuyuanMoney())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChuangweiEntity chuangwei = chuangweiService.selectById(zhuyuan.getChuangweiId());
        if(chuangwei == null){
            return R.error("床位必选");
        }
        if(chuangwei.getChuangweiTypes() == 2){
            return R.error("这个床位正在使用");
        }
        chuangwei.setChuangweiTypes(2);

        ZhuyuanEntity zhuyuanEntity = zhuyuanService.selectOne(queryWrapper);
        if(zhuyuanEntity==null){
            zhuyuan.setInsertTime(new Date());
            zhuyuan.setCreateTime(new Date());
            zhuyuanService.insert(zhuyuan);
            chuangweiService.updateById(chuangwei);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhuyuanEntity zhuyuan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zhuyuan:{}",this.getClass().getName(),zhuyuan.toString());
        //根据字段查询是否有相同数据
        Wrapper<ZhuyuanEntity> queryWrapper = new EntityWrapper<ZhuyuanEntity>()
            .notIn("id",zhuyuan.getId())
            .andNew()
            .eq("bingren_id", zhuyuan.getBingrenId())
            .eq("chuangwei_id", zhuyuan.getChuangweiId())
            .eq("zhuyuan_money", zhuyuan.getZhuyuanMoney())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhuyuanEntity zhuyuanEntity = zhuyuanService.selectOne(queryWrapper);
        if(zhuyuanEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      zhuyuan.set
            //  }
            zhuyuanService.updateById(zhuyuan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 出院
    */
    @RequestMapping("/chuyuan")
    public R chuyuan(Integer ids){
        ZhuyuanEntity zhuyuan = zhuyuanService.selectById(ids);
        if(zhuyuan == null){
            return R.error();
        }
        zhuyuan.setZhuyuanTypes(1);
        boolean b = zhuyuanService.updateById(zhuyuan);
        if(b){
            ChuangweiEntity chuangwei = chuangweiService.selectById(zhuyuan.getChuangweiId());
            chuangwei.setChuangweiTypes(1);
            chuangweiService.updateById(chuangwei);
            return R.ok().put("money",zhuyuan.getZhuyuanMoney());
        }
        return R.error();
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        zhuyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



}


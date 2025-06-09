package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.ZhuyuanEntity;
import com.service.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.XiaofeijiluEntity;

import com.entity.view.XiaofeijiluView;
import com.entity.BingrenEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 住院消费
 * 后端接口
 * @author
 * @email
 * @date 2021-04-08
*/
@RestController
@Controller
@RequestMapping("/xiaofeijilu")
public class XiaofeijiluController {
    private static final Logger logger = LoggerFactory.getLogger(XiaofeijiluController.class);

    @Autowired
    private XiaofeijiluService xiaofeijiluService;


    @Autowired
    private ZhuyuanService zhuyuanService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private BingrenService bingrenService;


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
        PageUtils page = xiaofeijiluService.queryPage(params);

        //字典表数据转换
        List<XiaofeijiluView> list =(List<XiaofeijiluView>)page.getList();
        for(XiaofeijiluView c:list){
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
        XiaofeijiluEntity xiaofeijilu = xiaofeijiluService.selectById(id);
        if(xiaofeijilu !=null){
            //entity转view
            XiaofeijiluView view = new XiaofeijiluView();
            BeanUtils.copyProperties( xiaofeijilu , view );//把实体数据重构到view中

            //级联表
            BingrenEntity bingren = bingrenService.selectById(xiaofeijilu.getBingrenId());
            if(bingren != null){
                BeanUtils.copyProperties( bingren , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setBingrenId(bingren.getId());
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
    public R save(@RequestBody XiaofeijiluEntity xiaofeijilu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xiaofeijilu:{}",this.getClass().getName(),xiaofeijilu.toString());
        Wrapper<XiaofeijiluEntity> queryWrapper = new EntityWrapper<XiaofeijiluEntity>()
            .eq("bingren_id", xiaofeijilu.getBingrenId())
            .eq("xiaofeijilu_money", xiaofeijilu.getXiaofeijiluMoney())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhuyuanEntity zhuyuanEntity = zhuyuanService.selectOne(
                new EntityWrapper<ZhuyuanEntity>().eq("bingren_id", xiaofeijilu.getBingrenId())
                        .eq("zhuyuan_types", 0));
        if(zhuyuanEntity == null){
            return R.error("住院后才可以添加住院消费信息");
        }
        if(zhuyuanEntity.getZhuyuanTypes() != 0){
            return R.error("这个病人已经出院了");
        }
        XiaofeijiluEntity xiaofeijiluEntity = xiaofeijiluService.selectOne(queryWrapper);
        if(xiaofeijiluEntity==null){
            xiaofeijilu.setInsertTime(new Date());
            xiaofeijilu.setCreateTime(new Date());
            xiaofeijiluService.insert(xiaofeijilu);
            zhuyuanEntity.setZhuyuanMoney(zhuyuanEntity.getZhuyuanMoney()+xiaofeijilu.getXiaofeijiluMoney());
            zhuyuanService.updateById(zhuyuanEntity);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XiaofeijiluEntity xiaofeijilu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xiaofeijilu:{}",this.getClass().getName(),xiaofeijilu.toString());
        //根据字段查询是否有相同数据
        Wrapper<XiaofeijiluEntity> queryWrapper = new EntityWrapper<XiaofeijiluEntity>()
            .notIn("id",xiaofeijilu.getId())
            .andNew()
            .eq("bingren_id", xiaofeijilu.getBingrenId())
            .eq("xiaofeijilu_money", xiaofeijilu.getXiaofeijiluMoney())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiaofeijiluEntity xiaofeijiluEntity = xiaofeijiluService.selectOne(queryWrapper);
        if(xiaofeijiluEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      xiaofeijilu.set
            //  }
            xiaofeijiluService.updateById(xiaofeijilu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        xiaofeijiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



}


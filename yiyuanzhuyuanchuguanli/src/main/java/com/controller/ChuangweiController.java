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

import com.entity.ChuangweiEntity;

import com.service.ChuangweiService;
import com.entity.view.ChuangweiView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 床位
 * 后端接口
 * @author
 * @email
 * @date 2021-04-08
*/
@RestController
@Controller
@RequestMapping("/chuangwei")
public class ChuangweiController {
    private static final Logger logger = LoggerFactory.getLogger(ChuangweiController.class);

    @Autowired
    private ChuangweiService chuangweiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service


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
        PageUtils page = chuangweiService.queryPage(params);

        //字典表数据转换
        List<ChuangweiView> list =(List<ChuangweiView>)page.getList();
        for(ChuangweiView c:list){
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
        ChuangweiEntity chuangwei = chuangweiService.selectById(id);
        if(chuangwei !=null){
            //entity转view
            ChuangweiView view = new ChuangweiView();
            BeanUtils.copyProperties( chuangwei , view );//把实体数据重构到view中

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
    public R save(@RequestBody ChuangweiEntity chuangwei, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chuangwei:{}",this.getClass().getName(),chuangwei.toString());
        Wrapper<ChuangweiEntity> queryWrapper = new EntityWrapper<ChuangweiEntity>()
            .eq("chuangwei_name", chuangwei.getChuangweiName())
            .eq("chuangwei_types", chuangwei.getChuangweiTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChuangweiEntity chuangweiEntity = chuangweiService.selectOne(queryWrapper);
        if(chuangweiEntity==null){
            chuangwei.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      chuangwei.set
        //  }
            chuangweiService.insert(chuangwei);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChuangweiEntity chuangwei, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,chuangwei:{}",this.getClass().getName(),chuangwei.toString());
        //根据字段查询是否有相同数据
        Wrapper<ChuangweiEntity> queryWrapper = new EntityWrapper<ChuangweiEntity>()
            .notIn("id",chuangwei.getId())
            .andNew()
            .eq("chuangwei_name", chuangwei.getChuangweiName())
            .eq("chuangwei_types", chuangwei.getChuangweiTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChuangweiEntity chuangweiEntity = chuangweiService.selectOne(queryWrapper);
        if(chuangweiEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      chuangwei.set
            //  }
            chuangweiService.updateById(chuangwei);//根据id更新
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
        chuangweiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



}


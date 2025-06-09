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

import com.entity.BingrenEntity;

import com.service.BingrenService;
import com.entity.view.BingrenView;
import com.service.YishengService;
import com.entity.YishengEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 病人管理
 * 后端接口
 * @author
 * @email
 * @date 2021-04-08
*/
@RestController
@Controller
@RequestMapping("/bingren")
public class BingrenController {
    private static final Logger logger = LoggerFactory.getLogger(BingrenController.class);

    @Autowired
    private BingrenService bingrenService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private YishengService yishengService;


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
        PageUtils page = bingrenService.queryPage(params);

        //字典表数据转换
        List<BingrenView> list =(List<BingrenView>)page.getList();
        for(BingrenView c:list){
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
        BingrenEntity bingren = bingrenService.selectById(id);
        if(bingren !=null){
            //entity转view
            BingrenView view = new BingrenView();
            BeanUtils.copyProperties( bingren , view );//把实体数据重构到view中

            //级联表
            YishengEntity yisheng = yishengService.selectById(bingren.getYishengId());
            if(yisheng != null){
                BeanUtils.copyProperties( yisheng , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYishengId(yisheng.getId());
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
    public R save(@RequestBody BingrenEntity bingren, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,bingren:{}",this.getClass().getName(),bingren.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if("医生".equals(role)){
            bingren.setYishengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        }


        Wrapper<BingrenEntity> queryWrapper = new EntityWrapper<BingrenEntity>()
            .eq("bingren_name", bingren.getBingrenName())
            .eq("sex_types", bingren.getSexTypes())
            .eq("bingren_age", bingren.getBingrenAge())
            .eq("bingren_phone", bingren.getBingrenPhone())
            .eq("yisheng_id", bingren.getYishengId())
            .eq("huanbing_types", bingren.getHuanbingTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BingrenEntity bingrenEntity = bingrenService.selectOne(queryWrapper);
        if(bingrenEntity==null){
            bingren.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      bingren.set
        //  }
            bingrenService.insert(bingren);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BingrenEntity bingren, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,bingren:{}",this.getClass().getName(),bingren.toString());
        //根据字段查询是否有相同数据
        Wrapper<BingrenEntity> queryWrapper = new EntityWrapper<BingrenEntity>()
            .notIn("id",bingren.getId())
            .andNew()
            .eq("bingren_name", bingren.getBingrenName())
            .eq("sex_types", bingren.getSexTypes())
            .eq("bingren_age", bingren.getBingrenAge())
            .eq("bingren_phone", bingren.getBingrenPhone())
            .eq("yisheng_id", bingren.getYishengId())
            .eq("huanbing_types", bingren.getHuanbingTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BingrenEntity bingrenEntity = bingrenService.selectOne(queryWrapper);
        if(bingrenEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      bingren.set
            //  }
            bingrenService.updateById(bingren);//根据id更新
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
        bingrenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



}


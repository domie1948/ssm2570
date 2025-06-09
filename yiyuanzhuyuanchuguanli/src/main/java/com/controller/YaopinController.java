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

import com.entity.YaopinEntity;

import com.service.YaopinService;
import com.entity.view.YaopinView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 药品
 * 后端接口
 * @author
 * @email
 * @date 2021-04-08
*/
@RestController
@Controller
@RequestMapping("/yaopin")
public class YaopinController {
    private static final Logger logger = LoggerFactory.getLogger(YaopinController.class);

    @Autowired
    private YaopinService yaopinService;


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
        PageUtils page = yaopinService.queryPage(params);

        //字典表数据转换
        List<YaopinView> list =(List<YaopinView>)page.getList();
        for(YaopinView c:list){
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
        YaopinEntity yaopin = yaopinService.selectById(id);
        if(yaopin !=null){
            //entity转view
            YaopinView view = new YaopinView();
            BeanUtils.copyProperties( yaopin , view );//把实体数据重构到view中

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
    public R save(@RequestBody YaopinEntity yaopin, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yaopin:{}",this.getClass().getName(),yaopin.toString());
        Wrapper<YaopinEntity> queryWrapper = new EntityWrapper<YaopinEntity>()
            .eq("yaopin_name", yaopin.getYaopinName())
            .eq("yaopin_types", yaopin.getYaopinTypes())
            .eq("yaopin_money", yaopin.getYaopinMoney())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YaopinEntity yaopinEntity = yaopinService.selectOne(queryWrapper);
        if(yaopinEntity==null){
            yaopin.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      yaopin.set
        //  }
            yaopinService.insert(yaopin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YaopinEntity yaopin, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,yaopin:{}",this.getClass().getName(),yaopin.toString());
        //根据字段查询是否有相同数据
        Wrapper<YaopinEntity> queryWrapper = new EntityWrapper<YaopinEntity>()
            .notIn("id",yaopin.getId())
            .andNew()
            .eq("yaopin_name", yaopin.getYaopinName())
            .eq("yaopin_types", yaopin.getYaopinTypes())
            .eq("yaopin_money", yaopin.getYaopinMoney())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YaopinEntity yaopinEntity = yaopinService.selectOne(queryWrapper);
        if("".equals(yaopin.getYaopinPhoto()) || "null".equals(yaopin.getYaopinPhoto())){
                yaopin.setYaopinPhoto(null);
        }
        if(yaopinEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      yaopin.set
            //  }
            yaopinService.updateById(yaopin);//根据id更新
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
        yaopinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



}


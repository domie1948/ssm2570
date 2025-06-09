package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YishengEntity;
import java.util.Map;

/**
 * 医生 服务类
 * @author 
 * @since 2021-04-08
 */
public interface YishengService extends IService<YishengEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}
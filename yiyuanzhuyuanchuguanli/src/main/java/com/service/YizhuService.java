package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YizhuEntity;
import java.util.Map;

/**
 * 医嘱 服务类
 * @author 
 * @since 2021-04-08
 */
public interface YizhuService extends IService<YizhuEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}
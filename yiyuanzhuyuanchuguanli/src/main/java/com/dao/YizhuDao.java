package com.dao;

import com.entity.YizhuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YizhuView;

/**
 * 医嘱 Dao 接口
 *
 * @author 
 * @since 2021-04-08
 */
public interface YizhuDao extends BaseMapper<YizhuEntity> {

   List<YizhuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

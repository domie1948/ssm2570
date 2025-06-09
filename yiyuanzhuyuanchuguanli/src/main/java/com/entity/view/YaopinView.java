package com.entity.view;

import com.entity.YaopinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 药品
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-08
 */
@TableName("yaopin")
public class YaopinView extends YaopinEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 药品类型名称的值
		*/
		private String yaopinValue;



	public YaopinView() {

	}

	public YaopinView(YaopinEntity yaopinEntity) {
		try {
			BeanUtils.copyProperties(this, yaopinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 药品类型名称的值
			*/
			public String getYaopinValue() {
				return yaopinValue;
			}
			/**
			* 设置： 药品类型名称的值
			*/
			public void setYaopinValue(String yaopinValue) {
				this.yaopinValue = yaopinValue;
			}












}

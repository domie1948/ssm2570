package com.entity.view;

import com.entity.BingrenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 病人管理
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-08
 */
@TableName("bingren")
public class BingrenView extends BingrenEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 性别的值
		*/
		private String sexValue;
		/**
		* 患病类型的值
		*/
		private String huanbingValue;



		//级联表 yisheng
			/**
			* 姓名
			*/
			private String yishengName;
			/**
			* 性别
			*/
			private Integer sexTypes;
			/**
			* 身份证号
			*/
			private String yishengIdNumber;
			/**
			* 手机号
			*/
			private String yishengPhone;
			/**
			* 照片
			*/
			private String yishengPhoto;

	public BingrenView() {

	}

	public BingrenView(BingrenEntity bingrenEntity) {
		try {
			BeanUtils.copyProperties(this, bingrenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 患病类型的值
			*/
			public String getHuanbingValue() {
				return huanbingValue;
			}
			/**
			* 设置： 患病类型的值
			*/
			public void setHuanbingValue(String huanbingValue) {
				this.huanbingValue = huanbingValue;
			}














				//级联表的get和set yisheng
					/**
					* 获取： 姓名
					*/
					public String getYishengName() {
						return yishengName;
					}
					/**
					* 设置： 姓名
					*/
					public void setYishengName(String yishengName) {
						this.yishengName = yishengName;
					}
					/**
					* 获取： 性别
					*/
					public Integer getSexTypes() {
						return sexTypes;
					}
					/**
					* 设置： 性别
					*/
					public void setSexTypes(Integer sexTypes) {
						this.sexTypes = sexTypes;
					}


						/**
						* 获取： 性别的值
						*/
						public String getSexValue() {
							return sexValue;
						}
						/**
						* 设置： 性别的值
						*/
						public void setSexValue(String sexValue) {
							this.sexValue = sexValue;
						}
					/**
					* 获取： 身份证号
					*/
					public String getYishengIdNumber() {
						return yishengIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setYishengIdNumber(String yishengIdNumber) {
						this.yishengIdNumber = yishengIdNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getYishengPhone() {
						return yishengPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setYishengPhone(String yishengPhone) {
						this.yishengPhone = yishengPhone;
					}
					/**
					* 获取： 照片
					*/
					public String getYishengPhoto() {
						return yishengPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setYishengPhoto(String yishengPhoto) {
						this.yishengPhoto = yishengPhoto;
					}








}

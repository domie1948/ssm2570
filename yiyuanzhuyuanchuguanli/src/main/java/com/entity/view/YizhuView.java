package com.entity.view;

import com.entity.YizhuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 医嘱
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-08
 */
@TableName("yizhu")
public class YizhuView extends YizhuEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 医嘱类型名称的值
		*/
		private String yizhuValue;



		//级联表 bingren
			/**
			* 病人名称
			*/
			private String bingrenName;
			/**
			* 性别
			*/
			private Integer sexTypes;
				/**
				* 性别的值
				*/
				private String sexValue;
			/**
			* 年龄
			*/
			private Integer bingrenAge;
			/**
			* 家属联系方式
			*/
			private String bingrenPhone;
			/**
			* 检查医生
			*/
			private Integer yishengId;
			/**
			* 患病类型
			*/
			private Integer huanbingTypes;
				/**
				* 患病类型的值
				*/
				private String huanbingValue;
			/**
			* 患病详情
			*/
			private String bingrenContent;

		//级联表 yisheng
			/**
			* 姓名
			*/
			private String yishengName;
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

		//级联表 yonghu
			/**
			* 姓名
			*/
			private String yonghuName;
			/**
			* 身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 手机号
			*/
			private String yonghuPhone;
			/**
			* 照片
			*/
			private String yonghuPhoto;

	public YizhuView() {

	}

	public YizhuView(YizhuEntity yizhuEntity) {
		try {
			BeanUtils.copyProperties(this, yizhuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 医嘱类型名称的值
			*/
			public String getYizhuValue() {
				return yizhuValue;
			}
			/**
			* 设置： 医嘱类型名称的值
			*/
			public void setYizhuValue(String yizhuValue) {
				this.yizhuValue = yizhuValue;
			}





				//级联表的get和set bingren
					/**
					* 获取： 病人名称
					*/
					public String getBingrenName() {
						return bingrenName;
					}
					/**
					* 设置： 病人名称
					*/
					public void setBingrenName(String bingrenName) {
						this.bingrenName = bingrenName;
					}
					/**
					* 获取： 年龄
					*/
					public Integer getBingrenAge() {
						return bingrenAge;
					}
					/**
					* 设置： 年龄
					*/
					public void setBingrenAge(Integer bingrenAge) {
						this.bingrenAge = bingrenAge;
					}
					/**
					* 获取： 家属联系方式
					*/
					public String getBingrenPhone() {
						return bingrenPhone;
					}
					/**
					* 设置： 家属联系方式
					*/
					public void setBingrenPhone(String bingrenPhone) {
						this.bingrenPhone = bingrenPhone;
					}
					/**
					* 获取： 检查医生
					*/
					public Integer getYishengId() {
						return yishengId;
					}
					/**
					* 设置： 检查医生
					*/
					public void setYishengId(Integer yishengId) {
						this.yishengId = yishengId;
					}
					/**
					* 获取： 患病类型
					*/
					public Integer getHuanbingTypes() {
						return huanbingTypes;
					}
					/**
					* 设置： 患病类型
					*/
					public void setHuanbingTypes(Integer huanbingTypes) {
						this.huanbingTypes = huanbingTypes;
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
					/**
					* 获取： 患病详情
					*/
					public String getBingrenContent() {
						return bingrenContent;
					}
					/**
					* 设置： 患病详情
					*/
					public void setBingrenContent(String bingrenContent) {
						this.bingrenContent = bingrenContent;
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










				//级联表的get和set yonghu
					/**
					* 获取： 姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
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
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 照片
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}








}

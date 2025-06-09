package com.entity.view;

import com.entity.ZhuyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 住院
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-08
 */
@TableName("zhuyuan")
public class ZhuyuanView extends ZhuyuanEntity implements Serializable {
    private static final long serialVersionUID = 1L;



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

		//级联表 chuangwei
			/**
			* 床位编号
			*/
			private String chuangweiName;
			/**
			* 床位状态
			*/
			private Integer chuangweiTypes;
				/**
				* 床位状态的值
				*/
				private String chuangweiValue;

	public ZhuyuanView() {

	}

	public ZhuyuanView(ZhuyuanEntity zhuyuanEntity) {
		try {
			BeanUtils.copyProperties(this, zhuyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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




				//级联表的get和set chuangwei
					/**
					* 获取： 床位编号
					*/
					public String getChuangweiName() {
						return chuangweiName;
					}
					/**
					* 设置： 床位编号
					*/
					public void setChuangweiName(String chuangweiName) {
						this.chuangweiName = chuangweiName;
					}
					/**
					* 获取： 床位状态
					*/
					public Integer getChuangweiTypes() {
						return chuangweiTypes;
					}
					/**
					* 设置： 床位状态
					*/
					public void setChuangweiTypes(Integer chuangweiTypes) {
						this.chuangweiTypes = chuangweiTypes;
					}


						/**
						* 获取： 床位状态的值
						*/
						public String getChuangweiValue() {
							return chuangweiValue;
						}
						/**
						* 设置： 床位状态的值
						*/
						public void setChuangweiValue(String chuangweiValue) {
							this.chuangweiValue = chuangweiValue;
						}
























}

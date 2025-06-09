package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 病人管理
 *
 * @author 
 * @email
 * @date 2021-04-08
 */
@TableName("bingren")
public class BingrenEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BingrenEntity() {

	}

	public BingrenEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 病人名称
     */
    @TableField(value = "bingren_name")

    private String bingrenName;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 年龄
     */
    @TableField(value = "bingren_age")

    private Integer bingrenAge;


    /**
     * 家属联系方式
     */
    @TableField(value = "bingren_phone")

    private String bingrenPhone;


    /**
     * 检查医生
     */
    @TableField(value = "yisheng_id")

    private Integer yishengId;


    /**
     * 患病类型
     */
    @TableField(value = "huanbing_types")

    private Integer huanbingTypes;


    /**
     * 患病详情
     */
    @TableField(value = "bingren_content")

    private String bingrenContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：病人名称
	 */
    public String getBingrenName() {
        return bingrenName;
    }


    /**
	 * 获取：病人名称
	 */

    public void setBingrenName(String bingrenName) {
        this.bingrenName = bingrenName;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：年龄
	 */
    public Integer getBingrenAge() {
        return bingrenAge;
    }


    /**
	 * 获取：年龄
	 */

    public void setBingrenAge(Integer bingrenAge) {
        this.bingrenAge = bingrenAge;
    }
    /**
	 * 设置：家属联系方式
	 */
    public String getBingrenPhone() {
        return bingrenPhone;
    }


    /**
	 * 获取：家属联系方式
	 */

    public void setBingrenPhone(String bingrenPhone) {
        this.bingrenPhone = bingrenPhone;
    }
    /**
	 * 设置：检查医生
	 */
    public Integer getYishengId() {
        return yishengId;
    }


    /**
	 * 获取：检查医生
	 */

    public void setYishengId(Integer yishengId) {
        this.yishengId = yishengId;
    }
    /**
	 * 设置：患病类型
	 */
    public Integer getHuanbingTypes() {
        return huanbingTypes;
    }


    /**
	 * 获取：患病类型
	 */

    public void setHuanbingTypes(Integer huanbingTypes) {
        this.huanbingTypes = huanbingTypes;
    }
    /**
	 * 设置：患病详情
	 */
    public String getBingrenContent() {
        return bingrenContent;
    }


    /**
	 * 获取：患病详情
	 */

    public void setBingrenContent(String bingrenContent) {
        this.bingrenContent = bingrenContent;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Bingren{" +
            "id=" + id +
            ", bingrenName=" + bingrenName +
            ", sexTypes=" + sexTypes +
            ", bingrenAge=" + bingrenAge +
            ", bingrenPhone=" + bingrenPhone +
            ", yishengId=" + yishengId +
            ", huanbingTypes=" + huanbingTypes +
            ", bingrenContent=" + bingrenContent +
            ", createTime=" + createTime +
        "}";
    }
}

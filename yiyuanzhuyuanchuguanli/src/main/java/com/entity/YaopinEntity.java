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
 * 药品
 *
 * @author 
 * @email
 * @date 2021-04-08
 */
@TableName("yaopin")
public class YaopinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YaopinEntity() {

	}

	public YaopinEntity(T t) {
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
     * 药品名称
     */
    @TableField(value = "yaopin_name")

    private String yaopinName;


    /**
     * 药品类型名称
     */
    @TableField(value = "yaopin_types")

    private Integer yaopinTypes;


    /**
     * 药品价格
     */
    @TableField(value = "yaopin_money")

    private Integer yaopinMoney;


    /**
     * 药品图片
     */
    @TableField(value = "yaopin_photo")

    private String yaopinPhoto;


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
	 * 设置：药品名称
	 */
    public String getYaopinName() {
        return yaopinName;
    }


    /**
	 * 获取：药品名称
	 */

    public void setYaopinName(String yaopinName) {
        this.yaopinName = yaopinName;
    }
    /**
	 * 设置：药品类型名称
	 */
    public Integer getYaopinTypes() {
        return yaopinTypes;
    }


    /**
	 * 获取：药品类型名称
	 */

    public void setYaopinTypes(Integer yaopinTypes) {
        this.yaopinTypes = yaopinTypes;
    }
    /**
	 * 设置：药品价格
	 */
    public Integer getYaopinMoney() {
        return yaopinMoney;
    }


    /**
	 * 获取：药品价格
	 */

    public void setYaopinMoney(Integer yaopinMoney) {
        this.yaopinMoney = yaopinMoney;
    }
    /**
	 * 设置：药品图片
	 */
    public String getYaopinPhoto() {
        return yaopinPhoto;
    }


    /**
	 * 获取：药品图片
	 */

    public void setYaopinPhoto(String yaopinPhoto) {
        this.yaopinPhoto = yaopinPhoto;
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
        return "Yaopin{" +
            "id=" + id +
            ", yaopinName=" + yaopinName +
            ", yaopinTypes=" + yaopinTypes +
            ", yaopinMoney=" + yaopinMoney +
            ", yaopinPhoto=" + yaopinPhoto +
            ", createTime=" + createTime +
        "}";
    }
}

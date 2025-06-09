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
 * 医嘱
 *
 * @author 
 * @email
 * @date 2021-04-08
 */
@TableName("yizhu")
public class YizhuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YizhuEntity() {

	}

	public YizhuEntity(T t) {
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
     * 发布医生
     */
    @TableField(value = "yisheng_id")

    private Integer yishengId;


    /**
     * 接收病人
     */
    @TableField(value = "bingren_id")

    private Integer bingrenId;


    /**
     * 执行护士
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 医嘱类型名称
     */
    @TableField(value = "yizhu_types")

    private Integer yizhuTypes;


    /**
     * 医嘱内容
     */
    @TableField(value = "zhuyuanfeiyong_content")

    private String zhuyuanfeiyongContent;


    /**
     * 消费金额
     */
    @TableField(value = "zhuyuanfeiyong_money")

    private Integer zhuyuanfeiyongMoney;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 设置：发布医生
	 */
    public Integer getYishengId() {
        return yishengId;
    }


    /**
	 * 获取：发布医生
	 */

    public void setYishengId(Integer yishengId) {
        this.yishengId = yishengId;
    }
    /**
	 * 设置：接收病人
	 */
    public Integer getBingrenId() {
        return bingrenId;
    }


    /**
	 * 获取：接收病人
	 */

    public void setBingrenId(Integer bingrenId) {
        this.bingrenId = bingrenId;
    }
    /**
	 * 设置：执行护士
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：执行护士
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：医嘱类型名称
	 */
    public Integer getYizhuTypes() {
        return yizhuTypes;
    }


    /**
	 * 获取：医嘱类型名称
	 */

    public void setYizhuTypes(Integer yizhuTypes) {
        this.yizhuTypes = yizhuTypes;
    }
    /**
	 * 设置：医嘱内容
	 */
    public String getZhuyuanfeiyongContent() {
        return zhuyuanfeiyongContent;
    }


    /**
	 * 获取：医嘱内容
	 */

    public void setZhuyuanfeiyongContent(String zhuyuanfeiyongContent) {
        this.zhuyuanfeiyongContent = zhuyuanfeiyongContent;
    }
    /**
	 * 设置：消费金额
	 */
    public Integer getZhuyuanfeiyongMoney() {
        return zhuyuanfeiyongMoney;
    }


    /**
	 * 获取：消费金额
	 */

    public void setZhuyuanfeiyongMoney(Integer zhuyuanfeiyongMoney) {
        this.zhuyuanfeiyongMoney = zhuyuanfeiyongMoney;
    }
    /**
	 * 设置：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：发布时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "Yizhu{" +
            "id=" + id +
            ", yishengId=" + yishengId +
            ", bingrenId=" + bingrenId +
            ", yonghuId=" + yonghuId +
            ", yizhuTypes=" + yizhuTypes +
            ", zhuyuanfeiyongContent=" + zhuyuanfeiyongContent +
            ", zhuyuanfeiyongMoney=" + zhuyuanfeiyongMoney +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}

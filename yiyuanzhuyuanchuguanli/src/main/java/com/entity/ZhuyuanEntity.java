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
 * 住院
 *
 * @author 
 * @email
 * @date 2021-04-08
 */
@TableName("zhuyuan")
public class ZhuyuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhuyuanEntity() {

	}

	public ZhuyuanEntity(T t) {
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
     * 住院病人
     */
    @TableField(value = "bingren_id")

    private Integer bingrenId;
    /**
     * 住院状态
     */
    @TableField(value = "zhuyuan_types")

    private Integer zhuyuanTypes;

    public Integer getZhuyuanTypes() {
        return zhuyuanTypes;
    }

    public void setZhuyuanTypes(Integer zhuyuanTypes) {
        this.zhuyuanTypes = zhuyuanTypes;
    }

    /**
     * 住院时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 使用床位
     */
    @TableField(value = "chuangwei_id")

    private Integer chuangweiId;


    /**
     * 花费总金额
     */
    @TableField(value = "zhuyuan_money")

    private Integer zhuyuanMoney;


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
	 * 设置：住院病人
	 */
    public Integer getBingrenId() {
        return bingrenId;
    }


    /**
	 * 获取：住院病人
	 */

    public void setBingrenId(Integer bingrenId) {
        this.bingrenId = bingrenId;
    }
    /**
	 * 设置：住院时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：住院时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：使用床位
	 */
    public Integer getChuangweiId() {
        return chuangweiId;
    }


    /**
	 * 获取：使用床位
	 */

    public void setChuangweiId(Integer chuangweiId) {
        this.chuangweiId = chuangweiId;
    }
    /**
	 * 设置：花费总金额
	 */
    public Integer getZhuyuanMoney() {
        return zhuyuanMoney;
    }


    /**
	 * 获取：花费总金额
	 */

    public void setZhuyuanMoney(Integer zhuyuanMoney) {
        this.zhuyuanMoney = zhuyuanMoney;
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
        return "Zhuyuan{" +
            "id=" + id +
            ", bingrenId=" + bingrenId +
            ", insertTime=" + insertTime +
            ", chuangweiId=" + chuangweiId +
            ", zhuyuanMoney=" + zhuyuanMoney +
            ", createTime=" + createTime +
        "}";
    }
}

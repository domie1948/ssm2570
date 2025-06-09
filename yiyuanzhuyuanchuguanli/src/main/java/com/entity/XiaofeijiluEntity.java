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
 * 住院消费
 *
 * @author 
 * @email
 * @date 2021-04-08
 */
@TableName("xiaofeijilu")
public class XiaofeijiluEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XiaofeijiluEntity() {

	}

	public XiaofeijiluEntity(T t) {
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
    @TableField(value = "bingren_id")

    private Integer bingrenId;


    /**
     * 消费原因
     */
    @TableField(value = "xiaofeijilu_content")

    private String xiaofeijiluContent;


    /**
     * 消费金额
     */
    @TableField(value = "xiaofeijilu_money")

    private Integer xiaofeijiluMoney;


    /**
     * 消费时间
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
    public Integer getBingrenId() {
        return bingrenId;
    }


    /**
	 * 获取：发布医生
	 */

    public void setBingrenId(Integer bingrenId) {
        this.bingrenId = bingrenId;
    }
    /**
	 * 设置：消费原因
	 */
    public String getXiaofeijiluContent() {
        return xiaofeijiluContent;
    }


    /**
	 * 获取：消费原因
	 */

    public void setXiaofeijiluContent(String xiaofeijiluContent) {
        this.xiaofeijiluContent = xiaofeijiluContent;
    }
    /**
	 * 设置：消费金额
	 */
    public Integer getXiaofeijiluMoney() {
        return xiaofeijiluMoney;
    }


    /**
	 * 获取：消费金额
	 */

    public void setXiaofeijiluMoney(Integer xiaofeijiluMoney) {
        this.xiaofeijiluMoney = xiaofeijiluMoney;
    }
    /**
	 * 设置：消费时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：消费时间
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
        return "Xiaofeijilu{" +
            "id=" + id +
            ", bingrenId=" + bingrenId +
            ", xiaofeijiluContent=" + xiaofeijiluContent +
            ", xiaofeijiluMoney=" + xiaofeijiluMoney +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}

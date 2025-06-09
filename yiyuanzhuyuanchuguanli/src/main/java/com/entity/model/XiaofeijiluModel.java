package com.entity.model;

import com.entity.XiaofeijiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 住院消费
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-08
 */
public class XiaofeijiluModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 发布医生
     */
    private Integer bingrenId;


    /**
     * 消费原因
     */
    private String xiaofeijiluContent;


    /**
     * 消费金额
     */
    private Integer xiaofeijiluMoney;


    /**
     * 消费时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：发布医生
	 */
    public Integer getBingrenId() {
        return bingrenId;
    }


    /**
	 * 设置：发布医生
	 */
    public void setBingrenId(Integer bingrenId) {
        this.bingrenId = bingrenId;
    }
    /**
	 * 获取：消费原因
	 */
    public String getXiaofeijiluContent() {
        return xiaofeijiluContent;
    }


    /**
	 * 设置：消费原因
	 */
    public void setXiaofeijiluContent(String xiaofeijiluContent) {
        this.xiaofeijiluContent = xiaofeijiluContent;
    }
    /**
	 * 获取：消费金额
	 */
    public Integer getXiaofeijiluMoney() {
        return xiaofeijiluMoney;
    }


    /**
	 * 设置：消费金额
	 */
    public void setXiaofeijiluMoney(Integer xiaofeijiluMoney) {
        this.xiaofeijiluMoney = xiaofeijiluMoney;
    }
    /**
	 * 获取：消费时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：消费时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

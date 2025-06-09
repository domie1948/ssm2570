package com.entity.model;

import com.entity.ZhuyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 住院
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-08
 */
public class ZhuyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 住院病人
     */
    private Integer bingrenId;


    /**
     * 住院时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 使用床位
     */
    private Integer chuangweiId;


    /**
     * 花费总金额
     */
    private Integer zhuyuanMoney;


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
	 * 获取：住院病人
	 */
    public Integer getBingrenId() {
        return bingrenId;
    }


    /**
	 * 设置：住院病人
	 */
    public void setBingrenId(Integer bingrenId) {
        this.bingrenId = bingrenId;
    }
    /**
	 * 获取：住院时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：住院时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：使用床位
	 */
    public Integer getChuangweiId() {
        return chuangweiId;
    }


    /**
	 * 设置：使用床位
	 */
    public void setChuangweiId(Integer chuangweiId) {
        this.chuangweiId = chuangweiId;
    }
    /**
	 * 获取：花费总金额
	 */
    public Integer getZhuyuanMoney() {
        return zhuyuanMoney;
    }


    /**
	 * 设置：花费总金额
	 */
    public void setZhuyuanMoney(Integer zhuyuanMoney) {
        this.zhuyuanMoney = zhuyuanMoney;
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

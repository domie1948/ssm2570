package com.entity.model;

import com.entity.YizhuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 医嘱
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-08
 */
public class YizhuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 发布医生
     */
    private Integer yishengId;


    /**
     * 接收病人
     */
    private Integer bingrenId;


    /**
     * 执行护士
     */
    private Integer yonghuId;


    /**
     * 医嘱类型名称
     */
    private Integer yizhuTypes;


    /**
     * 医嘱内容
     */
    private String zhuyuanfeiyongContent;


    /**
     * 消费金额
     */
    private Integer zhuyuanfeiyongMoney;


    /**
     * 发布时间
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
    public Integer getYishengId() {
        return yishengId;
    }


    /**
	 * 设置：发布医生
	 */
    public void setYishengId(Integer yishengId) {
        this.yishengId = yishengId;
    }
    /**
	 * 获取：接收病人
	 */
    public Integer getBingrenId() {
        return bingrenId;
    }


    /**
	 * 设置：接收病人
	 */
    public void setBingrenId(Integer bingrenId) {
        this.bingrenId = bingrenId;
    }
    /**
	 * 获取：执行护士
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：执行护士
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：医嘱类型名称
	 */
    public Integer getYizhuTypes() {
        return yizhuTypes;
    }


    /**
	 * 设置：医嘱类型名称
	 */
    public void setYizhuTypes(Integer yizhuTypes) {
        this.yizhuTypes = yizhuTypes;
    }
    /**
	 * 获取：医嘱内容
	 */
    public String getZhuyuanfeiyongContent() {
        return zhuyuanfeiyongContent;
    }


    /**
	 * 设置：医嘱内容
	 */
    public void setZhuyuanfeiyongContent(String zhuyuanfeiyongContent) {
        this.zhuyuanfeiyongContent = zhuyuanfeiyongContent;
    }
    /**
	 * 获取：消费金额
	 */
    public Integer getZhuyuanfeiyongMoney() {
        return zhuyuanfeiyongMoney;
    }


    /**
	 * 设置：消费金额
	 */
    public void setZhuyuanfeiyongMoney(Integer zhuyuanfeiyongMoney) {
        this.zhuyuanfeiyongMoney = zhuyuanfeiyongMoney;
    }
    /**
	 * 获取：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：发布时间
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

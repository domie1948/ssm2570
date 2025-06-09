package com.entity.model;

import com.entity.BingrenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 病人管理
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-08
 */
public class BingrenModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 病人名称
     */
    private String bingrenName;


    /**
     * 性别
     */
    private Integer sexTypes;


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
     * 患病详情
     */
    private String bingrenContent;


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
	 * 获取：病人名称
	 */
    public String getBingrenName() {
        return bingrenName;
    }


    /**
	 * 设置：病人名称
	 */
    public void setBingrenName(String bingrenName) {
        this.bingrenName = bingrenName;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：年龄
	 */
    public Integer getBingrenAge() {
        return bingrenAge;
    }


    /**
	 * 设置：年龄
	 */
    public void setBingrenAge(Integer bingrenAge) {
        this.bingrenAge = bingrenAge;
    }
    /**
	 * 获取：家属联系方式
	 */
    public String getBingrenPhone() {
        return bingrenPhone;
    }


    /**
	 * 设置：家属联系方式
	 */
    public void setBingrenPhone(String bingrenPhone) {
        this.bingrenPhone = bingrenPhone;
    }
    /**
	 * 获取：检查医生
	 */
    public Integer getYishengId() {
        return yishengId;
    }


    /**
	 * 设置：检查医生
	 */
    public void setYishengId(Integer yishengId) {
        this.yishengId = yishengId;
    }
    /**
	 * 获取：患病类型
	 */
    public Integer getHuanbingTypes() {
        return huanbingTypes;
    }


    /**
	 * 设置：患病类型
	 */
    public void setHuanbingTypes(Integer huanbingTypes) {
        this.huanbingTypes = huanbingTypes;
    }
    /**
	 * 获取：患病详情
	 */
    public String getBingrenContent() {
        return bingrenContent;
    }


    /**
	 * 设置：患病详情
	 */
    public void setBingrenContent(String bingrenContent) {
        this.bingrenContent = bingrenContent;
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

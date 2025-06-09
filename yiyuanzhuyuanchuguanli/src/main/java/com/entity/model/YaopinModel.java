package com.entity.model;

import com.entity.YaopinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 药品
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-08
 */
public class YaopinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 药品名称
     */
    private String yaopinName;


    /**
     * 药品类型名称
     */
    private Integer yaopinTypes;


    /**
     * 药品价格
     */
    private Integer yaopinMoney;


    /**
     * 药品图片
     */
    private String yaopinPhoto;


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
	 * 获取：药品名称
	 */
    public String getYaopinName() {
        return yaopinName;
    }


    /**
	 * 设置：药品名称
	 */
    public void setYaopinName(String yaopinName) {
        this.yaopinName = yaopinName;
    }
    /**
	 * 获取：药品类型名称
	 */
    public Integer getYaopinTypes() {
        return yaopinTypes;
    }


    /**
	 * 设置：药品类型名称
	 */
    public void setYaopinTypes(Integer yaopinTypes) {
        this.yaopinTypes = yaopinTypes;
    }
    /**
	 * 获取：药品价格
	 */
    public Integer getYaopinMoney() {
        return yaopinMoney;
    }


    /**
	 * 设置：药品价格
	 */
    public void setYaopinMoney(Integer yaopinMoney) {
        this.yaopinMoney = yaopinMoney;
    }
    /**
	 * 获取：药品图片
	 */
    public String getYaopinPhoto() {
        return yaopinPhoto;
    }


    /**
	 * 设置：药品图片
	 */
    public void setYaopinPhoto(String yaopinPhoto) {
        this.yaopinPhoto = yaopinPhoto;
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

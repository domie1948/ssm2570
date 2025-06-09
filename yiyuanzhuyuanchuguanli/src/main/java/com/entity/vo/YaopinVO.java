package com.entity.vo;

import com.entity.YaopinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 药品
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-08
 */
@TableName("yaopin")
public class YaopinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "create_time")
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

}

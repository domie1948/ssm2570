package com.entity.vo;

import com.entity.ChuangweiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 床位
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-08
 */
@TableName("chuangwei")
public class ChuangweiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 床位编号
     */

    @TableField(value = "chuangwei_name")
    private String chuangweiName;


    /**
     * 床位状态
     */

    @TableField(value = "chuangwei_types")
    private Integer chuangweiTypes;


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
	 * 设置：床位编号
	 */
    public String getChuangweiName() {
        return chuangweiName;
    }


    /**
	 * 获取：床位编号
	 */

    public void setChuangweiName(String chuangweiName) {
        this.chuangweiName = chuangweiName;
    }
    /**
	 * 设置：床位状态
	 */
    public Integer getChuangweiTypes() {
        return chuangweiTypes;
    }


    /**
	 * 获取：床位状态
	 */

    public void setChuangweiTypes(Integer chuangweiTypes) {
        this.chuangweiTypes = chuangweiTypes;
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

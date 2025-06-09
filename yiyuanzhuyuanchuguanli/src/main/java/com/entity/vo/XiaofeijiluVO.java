package com.entity.vo;

import com.entity.XiaofeijiluEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 住院消费
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-08
 */
@TableName("xiaofeijilu")
public class XiaofeijiluVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


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

}

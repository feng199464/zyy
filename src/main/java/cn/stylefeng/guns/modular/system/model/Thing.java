package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zyy
 * @since 2019-04-01
 */
@TableName("thing")
public class Thing extends Model<Thing> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 事件标题
     */
    private String title;
    /**
     * 发布信息
     */
    private String information;
    /**
     *  审核状态(0.待审核  1.已审核)
     */
    private Integer type;
    /**
     * 审核结果(0.审核失败 1.审核成功)
     */
    private Integer result;
    
    @TableField(exist=false)
    private String thing;
    
    private String content;

    
    

    public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getThing() {
		return thing;
	}

	public void setThing(String thing) {
		this.thing = thing;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
	public String toString() {
		return "Thing [id=" + id + ", title=" + title + ", information=" + information + ", type=" + type + ", result="
				+ result + ", thing=" + thing + ", content=" + content + "]";
	}
}

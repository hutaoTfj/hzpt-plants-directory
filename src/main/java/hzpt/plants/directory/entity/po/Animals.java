package hzpt.plants.directory.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @Author: tfj
 * @Date: 2021/6/7 16
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_animals")
@ApiModel(value="animals", description="")
public class Animals {
    private String id ;

    @ApiModelProperty(value = "动物名称")
    @TableField("animalName")
    private String animalName;

    @ApiModelProperty(value = "别名")
    private String alias;

    @ApiModelProperty(value = "图片地址")
    @TableField("imagesUrl")
    private String imagesUrl;

    @ApiModelProperty(value = "描述信息")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "种类id")
    @TableField("speciesId")
    private String speciesId;

    @ApiModelProperty(value = "分布区域id")
    @TableField("address")
    private String address;

    @ApiModelProperty(value = "备注")
    @TableField("remarks")
    private String remarks;

    @ApiModelProperty(value = "逻辑删除，1删除，0没删除")
    private Integer deleted;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private Date createTime;

    @TableField("modifyTime")
    private Date modifyTime;

}

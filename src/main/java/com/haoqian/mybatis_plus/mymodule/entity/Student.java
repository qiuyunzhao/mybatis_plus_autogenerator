package com.haoqian.mybatis_plus.mymodule.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 学生
 * </p>
 *
 * @author haoqian
 * @since 2020-12-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_student")
@ApiModel(value="Student对象", description="学生")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "学生姓名")
    private String name;

    @ApiModelProperty(value = "学生年龄")
    private Integer age;

    @ApiModelProperty(value = "学生年纪")
    private String grade;

    @ApiModelProperty(value = "学生状态")
    private String status;

    @ApiModelProperty(value = "是否删除（0:未删除、1:已删除）")
    @TableLogic
    private Integer deleted;


}

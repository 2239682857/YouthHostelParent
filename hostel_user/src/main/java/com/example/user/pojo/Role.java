package com.example.user.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author 流星紫蝶雨
 * @Date 2020/9/2 20:04
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@ToString
@TableName(value = "tb_role")
public class Role implements Serializable {

    @TableId(value = "id")
    private String id;

    private String role;

    private String remarks;


}

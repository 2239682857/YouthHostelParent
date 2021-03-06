package com.example.user.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName(value = "tb_user")
public class IUser implements Serializable {

    @TableId(value = "id")
    private String id;

    private String openid;

    private String nickname;

    @TableField(value = "avatar_url")
    private String avatarUrl;

    private Integer gender;

    private String country;

    private String province;

    private String city;

    private String language;

    private String ctime;

    private String mobile;

}

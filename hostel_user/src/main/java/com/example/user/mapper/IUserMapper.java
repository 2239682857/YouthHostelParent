package com.example.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.user.pojo.IUser;
import org.apache.ibatis.annotations.Param;

/**
 * @Author 流星紫蝶雨
 * @Date 2020/8/7 10:01
 * @Version 1.0
 */
public interface IUserMapper extends BaseMapper<IUser> {


    /**
     * 根据OpenId查询用户
     *
     * @param openid
     * @return
     */
    IUser findByOpenid(@Param("openid") String openid);

    /**
     * 给用户添加权限
     *
     * @param userId
     * @param roleId
     */
    void bindUserRole(@Param("userId") String userId, @Param("roleId") String roleId);
}

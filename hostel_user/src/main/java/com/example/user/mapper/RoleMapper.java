package com.example.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.user.pojo.Role;
import org.apache.ibatis.annotations.Param;

/**
 * @Author 流星紫蝶雨
 * @Date 2020/8/7 10:00
 * @Version 1.0
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据权限名称搜索
     *
     * @param role
     * @return
     */
    Role findByRole(String role);

    /**
     * 根据用户ID查询权限
     *
     * @param userId
     * @return
     */
    Role findByUserId(@Param("userId") String userId);
}

package com.example.user.dao;

import com.example.user.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author 流星紫蝶雨
 * @Date 2020/8/7 10:01
 * @Version 1.0
 */
public interface UserDao extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {


    /**
     * 根据OpenId查询用户
     *
     * @param openid
     * @return
     */
    User findByOpenid(String openid);

    /**
     * 给用户添加权限
     * @param userId
     * @param roleId
     */
    @Modifying
    @Query(value = "insert into user_role (user_id,role_id) values (?1,?2)", nativeQuery = true)
    void bindUserRole(String userId, String roleId);
}

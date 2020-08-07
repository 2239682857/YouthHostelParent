package com.example.user.dao;

import com.example.user.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author 流星紫蝶雨
 * @Date 2020/8/7 10:01
 * @Version 1.0
 */
public interface UserDao extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
}

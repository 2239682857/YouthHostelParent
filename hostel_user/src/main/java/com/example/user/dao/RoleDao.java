package com.example.user.dao;

import com.example.user.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author 流星紫蝶雨
 * @Date 2020/8/7 10:00
 * @Version 1.0
 */
public interface RoleDao extends JpaRepository<Role, String>, JpaSpecificationExecutor<Role> {
}

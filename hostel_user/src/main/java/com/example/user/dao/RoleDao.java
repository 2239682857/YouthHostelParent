package com.example.user.dao;

import com.example.user.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author 流星紫蝶雨
 * @Date 2020/8/7 10:00
 * @Version 1.0
 */
public interface RoleDao extends JpaRepository<Role, String>, JpaSpecificationExecutor<Role> {

    Role findByRole(String role);

    /**
     * 根据用户ID查询权限
     * @param userId
     * @return
     */
    @Query(value = "select * from tb_role r inner join user_role ur on r.id = ur.role_id and ur.user_id = ?1",nativeQuery = true)
    Role findByUserId(String userId);
}

package com.example.user.service;

import com.example.user.dao.UserDao;
import com.example.user.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 流星紫蝶雨
 * @Date 2020/8/7 10:04
 * @Version 1.0
 */
@Service
@Transactional
public class UserService {
    @Resource
    private UserDao userDao;

    /**
     * 查询全部
     *
     * @return
     */
    public List<User> findAll() {
        return userDao.findAll();
    }

}

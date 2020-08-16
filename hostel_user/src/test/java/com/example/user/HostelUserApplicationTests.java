package com.example.user;

import com.example.user.mapper.IUserMapper;
import com.example.user.pojo.IUser;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@MapperScan("com.example.user.dao")
class HostelUserApplicationTests {

    @Resource
    private IUserMapper userMapper;

    @Test
    void contextLoads() {
        IUser user = userMapper.findByOpenid("oD3tP5TQKETwY7a1uWQURuvGU9Xc");
        System.out.println(user);
    }

}

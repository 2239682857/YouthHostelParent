package com.example.user.controller;

import com.example.user.service.UserService;
import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author 流星紫蝶雨
 * @Date 2020/8/7 10:05
 * @Version 1.0
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 测试
     *
     * @return
     */
    @RequestMapping
    public Result test() {
        return new Result(true, StatusCode.OK, "Hello Word");
    }

    /**
     * 查询全部
     *
     * @return
     */
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", userService.findAll());
    }

    /**
     * 微信鉴权
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/authorization", method = RequestMethod.POST)
    public Result authorization(@RequestBody String params) {
        Map<String, Object> resultMap = userService.authorization(params);
        return new Result(true, StatusCode.OK, "成功调用", resultMap);
    }

}

package com.example.user.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 流星紫蝶雨
 * @version 1.0
 * @date 2020/8/16 9:31 上午
 */
@RestController
public class TestController {
    @RequestMapping
    public Result test() {
        return new Result(true, StatusCode.OK, "Hello Word");
    }
}

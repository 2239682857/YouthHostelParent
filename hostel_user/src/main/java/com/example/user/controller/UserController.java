package com.example.user.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.user.service.UserService;
import com.example.user.util.WeChatUtil;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author 流星紫蝶雨
 * @Date 2020/8/7 10:05
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @Value("${WeChat.appId}")
    private String appId;

    @Value("${WeChat.secret}")
    private String secret;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", userService.findAll());
    }

    @RequestMapping(value = "/authorization", method = RequestMethod.POST)
    public Result authorization(@RequestBody String params) {
        String weChatCode = JSON.parseObject(params).getString("weChatCode");
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret=" + secret + "&js_code=" + weChatCode + "&grant_type=authorization_code";
        String str = WeChatUtil.httpRequest(url, "GET", null);
        JSONObject jsonObject = JSONObject.parseObject(str);
        String openid = jsonObject.getString("openid");
        return new Result(true, StatusCode.OK, "成功调用", openid);
    }

}

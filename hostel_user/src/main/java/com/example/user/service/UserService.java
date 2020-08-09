package com.example.user.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.user.dao.RoleDao;
import com.example.user.dao.UserDao;
import com.example.user.pojo.Role;
import com.example.user.pojo.User;
import com.example.user.util.WeChatUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Resource
    private RoleDao roleDao;


    @Value("${WeChat.appId}")
    private String appId;

    @Value("${WeChat.secret}")
    private String secret;

    @Resource
    private IdWorker idWorker;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 查询全部
     *
     * @return
     */
    public List<User> findAll() {
        return userDao.findAll();
    }


    /**
     * 登陆验证
     *
     * @param params
     * @return
     */
    public Map<String, Object> authorization(String params) {
        Map<String, Object> resultMap = null;
        String weChatCode = JSON.parseObject(params).getString("weChatCode");
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret=" + secret + "&js_code=" + weChatCode + "&grant_type=authorization_code";
        String str = WeChatUtil.httpRequest(url, "GET", null);
        JSONObject jsonObject = JSONObject.parseObject(str);
        if (jsonObject.containsKey("openid")) {
            resultMap = new HashMap<>();
            String openid = jsonObject.getString("openid");
            User user = userDao.findByOpenid(openid);
            Role role = null;
            if (user == null) {
                user = new User();
                user.setId(idWorker.nextId() + "");
                user.setOpenid(openid);
                user.setCtime(simpleDateFormat.format(new Date()));
                role = roleDao.findByRole("user");
                userDao.save(user);
                userDao.bindUserRole(user.getId(), role.getId());
            } else {
                role = roleDao.findByUserId(user.getId());
            }
            resultMap.put("role", role.getRole());
            resultMap.put("openId", openid);

        }

        return resultMap;

    }
}

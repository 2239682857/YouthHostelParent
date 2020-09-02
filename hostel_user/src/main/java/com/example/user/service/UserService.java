package com.example.user.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.user.mapper.IUserMapper;
import com.example.user.mapper.RoleMapper;
import com.example.user.pojo.IUser;
import com.example.user.pojo.Role;
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
@Transactional(rollbackFor = Exception.class)
public class UserService {

    @Resource
    private IUserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;


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
    public List<IUser> findAll() {
        return userMapper.selectList(null);
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
        String key = "openid";
        if (jsonObject.containsKey(key)) {
            resultMap = new HashMap<>(16);
            String openid = jsonObject.getString("openid");
            IUser user = userMapper.findByOpenid(openid);
            Role role = null;
            if (user == null) {
                user = new IUser();
                user.setId(idWorker.nextId() + "");
                user.setOpenid(openid);
                user.setCtime(simpleDateFormat.format(new Date()));
                role = roleMapper.findByRole("user");
                userMapper.insert(user);
                userMapper.bindUserRole(user.getId(), role.getId());
            } else {
                role = roleMapper.findByUserId(user.getId());
            }
            resultMap.put("role", role.getRole());
            resultMap.put("openId", openid);

        }

        return resultMap;

    }
}

package com.example.user.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User {
    @Id
    private String id;
    private String openid;
    private String nickname;
    private String avatarurl;
    private Integer gender;
    private String country;
    private String province;
    private String city;
    private String language;
    private String ctime;
    private String mobile;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }


    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }


    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}

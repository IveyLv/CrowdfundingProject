package com.ivey.security.entity;

/**
 * @Description
 * @Author IveyLv
 * @Date 2020/7/6 10:29
 * @Version 1.0
 */
public class Admin {

    private Integer id;

    private String loginName;

    private String password;

    private String username;

    private String email;

    private String createTime;

    public Admin() {
    }

    public Admin(Integer id, String loginName, String password, String username, String email, String createTime) {
        this.id = id;
        this.loginName = loginName;
        this.password = password;
        this.username = username;
        this.email = email;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}

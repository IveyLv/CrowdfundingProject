package com.ivey.crowd.entity;

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
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
package com.ivey.security.config;

import com.ivey.security.entity.Admin;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author IveyLv
 * @Date 2020/7/6 10:24
 * @Version 1.0
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 总目标：根据表单提交的用户名查询 User 对象，并装配角色、权限等信息
     * @param username 表单提交的用户名
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 1. 从数据库查询 Admin 对象
        String sql = "select id, loginName, password, username, email from tb_admin where loginName=?";

        List<Admin> adminList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Admin.class), username);

        Admin admin = adminList.get(0);

        // 2. 给 Admin 设置角色权限信息
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        authorities.add(new SimpleGrantedAuthority("UPDATE"));

        // 3. 把 Admin 对象和 authorities 封装到UserDetails中
        String password = admin.getPassword();

        return new User(username, password, authorities);
    }
}

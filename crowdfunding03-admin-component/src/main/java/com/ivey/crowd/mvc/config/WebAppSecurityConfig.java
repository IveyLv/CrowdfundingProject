package com.ivey.crowd.mvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Description
 * @Author IveyLv
 * @Date 2020/7/6 15:04
 * @Version 1.0
 */
@Configuration
@EnableWebSecurity
public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {

        builder.inMemoryAuthentication()    // 在内存中完成账号、密码的检查
                .withUser("Tom")    // 指定账号
                .password("123456") // 指定密码
                .roles("ADMIN", "学徒") // 指定当前用户角色
                .and()
                .withUser("Jerry")
                .password("123456")
                .authorities("UPDATE", "内门弟子")
                ;
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {

        security.authorizeRequests()
                .antMatchers("/admin/to/login/page.html")
                .permitAll()
                .antMatchers("/bootstrap/**")
                .permitAll()
                .antMatchers("/css/**")
                .permitAll()
                .antMatchers("/fonts/**")
                .permitAll()
                .antMatchers("/img/**")
                .permitAll()
                .antMatchers("/jquery/**")
                .permitAll()
                .antMatchers("/layer/**")
                .permitAll()
                .antMatchers("/script/**")
                .permitAll()
                .antMatchers("/ztree/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .disable()
                .formLogin()    // 使用表单形式登录
                .loginPage("/admin/to/login/page.html")   // 指定登录页面（如果没有指定会访问SpringSecurity自带的登录页）
                // loginProcessingUrl() 方法指定了登录地址，就会覆盖loginPage()方法中设置的默认值(/index.jsp POST)
                .loginProcessingUrl("/security/do/login.html")  // 指定提交登录表单的地址
                .usernameParameter("loginName") // 定制登录账号的请求参数名
                .passwordParameter("password")  // 定制登录密码的请求参数名
                .defaultSuccessUrl("/admin/to/main/page.html")    // 登录成功后前往的地址
                ;
    }
}

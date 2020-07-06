package com.ivey.crowd.mvc.interceptor;

import com.ivey.crowd.constant.CrowdConstant;
import com.ivey.crowd.entity.Admin;
import com.ivey.crowd.exception.AccessForbiddenException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description
 * @Author IveyLv
 * @Date 2020/7/2 15:04
 * @Version 1.0
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 1. 通过request对象获取Session对象
        HttpSession session = request.getSession();

        // 2. 尝试从Session域中获取Admin对象
        Admin admin = (Admin) session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN);

        // 3. 判断admin对象是否为空
        if (admin == null) {

            // 4. 抛出异常
            throw new AccessForbiddenException(CrowdConstant.MESSAGE_ACCESS_FORBIDDEN);
        }

        // 5. 如果 Admin 对象不为 null, 则返回true放行
        return true;
    }
}

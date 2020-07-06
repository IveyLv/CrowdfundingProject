package com.ivey.crowd.mvc.config;

import com.google.gson.Gson;
import com.ivey.crowd.constant.CrowdConstant;
import com.ivey.crowd.exception.LoginFailedException;
import com.ivey.crowd.util.CrowdUtil;
import com.ivey.crowd.util.ResultEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description @ControllerAdvice表示当前类是一个基于注解的异常处理类
 * @Author IveyLv
 * @Date 2020/7/1 10:22
 * @Version 1.0
 */
@ControllerAdvice
public class CrowdExceptionResolver {

    /**
     * 处理登录失败异常
     */
    @ExceptionHandler(value = LoginFailedException.class)
    public ModelAndView resolverLoginException(LoginFailedException exception, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String viewName = "admin-login";
        return commonResolver(exception, request, response, viewName);
    }

    /**
     * @ExceptionHandler 将一个具体的异常类型和一个方法关联起来
     * @param exception 实际捕获到的异常类型
     * @param request 当前请求对象
     * @param response 当前响应对象
     */
    @ExceptionHandler(value = ArithmeticException.class)
    public ModelAndView resolverArithmeticException(ArithmeticException exception, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String viewName = "system-error";
        return commonResolver(exception, request, response, viewName);
    }

    /**
     * @ExceptionHandler 将一个具体的异常类型和一个方法关联起来
     * @param exception 实际捕获到的异常类型
     * @param request 当前请求对象
     * @param response 当前响应对象
     */
    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView resolverNullPointException(NullPointerException exception, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String viewName = "system-error";
        return commonResolver(exception, request, response, viewName);
    }

    /**
     * @param exception 实际捕获到的异常类型
     * @param request 当前请求对象
     * @param response 当前响应对象
     * @param viewName 要跳转的视图页面
     */
    private ModelAndView commonResolver(Exception exception, HttpServletRequest request, HttpServletResponse response,
                                       String viewName) throws IOException {

        // 1. 判断当前请求类型
        boolean requestType = CrowdUtil.judgeRequestType(request);

        // 2. 如果是 Ajax 请求
        if (requestType) {
            // 3. 创建 ResultEntity 对象
            ResultEntity resultEntity = ResultEntity.failed(exception.getMessage());

            // 4. 创建 Gson 对象
            Gson gson = new Gson();

            // 5. 将 ResultEntity 对象转换为 JSON 字符串
            String json = gson.toJson(resultEntity);

            // 6. 将 JSON 字符串作为响应体返回给浏览器
            response.getWriter().write(json);

            // 7. 由于上面已经通过原生的 Response 对象返回了响应，所以不提供 ModelAndView 对象
            return null;
        }

        // 8. 如果不是 Ajax 请求则创建 ModelAndView 对象
        ModelAndView modelAndView = new ModelAndView();

        // 9. 将 Exception 对象存入模型
        modelAndView.addObject(CrowdConstant.ATTR_NAME_EXCEPTION, exception);

        // 10. 设置对应的视图名称
        modelAndView.setViewName(viewName);

        // 11. 返回 ModelAndView 对象
        return modelAndView;
    }
}

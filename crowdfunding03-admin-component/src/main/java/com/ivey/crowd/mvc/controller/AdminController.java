package com.ivey.crowd.mvc.controller;

import com.github.pagehelper.PageInfo;
import com.ivey.crowd.constant.CrowdConstant;
import com.ivey.crowd.entity.Admin;
import com.ivey.crowd.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Description
 * @Author IveyLv
 * @Date 2020/7/2 9:22
 * @Version 1.0
 */
@Controller
public class AdminController {

    @Resource
    private AdminService adminService;

    @RequestMapping(value = "admin/do/login.html", method = RequestMethod.POST)
    public String doLogin(@RequestParam("loginName") String loginName, @RequestParam("password") String password,
                          HttpSession session) {

        Admin admin = adminService.getAdminByLoginName(loginName, password);

        session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN, admin);

        return "redirect:/admin/to/main/page.html";
    }

    @RequestMapping("admin/do/logout.html")
    public String doLogout(SessionStatus status) {
        status.setComplete();

        return "redirect:/admin/to/login/page.html";
    }

    @RequestMapping("admin/get/page.html")
    public String getAdminPageQuery(@RequestParam(value = "keyword", required = false) String keyword,
                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                    Model model) {

        PageInfo<Admin> adminPageInfo = adminService.getAdminByPage(keyword, pageNum, pageSize);

        model.addAttribute(CrowdConstant.ATTR_NAME_PAGE_INFO, adminPageInfo);

        return "admin-page";
    }
}

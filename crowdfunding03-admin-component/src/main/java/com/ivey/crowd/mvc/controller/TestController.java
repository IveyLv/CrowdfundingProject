package com.ivey.crowd.mvc.controller;

import com.ivey.crowd.entity.Admin;
import com.ivey.crowd.service.AdminService;
import com.ivey.crowd.util.CrowdUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description
 * @Author IveyLv
 * @Date 2020/6/29 16:15
 * @Version 1.0
 */
@Controller
public class TestController {

    @Resource
    private AdminService adminService;

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/test/ssm.html")
    public String testSSM(Model model, HttpServletRequest request) {

        boolean requestType = CrowdUtil.judgeRequestType(request);

        logger.info("是否是Ajax请求：" + requestType);

        List<Admin> adminList = adminService.getAll();

        model.addAttribute("adminList", adminList);
        //System.out.println(10 / 0);

        /*String a = null;
        System.out.println(a.length());*/

        return "success";
    }

    @RequestMapping(value = "send/array.html", method = RequestMethod.POST)
    @ResponseBody
    public String testReceiveArrayOne(@RequestParam("array[]") List<Integer> list, HttpServletRequest request) {

        boolean requestType = CrowdUtil.judgeRequestType(request);

        logger.info("是否是Ajax请求：" + requestType);

        System.out.println(list);

        /*String a = null;
        System.out.println(a.length());*/

        return "success";
    }
}

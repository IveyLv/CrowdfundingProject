package com.ivey.crowd.mvc.controller;

import com.ivey.crowd.entity.Admin;
import com.ivey.crowd.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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

    @RequestMapping("/test/ssm.html")
    public String testSSM(Model model) {
        List<Admin> adminList = adminService.getAll();

        model.addAttribute("adminList", adminList);

        return "success";
    }

    @RequestMapping(value = "send/array.html", method = RequestMethod.POST)
    @ResponseBody
    public String testReceiveArrayOne(@RequestParam("array[]") List<Integer> list) {
        System.out.println(list);

        return "success";
    }
}

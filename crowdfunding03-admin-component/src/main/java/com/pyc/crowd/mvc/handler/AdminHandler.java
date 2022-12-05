package com.pyc.crowd.mvc.handler;

import com.pyc.crowd.constant.CrowdConstant;
import com.pyc.crowd.entity.Admin;
import com.pyc.crowd.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author 彭远春
 * @create 2022-12-05 15:31
 */
@Controller
public class AdminHandler {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/admin/do/login.html")
    public String doLogin(@RequestParam("loginAcct") String loginAcct, @RequestParam("userPswd") String userPswd,
                          HttpSession session) {
        //调用service执行登陆检查
        Admin admin = adminService.getAdminByLoginAcct(loginAcct,userPswd);
        session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN,admin);
        return "redirect:/admin/to/main/page.html";
    }

    @RequestMapping("admin/do/logout.html")
    public String doLogout(HttpSession session){
        // 强制session失效
        session.invalidate();
        return "redirect:/admin/to/login/page.html";
    }
}

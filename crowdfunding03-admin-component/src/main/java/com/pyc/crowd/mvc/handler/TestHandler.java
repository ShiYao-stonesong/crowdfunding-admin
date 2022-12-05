package com.pyc.crowd.mvc.handler;

import com.pyc.crowd.entity.Admin;
import com.pyc.crowd.entity.Student;
import com.pyc.crowd.service.api.AdminService;
import com.pyc.crowd.util.CrowdUtil;
import com.pyc.crowd.util.ResultEntity;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 彭远春
 * @create 2022-11-23 15:44
 */
@Controller
public class TestHandler {
    @Autowired
    private AdminService adminService;

    private Logger logger = LoggerFactory.getLogger(TestHandler.class);

    @RequestMapping("/send/array.json")
    @ResponseBody
    public ResultEntity<Student> testReceiveArrayOne(@RequestBody Student student){
        System.out.println("******");
        // logger.debug(student.toString());
        System.out.println(student.toString());
        return ResultEntity.successWithData(student);
    }

    @RequestMapping("/test/ssm.html")
    public String testSsm(ModelMap modelMap, HttpServletRequest request){
        boolean judgeRequestType = CrowdUtil.judgeRequestType(request);
        System.out.println("judgeRequestType="+judgeRequestType);
        List<Admin> list = adminService.getAll();
        modelMap.addAttribute("adminList",list);
        // System.out.println(10/0);
        return "target";
    }

    @RequestMapping("/test.html")
    @ResponseBody
    public String test(){
        System.out.println("走到这里");
        return "nothing at all";
    }
}

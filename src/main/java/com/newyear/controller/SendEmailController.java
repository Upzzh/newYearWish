package com.newyear.controller;

import com.newyear.pojo.RspResult;
import com.newyear.pojo.User;
import com.newyear.service.SendEmailService;
import com.newyear.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName SendEmailController
 * @Description TODO
 * @Date2020/1/22 14:06
 **/
@RestController
@RequestMapping("/email")
public class    SendEmailController {
    private static Logger logger = LoggerFactory.getLogger(SendEmailController.class);

    @Autowired
    private SendEmailService sendEmailService;
    @Autowired
    private UserService  userService;

    /**
     * 测试普通邮件调用
     */
    @RequestMapping(value = "/simpleEmail", method = {RequestMethod.GET})
    public RspResult sendSimpleEmail(HttpServletRequest request) {
        RspResult rspResult = new RspResult();
        List<User> userList = userService.findAll();
        System.out.println(userList.size());
        //去库中取用户邮箱
        userList.forEach(user -> {
            sendEmailService.sendSimpleMail(user.getEmail(), "新年祝福", "可可爱的"+user.getUserName()+"：新年快乐,新的一年里顺顺利利，发大财哦！最近出去记得戴口罩哦~");
        });

        rspResult.setStatus(200);
        rspResult.setMsg("调用成功");
        return rspResult;
    }
}

package com.newyear.service;


import com.newyear.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName SendEmailService
 * @Description TODO
 * @Date2020/1/22 14:07
 **/
@Service
public class SendEmailService {

    private static Logger logger = LoggerFactory.getLogger(SendEmailService.class);

    @Autowired
    private JavaMailSender sender;


    @Value("${spring.mail.username}")
    private String fromMail;

    /**
     * 发送普通邮件
     *
     * @param toMail  收件方
     * @param subject 标题
     * @param content 邮件内容
     */
    public void sendSimpleMail(String toMail, String subject,  String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromMail);
        simpleMailMessage.setTo(toMail);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);
        try {
            sender.send(simpleMailMessage);
            logger.info("发送给:{} 邮件已经发送。 subject:{}", toMail, subject);
        } catch (Exception e) {
            logger.info("发送给:{} send mail error subject:{}", toMail, subject);
            e.printStackTrace();
        }
    }
}

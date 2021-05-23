package com.example.myblog.component;

import com.example.myblog.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailComponent {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username")
    private String from;
    public void sendMail(String email, int code){
        String content = "<h3>您正在注册博客网站</h3>\n" +
                "\t\t<h3>请点击下方的连接激活邮箱</h3>\n" +
                "<a href=\"http://localhost:8080/user/active?id=" + code + "\"" + ">激活邮箱</a>";
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("注册");
        mailMessage.setFrom(from);
        mailMessage.setTo(email);
        mailMessage.setText(content);
        try {
            javaMailSender.send(mailMessage);
        }catch (Exception e){
            throw new ServiceException("邮箱发送失败");
        }
    }
}

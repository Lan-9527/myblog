package com.example.myblog.component;

import com.example.myblog.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class MailComponent {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String from;
    public void sendMail(String email, int code) {
        MimeMessage message = javaMailSender.createMimeMessage();
        String content = "<html>\n"+"<body>\n"+
                "<h3>您正在注册博客网站</h3>\n" +
                "\t\t<h3>请点击下方的连接激活邮箱</h3>\n" +
                "<a href=\"http://localhost:8081/user/active?id=" + code + "\"" + ">激活邮箱</a>" +
                 "</body>\n"+"</html>\n";
        MimeMessageHelper mailMessage = null;
        try {
            mailMessage = new MimeMessageHelper(message,true);
            mailMessage.setSubject("注册");
            mailMessage.setFrom(from);
            mailMessage.setTo(email);
            mailMessage.setText(content, true);
            System.out.println(from);
            javaMailSender.send(message);
        }catch (Exception e){
            throw new ServiceException("邮箱发送失败："+e.getMessage() );
        }
    }
}

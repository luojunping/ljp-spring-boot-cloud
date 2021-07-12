package com.ljp.test.mail;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/7/5
 * @since 1.0.0
 **/
public class MailTest {

    public static void main(String[] args) throws MessagingException, GeneralSecurityException {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.host", "smtp.qq.com");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        Session session = Session.getDefaultInstance(properties);
        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom("1362266598@qq.com");
        mimeMessage.addRecipients(Message.RecipientType.TO, "591402399@qq.com");
        mimeMessage.addRecipients(Message.RecipientType.TO, "luojunping800@163.com");
        mimeMessage.setSubject("中文 this is a java mail !!!", "UTF-8");
        mimeMessage.setText("<h2>mail success</h2><p>邮件终于发送成功了！！！</p>", "UTF-8");
        Transport transport = session.getTransport();
        transport.connect("1362266598@qq.com", "lrl03503627905");
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
    }

}

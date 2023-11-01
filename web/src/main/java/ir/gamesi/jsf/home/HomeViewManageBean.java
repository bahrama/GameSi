package ir.gamesi.jsf.home;

import jakarta.annotation.Resource;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.Serializable;
import java.util.List;
import java.util.Properties;

@ViewScoped
@Named
public class HomeViewManageBean implements Serializable {
    @Resource(name = "java:jboss/mail/Default")
    private Session sessionSend;

    public void actBoss() {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "mail.gamesi.ir");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.ssl.trust", "mail.gamesi.ir");
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("admin@gamesi.ir", "ali680313ALI^*)#!#");
            }
        });

        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("admin@gamesi.ir"));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse("alialikhahasl@gmail.com"));
            message.setSubject("Mail Subject");

            String msg = "This is my first email using JavaMailer";

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}

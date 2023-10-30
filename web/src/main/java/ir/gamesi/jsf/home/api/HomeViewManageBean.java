package ir.gamesi.jsf.home.api;

import ir.gamesi.ejb.dto.api.product.ProductDto;
import ir.gamesi.ejb.service.api.product.ProductApiService;
import jakarta.annotation.Resource;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class HomeViewManageBean implements Serializable {
    @Inject
    private ProductApiService productApiService;
    @Resource(name = "java:jboss/mail/Default")
    private Session sessionSend;
    public List<ProductDto> productDtosByType(String param,int page,int limit){
        actBoss();
        return productApiService.findProducts(param,page,limit);
    }

    public void actBoss() {
        try {
            System.out.println("----------------send------------------");
            Message message = new MimeMessage(sessionSend);
            System.out.println("----------------2------------------");
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("alialikhahasl@gmail.com"));
            System.out.println("----------------3------------------");
            //  message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("ali_alikhahasl@yahoo.com"));
            message.setContent("salalallalalallalallam","text/html; charset=UTF-8");
            System.out.println("----------------4------------------");
            Transport.send(message);
            System.out.println("----------------sended------------------");
        } catch (Exception e) {
        }
    }
}

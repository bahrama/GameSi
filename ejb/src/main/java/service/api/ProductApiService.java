package service.api;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Singleton
@Startup
public class ProductApiService {
    @PostConstruct
    public void findProducts(){
        Client client = ClientBuilder.newClient();
        Response response = client.target("http://localhost:8090/api/products/xbox")
                .request(MediaType.APPLICATION_JSON)
                .get();
    }
}

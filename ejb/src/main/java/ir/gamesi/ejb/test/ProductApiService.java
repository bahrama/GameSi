/*
package ir.gamesi.ejb.test;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Stateless
@LocalBean
public class ProductApiService {

*/
/*    private int count;
    public List<ProductDto> findProducts(String titreSearch , int page , int limit){
        String url = "http://localhost:8090/api/products/" + titreSearch;
        Client client = ClientBuilder.newClient();
        Response response = client.target(url)
                .request(MediaType.APPLICATION_JSON)
                .get();
        String json=response.readEntity(String.class);
        Gson gson = new Gson();
        List productReses = gson.fromJson(json,List.class);
        List<ProductDto> productDtos = new ArrayList<>();
        productReses.stream().skip(page-1*limit).limit(limit).forEach(p->{
            LinkedTreeMap<String,Object> treeMap = (LinkedTreeMap<String, Object>) p;
            productDtos.add(ProductDtoManager.productToDto(treeMap));
        });
        count = productDtos.size();
        return productDtos;
    }

    public int countHome() {
        return count;
    }*//*

}
*/

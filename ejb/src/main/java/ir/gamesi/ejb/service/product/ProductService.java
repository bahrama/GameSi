package ir.gamesi.ejb.service.product;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import ir.gamesi.ejb.dao.product.ProductDao;
import ir.gamesi.ejb.dto.product.ProductDto;
import ir.gamesi.ejb.dto.product.ProductDtoManager;
import ir.gamesi.ejb.model.Product;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.mapstruct.factory.Mappers;

import java.util.*;

@Stateless
@LocalBean
public class ProductService {

    @Inject
    private ProductDao productDao;

    private ProductDtoManager productDtoManager = Mappers.getMapper(ProductDtoManager.class);

    public int count() {
        return productDao.countEntity();
    }

    public ProductDto findProductById(Long aLong) {
        ProductDto productDto = productDtoManager.transferProductToDto(productDao.findById(aLong).get());
        return productDto;
    }

    public List<ProductDto> search(int offset, int pageSize, Map<String, String> sort, Map<String, String> filter) {
        List<Product> products = productDao.search(offset,pageSize,sort,filter);
        List<ProductDto> productDtos = new ArrayList<>();
        products.forEach(p->{
            productDtos.add(productDtoManager.transferProductToDto(p));
        });
        return productDtos;
    }

    public Optional<Product> save(ProductDto productDto) throws Exception {
        return productDao.save(productDtoManager.transferProductDtoToEntity(productDto));
    }

    public Long delete(ProductDto productDto){
        return productDao.delete(productDtoManager.transferProductDtoToEntity(productDto));
    }

    public List<ProductDto> findProductByParam(String param , int page){
        String url = "http://localhost:8090/api/products/" + param + "?page=" + page;
        Client client = ClientBuilder.newClient();
        Response response = client.target(url)
                .request(MediaType.APPLICATION_JSON)
                .get();
        String json=response.readEntity(String.class);
        Gson gson = new Gson();
        List<LinkedTreeMap<String,Object>> productReses = gson.fromJson(json,List.class);
        List<ProductDto> productDtos = new ArrayList<>();
        productReses.stream().forEach(p->{
           // productDtos.add(ProductDtoManager.productToDto(treeMap));
            ProductDto productDto = new ProductDto();
            productDto.setId(((Double) p.get("id")).longValue());
            productDto.setProductId(((Double) p.get("productId")).intValue());
            productDto.setProductName((String) p.get("productName"));
            productDto.setPic1("");
            productDtos.add(productDto);
        });
        return productDtos;
    }

    public int findProductByParamSize(String param){
        String url = "http://localhost:8090/api/products/size/" + param;
        Client client = ClientBuilder.newClient();
        Response response = client.target(url)
                .request(MediaType.APPLICATION_JSON)
                .get();
        String json=response.readEntity(String.class);
        return Integer.valueOf(json);
    }
}

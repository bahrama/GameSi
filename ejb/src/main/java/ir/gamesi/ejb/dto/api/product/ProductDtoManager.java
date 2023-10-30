package ir.gamesi.ejb.dto.api.product;

import com.google.gson.internal.LinkedTreeMap;
import ir.gamesi.ejb.model.product.ProductRes;

import java.util.List;

public class ProductDtoManager {
    public static ProductDto productToDto(LinkedTreeMap<String,Object> treeMap){
        ProductDto productDto = new ProductDto();
        productDto.setProductName((String) treeMap.get("productName"));
        LinkedTreeMap country = (LinkedTreeMap) treeMap.get("country");
        productDto.setCountry(country.get("name").toString());
        LinkedTreeMap brand = (LinkedTreeMap) treeMap.get("brand");
        productDto.setBrandName(brand.get("brandName").toString());
        List logo = (List) treeMap.get("logoUrls");
        productDto.setImgUrl(logo.get(0).toString());
        return productDto;
    }

}

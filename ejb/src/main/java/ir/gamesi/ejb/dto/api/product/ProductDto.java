package ir.gamesi.ejb.dto.api.product;

import ir.gamesi.ejb.model.product.Content;
import ir.gamesi.ejb.model.product.ProductRes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private String imgUrl;
    private String productName;
    private String brandName;
    private String country;

}

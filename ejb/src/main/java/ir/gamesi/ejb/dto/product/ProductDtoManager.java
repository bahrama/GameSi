package ir.gamesi.ejb.dto.product;

import ir.gamesi.ejb.model.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface ProductDtoManager {
    @Mapping(source = "id" , target = "id")
    @Mapping(source = "description" , target = "description")
    @Mapping(source = "pic1" , target = "pic1")
    @Mapping(source = "createDate" , target = "createDate")
    @Mapping(source = "updateDate" , target = "updateDate")
    @Mapping(source = "productId" , target = "productId")
    @Mapping(source = "productName" , target = "productName")
    @Mapping(source = "global" , target = "global")
    @Mapping(source = "supportsPreOrder" , target = "supportsPreOrder")
    @Mapping(source = "senderFee" , target = "senderFee")
    @Mapping(source = "unitPrice" , target = "unitPrice")
    @Mapping(source = "countryCode" , target = "countryCode")
    @Mapping(source = "countryName" , target = "countryName")
    @Mapping(source = "mainSite" , target = "mainSite")
    ProductDto transferProductToDto(Product product);

    @InheritInverseConfiguration
    Product transferProductDtoToEntity(ProductDto productDto);
}

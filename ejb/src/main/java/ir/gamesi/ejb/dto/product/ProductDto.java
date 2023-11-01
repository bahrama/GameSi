package ir.gamesi.ejb.dto.product;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductDto {

    private Long id;
    private Integer productId;
    private String productName;
    private Boolean global;
    private Boolean supportsPreOrder;
    private Double senderFee;
    private Double unitPrice;
    private String currency;
    private String pic1;
    private String countryCode;
    private String countryName;
    private String description;
    private String mainSite;
    private Date createDate;
    private Date updateDate;

}

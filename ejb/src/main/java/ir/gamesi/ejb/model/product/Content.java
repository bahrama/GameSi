package ir.gamesi.ejb.model.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Content implements Serializable {
    private Integer productId;
    private String productName;
    private Boolean global;
    private Boolean supportsPreOrder;
    private Double senderFee;
    private Double senderFeePercentage;
    private Double discountPercentage;
    private String denominationType;
    private String recipientCurrencyCode;
    private Double minRecipientDenomination;
    private Double maxRecipientDenomination;
    private String senderCurrencyCode;
    private Double minSenderDenomination;
    private Double maxSenderDenomination;
    private List<Double> fixedRecipientDenominations;
    private List<Double> fixedSenderDenominations;
    private FixedRecipientToSenderDenominationsMap fixedRecipientToSenderDenominationsMap;
    private Object metadata;
    private List<String> logoUrls;
    private Brand brand;
    private Country country;
    private RedeemInstruction redeemInstruction;
}

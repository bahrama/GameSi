package ir.gamesi.ejb.model.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class RedeemInstruction implements Serializable {
    private String concise;
    private String verbose;
}

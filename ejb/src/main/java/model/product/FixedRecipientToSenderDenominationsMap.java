package model.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class FixedRecipientToSenderDenominationsMap implements Serializable {
    public Double res;
}

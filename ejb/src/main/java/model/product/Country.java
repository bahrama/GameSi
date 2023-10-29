package model.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Country implements Serializable {
    private String isoName;
    private String name;
    private String flagUrl;
}

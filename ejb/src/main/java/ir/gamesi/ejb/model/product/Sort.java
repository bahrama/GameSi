package ir.gamesi.ejb.model.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Sort implements Serializable {
    private Boolean sorted;
    private Boolean unsorted;
    private Boolean empty;
}

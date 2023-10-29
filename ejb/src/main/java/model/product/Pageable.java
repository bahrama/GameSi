package model.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Pageable implements Serializable {
    private Sort sort;
    private Integer pageNumber;
    private Integer pageSize;
    private Integer offset;
    private Boolean unpaged;
    private Boolean paged;
}

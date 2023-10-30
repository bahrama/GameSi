package ir.gamesi.ejb.model.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductRes implements Serializable {
    private List<Content> content;
    private Pageable pageable;
    private Integer totalElements;
    private Boolean last;
    private Integer totalPages;
    private Sort sort;
    private Integer numberOfElements;
    private Boolean first;
    private Integer size;
    private Integer number;
    private Boolean empty;
}

package ir.gamesi.jsf.product;

import ir.gamesi.ejb.dto.product.ProductDto;
import ir.gamesi.ejb.service.product.ProductService;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LazyProductDataModel  extends LazyDataModel<ProductDto> {

    private ProductService productService;

    public LazyProductDataModel(ProductService productService){
        this.productService = productService;
    }

    @Override
    public int count(Map<String, FilterMeta> map) {
        return productService.count();
    }

    @Override
    public ProductDto getRowData(String rowKey) {
        if(!rowKey.equals("null"))
            return productService.findProductById(Long.valueOf(rowKey));
        else
            return new ProductDto();
    }

    @Override
    public String getRowKey(ProductDto productDto) {
        return String.valueOf(productDto.getId());
    }

    @Override
    public List<ProductDto> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
        Map<String,String> filter = new HashMap<>();
        Map<String,String> sort = new HashMap<>();
        if(filterBy.size()>0){
            filterBy.forEach((k,v) ->{
                filter.put(k,v.getFilterValue().toString());
            });
        }
        if(sortBy.size()>0){
            sortBy.forEach((k,v) ->{
                sort.put(k,v.getOrder().name());
            });
        }
        return productService.search(offset,pageSize,sort,filter);
    }
}

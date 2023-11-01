package ir.gamesi.ejb.service.product;

import ir.gamesi.ejb.dao.product.ProductDao;
import ir.gamesi.ejb.dto.product.ProductDto;
import ir.gamesi.ejb.dto.product.ProductDtoManager;
import ir.gamesi.ejb.model.Product;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Stateless
@LocalBean
public class ProductService {

    @Inject
    private ProductDao productDao;

    private ProductDtoManager productDtoManager = Mappers.getMapper(ProductDtoManager.class);

    public int count() {
        return productDao.countEntity();
    }

    public ProductDto findProductById(Long aLong) {
        ProductDto productDto = productDtoManager.transferProductToDto(productDao.findById(aLong).get());
        return productDto;
    }

    public List<ProductDto> search(int offset, int pageSize, Map<String, String> sort, Map<String, String> filter) {
        List<Product> products = productDao.search(offset,pageSize,sort,filter);
        List<ProductDto> productDtos = new ArrayList<>();
        products.forEach(p->{
            productDtos.add(productDtoManager.transferProductToDto(p));
        });
        return productDtos;
    }

    public Optional<Product> save(ProductDto productDto) throws Exception {
        return productDao.save(productDtoManager.transferProductDtoToEntity(productDto));
    }

    public Long delete(ProductDto productDto){
        return productDao.delete(productDtoManager.transferProductDtoToEntity(productDto));
    }
}

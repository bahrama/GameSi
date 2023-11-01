package ir.gamesi.ejb.dao.product;

import ir.gamesi.ejb.dao.base.BaseDaoImpl;
import ir.gamesi.ejb.model.Product;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

import javax.management.Query;
import java.util.List;
@Stateless
@LocalBean
public class ProductDao  extends BaseDaoImpl<Product> {
    public ProductDao(){
        setModelClass(Product.class);
        setClassName("product");
        setSearchParam(Product.FIND_BY_SEARCH_PRODUCT);
    }



}

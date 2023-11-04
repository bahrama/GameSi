package ir.gamesi.jsf.product;

import ir.gamesi.ejb.dto.product.ProductDto;
import ir.gamesi.ejb.service.product.ProductService;
import ir.gamesi.jsf.utils.FileConvertor;
import ir.gamesi.jsf.utils.MessageUtil;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.file.UploadedFile;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ViewScoped
@Named
public class ProductViewManageBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private LazyProductDataModel lazyProductDataModel;

    @Getter
    @Setter
    private ProductDto productDto;

    @Getter
    @Setter
    private UploadedFile pic;

    @Inject
    private ProductService productService;


    @PostConstruct
    public void init(){
        lazyProductDataModel = new LazyProductDataModel(productService);
        productDto = new ProductDto();
    }

    public String convertPicture(UploadedFile uploadedFile) {
        try {
            return FileConvertor.convertPicture(uploadedFile);
        } catch (Exception e) {
            return null;
        }
    }

    private void addPictuer(){
        if(pic!=null) productDto.setPic1(convertPicture(pic));
    }

    public void save(){
        try {
            addPictuer();
            productService.save(productDto);
            MessageUtil.addMessage(FacesMessage.SEVERITY_INFO, "successful", "successful");
        } catch (Exception e) {
            MessageUtil.addMessage(FacesMessage.SEVERITY_ERROR, "Error Message", "Message Content");;
        }
    }

    public void onRowSelect(SelectEvent<ProductDto> event) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/admin/product/product.xhtml?productId=" + event.getObject().getId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onRowUnselect(UnselectEvent<ProductDto> event) {
        MessageUtil.addMessage(FacesMessage.SEVERITY_INFO, "Product Selected", String.valueOf(event.getObject().getId()));
    }

    public void delete(){
        productService.delete(productDto);
    }

    public ProductDto findProductById(Long id){
        this.productDto = productService.findProductById(id);
        if(productDto==null)
            productDto = new ProductDto();
        return productDto;
    }

    public List<ProductDto> findProductByParam(String param , int page){
        productService.findProductByParamSize(param);
       return productService.findProductByParam(param , page);
    }

    public List<Integer> findPagination(String param ,int page){
       int size = productService.findProductByParamSize(param)/16;
       List<Integer> pages = new ArrayList<>();
       for(int i = 1 ; i<=size ; i++){
           pages.add(i);
       }
       return pages.stream().skip(page-1).collect(Collectors.toList());
    }

    public int findLastPage(String param){
        return productService.findProductByParamSize(param)/16;
    }

    public String leftArrow(){
        return ">";
    }

    public String rightArrow(){
        return "<";
    }

    public int limitSize(int totalPage , int page){
        if(totalPage-page>5)
            return 5;
        else
            return totalPage-page;
    }

    public int findCount(String param){
        return productService.findProductByParamSize(param);
    }
}

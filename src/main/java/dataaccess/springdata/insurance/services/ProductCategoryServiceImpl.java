package dataaccess.springdata.insurance.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dataaccess.springdata.insurance.models.ProductCategory;
import dataaccess.springdata.insurance.repositories.ProductCategoryRepository;

/**
 * @author Med
 *
 */


@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{

  @Autowired
  ProductCategoryRepository productCategoryRepository;
  
  
  @Override
  public List<ProductCategory> getAll() {
    List<ProductCategory> productCategoryList = new ArrayList<>();
    productCategoryRepository.findAll().forEach(productCategoryList::add);
    return productCategoryList;
    
  }
  
  public ProductCategory save(ProductCategory productCategory) {
    return productCategoryRepository.save(productCategory);
  }

  @Override
  public ProductCategory findById(Long productCategoryId) {
    Optional<ProductCategory> dbProductCategory = productCategoryRepository.findById(productCategoryId);
    return dbProductCategory.orElse(null);
  }
  

  @Override
  public ProductCategory update(Long productCategoryId, ProductCategory productCategory) {
    
    productCategoryRepository.deleteById(productCategoryId);
   return  productCategoryRepository.save(productCategory);

  }

@Override
public String delete(Long productCategoryId) {

  productCategoryRepository.deleteById(productCategoryId);
 
 return "ProductCategory successfully deleted";

}  


}

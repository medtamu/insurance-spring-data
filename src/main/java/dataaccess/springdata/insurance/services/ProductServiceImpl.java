package dataaccess.springdata.insurance.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import dataaccess.springdata.insurance.models.Product;
import dataaccess.springdata.insurance.repositories.ProductRepository;

/**
 * @author Med
 *
 */


@Service
public class ProductServiceImpl implements ProductService{

  @Autowired
  ProductRepository productRepository;
  
  
  @Override
  public List<Product> getAll() {
    List<Product> productList = new ArrayList<>();
    productRepository.findAll().forEach(productList::add);
    return productList;
    
  }
  
  public Product save(Product product) {
    return productRepository.save(product);
  }

  @Override
  public Product findById(Long productId) {
    Optional<Product> dbProduct = productRepository.findById(productId);
    return dbProduct.orElse(null);
  }
  

  @Override
  public Product update(Long productId, Product product) {
    
    productRepository.deleteById(productId);
   return  productRepository.save(product);

  }

@Override
public String delete(Long productId) {

  productRepository.deleteById(productId);
 
 return "Product successfully deleted";

}  


}

package dataaccess.springdata.insurance.services;

import java.util.List;

import dataaccess.springdata.insurance.models.Product;




public interface ProductService {


 public List<Product> getAll();
  
  public Product save(Product p);
  
  public Product findById(Long productId);
  
  public Product update(Long productId, Product product);

  public String delete(Long productId);


}
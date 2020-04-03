/**
 * 
 */
package dataaccess.springdata.insurance.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import dataaccess.springdata.insurance.models.Product;
import dataaccess.springdata.insurance.services.ProductService;

/**
 * 
 * @author crossover
 */

@RestController
public class ProductController {
  
  @Autowired
  ProductService productService;
  
  @PostMapping(path = "/api/product")
  public ResponseEntity<Product> register(@RequestBody Product product) {
    return ResponseEntity.ok(productService.save(product));
  }
  
  @GetMapping(path = "/api/product")
  public ResponseEntity<List<Product>> getAllProducts() {
    return ResponseEntity.ok(productService.getAll());
  //public String getAllProducts() {
//return ResponseEntity.ok("....welcome....");
  }


  
  @GetMapping(path = "/api/product/{product-id}")
  public ResponseEntity<Product> getProductById(@PathVariable(name="product-id", required=true)Long productId) {
    Product product = productService.findById(productId);
    if (product != null) {
      return ResponseEntity.ok(product);
    }
    else
    return ResponseEntity.notFound().build();
  }
  
 @PutMapping(path = "/api/product/{product-id}")
 public ResponseEntity<Product> updateProductById(@PathVariable(name="product-id", required=true) Long productId, @RequestBody Product product) {
  
  return ResponseEntity.ok(productService.update(productId, product));

 }

@DeleteMapping(path = "/api/product/{product-id}")
public ResponseEntity<Object> deleteProductById(@PathVariable(name="product-id") Long productId) 

{

return ResponseEntity.ok(productService.delete(productId));

}

}

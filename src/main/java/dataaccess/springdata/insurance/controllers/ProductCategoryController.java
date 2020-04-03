
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
import dataaccess.springdata.insurance.models.ProductCategory;
import dataaccess.springdata.insurance.services.ProductCategoryService;



@RestController
public class ProductCategoryController {
  
  @Autowired
  ProductCategoryService productCategoryService;
  
  @PostMapping(path = "/api/productCategory")
  public ResponseEntity<ProductCategory> register(@RequestBody ProductCategory productCategory) {
    return ResponseEntity.ok(productCategoryService.save(productCategory));
  }
  
  @GetMapping(path = "/api/productCategory")
  public ResponseEntity<List<ProductCategory>> getAllProductCategorys() {
    return ResponseEntity.ok(productCategoryService.getAll());
  }


  
  @GetMapping(path = "/api/productCategory/{productCategory-id}")
  public ResponseEntity<ProductCategory> getProductCategoryById(@PathVariable(name="productCategory-id", required=true)Long productCategoryId) {
    ProductCategory productCategory = productCategoryService.findById(productCategoryId);
    if (productCategory != null) {
      return ResponseEntity.ok(productCategory);
    }
    else
    return ResponseEntity.notFound().build();
  }
  
 @PutMapping(path = "/api/productCategory/{productCategory-id}")
 public ResponseEntity<ProductCategory> updateProductCategoryById(@PathVariable(name="productCategory-id", required=true) Long productCategoryId, @RequestBody ProductCategory productCategory) {
  
  return ResponseEntity.ok(productCategoryService.update(productCategoryId, productCategory));

 }

@DeleteMapping(path = "/api/productCategory/{productCategory-id}")
public ResponseEntity<Object> deleteProductCategoryById(@PathVariable(name="productCategory-id") Long productCategoryId) 

{

return ResponseEntity.ok(productCategoryService.delete(productCategoryId));

}

}

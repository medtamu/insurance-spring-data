package dataaccess.springdata.insurance.repositories;

import org.springframework.data.repository.CrudRepository;

import dataaccess.springdata.insurance.models.ProductCategory;



public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {

}
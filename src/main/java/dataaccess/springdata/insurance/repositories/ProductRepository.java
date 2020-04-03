package dataaccess.springdata.insurance.repositories;

import org.springframework.data.repository.CrudRepository;

import dataaccess.springdata.insurance.models.Product;



public interface ProductRepository extends CrudRepository<Product, Long> {

}
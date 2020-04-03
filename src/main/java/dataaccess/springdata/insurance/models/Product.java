package dataaccess.springdata.insurance.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Product")
public class Product {
	
@Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer Id;

@NotNull
private String name;


@ManyToOne
  @JoinColumn(name = "category_id", referencedColumnName = "id")
  private ProductCategory productCategory;


private String description ;


public Integer getId() {

return Id;

}

  public void setId(Integer Id) {
    this.Id = Id;
  }


public String getName() {

return name;


}

public void setName(String name) {

this.name = name;

}

public ProductCategory getProductCategory() {

return productCategory;


}

public void setProductCategory(ProductCategory productCategory) {

this.productCategory = productCategory;

}


public String getDescription() {

return name;


}

public void setDescription(String description) {

this.description = description;

}

}
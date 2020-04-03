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
@Table(name = "ProductCategory")
public class ProductCategory {

@Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer Id;

@NotNull
private String name ;


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


}


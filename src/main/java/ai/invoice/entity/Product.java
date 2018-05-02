package ai.invoice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product extends BaseEntity implements Serializable {
    private String name;
    private Double tax;
    private String type;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference("product-productSale")
    private List<ProductSell> productSells;

    protected Product() {

    }

    public Product(String name, Double tax, String type) {
        this.name = name;
        this.tax = tax;
        this.type = type;
    }

    public Product(Product product) {
        this.name = product.name;
        this.tax = product.tax;
        this.type = product.type;
        this.productSells = product.getProductSells();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ProductSell> getProductSells() {
        return productSells;
    }

    public void setProductSells(List<ProductSell> productSells) {
        this.productSells = productSells;
    }
}

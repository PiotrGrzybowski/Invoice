package ai.invoice.entity;

import javax.persistence.Entity;

@Entity
public class Product extends BaseEntity {
    private String name;
    private Double tax;
    private String type;


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
}
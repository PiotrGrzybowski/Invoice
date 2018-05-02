package ai.invoice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "invoices")
public class Invoice extends BaseEntity implements Serializable {
    private String date;
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference("invoice-customer")
    private Customer customer;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    @JsonManagedReference("productSell-invoice")
    private List<ProductSell> productSells;

    protected Invoice() {

    }

    public Invoice(String date, Integer number, Customer customer) {
        this.date = date;
        this.number = number;
        this.customer = customer;
        this.productSells = new ArrayList<>();
    }

    public Invoice(Invoice invoice) {
        this.date = invoice.getDate();
        this.number = invoice.getNumber();
        this.customer = invoice.getCustomer();
        this.productSells = invoice.getProductSells();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<ProductSell> getProductSells() {
        return productSells;
    }

    public void setProductSells(List<ProductSell> productSells) {
        this.productSells = productSells;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

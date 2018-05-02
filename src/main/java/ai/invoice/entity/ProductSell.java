package ai.invoice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "product_sells")
public class ProductSell extends BaseEntity implements Serializable {
    private Double amount;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference("product-productSale")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    @JsonBackReference("productSell-invoice")
    private Invoice invoice;

    public ProductSell() {

    }

    public ProductSell(Double amount, Double price, Product product, Invoice invoice) {
        this.amount = amount;
        this.price = price;
        this.product = product;
        this.invoice = invoice;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}

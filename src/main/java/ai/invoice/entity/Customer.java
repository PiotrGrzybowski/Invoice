package ai.invoice.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity implements Serializable {
    private String company;
    private String address;
    private String person;
    private Long nip;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonManagedReference("invoice-customer")
    private List<Invoice> invoices;

    protected Customer() {

    }

    public Customer(String company, String address, String person, Long nip) {
        this.company = company;
        this.address = address;
        this.person = person;
        this.nip = nip;
    }

    public Customer(Customer customer) {
        this.company = customer.company;
        this.address = customer.address;
        this.person = customer.person;
        this.nip = customer.nip;
        this.invoices = customer.invoices;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Long getNip() {
        return nip;
    }

    public void setNip(Long nip) {
        this.nip = nip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}

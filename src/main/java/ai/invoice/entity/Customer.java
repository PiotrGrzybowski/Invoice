package ai.invoice.entity;

import javax.persistence.Entity;

@Entity
public class Customer extends BaseEntity {
    private String company;
    private Long nip;

    protected Customer() {

    }

    public Customer(String company, Long nip) {
        this.company = company;
        this.nip = nip;
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
}

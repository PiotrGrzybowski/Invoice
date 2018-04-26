package ai.invoice.entity;

import ai.invoice.model.Address;

import javax.persistence.Entity;

@Entity
public class Customer extends BaseEntity {
    private String company;
    private Long nip;
//    private Address address;

    protected Customer() {

    }

    public Customer(String company, Long nip) {
        this.company = company;
        this.nip = nip;
//        this.address = address;
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

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }
}

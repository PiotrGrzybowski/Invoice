package ai.invoice.entity;

import ai.invoice.model.Address;

import javax.persistence.Entity;

@Entity
public class Customer extends BaseEntity {
    private String company;
    private String address;
    private String person;
    private Long nip;

    protected Customer() {

    }

    public Customer(String company, String address, String person, Long nip) {
        this.company = company;
        this.address = address;
        this.person = person;
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

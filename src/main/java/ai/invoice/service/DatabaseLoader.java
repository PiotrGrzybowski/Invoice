package ai.invoice.service;

import ai.invoice.entity.Customer;
import ai.invoice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DatabaseLoader implements ApplicationRunner {

    private CustomerRepository customers;

    @Autowired
    public DatabaseLoader(CustomerRepository customers) {
        this.customers = customers;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        ArrayList<Customer> bunchOfCustomer = new ArrayList<>();

        String[] companies = {"Microsoft", "Intel", "Apple", "Tesco", "Auchan", "Castorama"};
        Long[] nips = {123L, 456L, 678L, 890L, 221L, 311L};

        for(int i = 0; i < companies.length; i++) {
            bunchOfCustomer.add(new Customer(companies[i], nips[i]));
        }

        customers.saveAll(bunchOfCustomer);
    }
}
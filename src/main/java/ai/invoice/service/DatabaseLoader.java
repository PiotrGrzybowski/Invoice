package ai.invoice.service;

import ai.invoice.entity.Customer;
import ai.invoice.entity.Product;
import ai.invoice.model.Address;
import ai.invoice.repository.CustomerRepository;
import ai.invoice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseLoader implements ApplicationRunner {

    private CustomerRepository customers;
    private ProductRepository products;

    @Autowired
    public DatabaseLoader(CustomerRepository customers, ProductRepository products) {
        this.customers = customers;
        this.products = products;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        loadCustomers();
        loadProducts();
    }

    private void loadProducts() {
        List<Product> bunchOfProducts = new ArrayList<>();
        bunchOfProducts.add(new Product("Wędka", 0.23, "szt"));
        bunchOfProducts.add(new Product("Pokrowiec", 0.23, "szt"));
        bunchOfProducts.add(new Product("Kołowrotek", 0.23, "opk"));

        products.saveAll(bunchOfProducts);
    }

    private void loadCustomers() {
        ArrayList<Customer> bunchOfCustomer = new ArrayList<>();
        String[] companies = {"Microsoft", "Intel", "Apple", "Tesco", "Auchan", "Castorama"};
        String[] addresses = {"Wrocław Przyjaźni 66, 53-030"};
        String[] persons = {"Piotr Grzybowski"};
        Long[] nips = {123L, 456L, 678L, 890L, 221L, 311L};

        for(int i = 0; i < companies.length; i++) {
            bunchOfCustomer.add(new Customer(companies[i], addresses[0], persons[0], nips[i]));
        }
        customers.saveAll(bunchOfCustomer);
    }
}
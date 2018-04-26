package ai.invoice.api;

import ai.invoice.entity.Customer;
import ai.invoice.repository.CustomerRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    Collection<Customer> getAllTopics() {
        return Lists.newArrayList(customerRepository.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "company/{company}")
    public Collection<Customer> getCustomerByCompany(@PathVariable String company) {
        return customerRepository.findByCompany(company);
    }

    @RequestMapping(method = RequestMethod.GET, value = "nip/{nip}")
    public Collection<Customer> getCustomerByNip(@PathVariable Long nip) {
        return customerRepository.findByNip(nip);
    }
}
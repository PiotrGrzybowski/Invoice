package ai.invoice.api;

import ai.invoice.core.Response;
import ai.invoice.entity.Customer;
import ai.invoice.repository.CustomerRepository;
import com.google.common.collect.Lists;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Customer> getAllCustomers() {
        return Lists.newArrayList(customerRepository.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "customerId/{customerId}")
    public Optional<Customer> getCustomerById(@PathVariable Long customerId) {
        return customerRepository.findById(customerId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "company/{company}")
    public Customer getCustomerByCompany(@PathVariable String company) {
        return customerRepository.findByCompany(company);
    }

    @RequestMapping(method = RequestMethod.GET, value = "nip/{nip}")
    public Customer getCustomerByNip(@PathVariable Long nip) {
        return customerRepository.findByNip(nip);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        try {
            customerRepository.save(new Customer(customer));
            return Response.successfulCreation();
        } catch (Exception e) {
            return Response.failedCreation();
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "customerId/{customerId}")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable Long customerId) {
        Optional<Customer> newCustomerOptional = customerRepository.findById(customerId);

        if (newCustomerOptional.isPresent()) {
            Customer newCustomer = newCustomerOptional.get();
            newCustomer.setCompany(customer.getCompany());
            newCustomer.setAddress(customer.getAddress());
            newCustomer.setPerson(customer.getPerson());
            newCustomer.setNip(customer.getNip());

            if (customerRepository.save(newCustomer).getId().equals(customerId)) {
                return Response.successfulUpdate();
            }
        }
        return Response.failedUpdate();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "customerId/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId) {
        try {
            customerRepository.deleteById(customerId);
            return Response.successfulDelete();
        } catch (Exception e) {
            return Response.failedDelete();
        }
    }
}
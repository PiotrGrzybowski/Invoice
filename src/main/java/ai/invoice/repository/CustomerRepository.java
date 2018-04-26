package ai.invoice.repository;

import ai.invoice.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Collection<Customer> findByCompany(String company);
    Collection<Customer> findByNip(Long nip);
}
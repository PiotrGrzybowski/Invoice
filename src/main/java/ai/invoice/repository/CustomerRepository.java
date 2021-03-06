package ai.invoice.repository;

import ai.invoice.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByCompany(String company);
    Customer findByNip(Long nip);
}
package ai.invoice.repository;

import ai.invoice.entity.Invoice;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;


public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
    Collection<Invoice> findAllByCustomerNip(Long nip);
    Collection<Invoice> findAllByCustomerPerson(String person);
    Optional<Invoice> findByNumber(Integer number);

    @Transactional
    void deleteByNumber(Integer number);
}
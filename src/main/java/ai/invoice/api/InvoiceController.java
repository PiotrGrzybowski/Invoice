package ai.invoice.api;

import ai.invoice.core.Response;
import ai.invoice.entity.Invoice;
import ai.invoice.repository.InvoiceRepository;
import com.google.common.collect.Lists;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    private InvoiceRepository invoiceRepository;

    public InvoiceController(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Invoice> getAllProducts() {
        return Lists.newArrayList(invoiceRepository.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "number/{number}")
    public Optional<Invoice> getInvoiceByNumber(@PathVariable Integer number) {
        return invoiceRepository.findByNumber(number);
    }

    @RequestMapping(method = RequestMethod.GET, value = "customerNip/{customerNip}")
    public Collection<Invoice> getInvoicesByCustomerNip(@PathVariable Long customerNip) {
        return invoiceRepository.findAllByCustomerNip(customerNip);
    }

    @RequestMapping(method = RequestMethod.GET, value = "customerPerson/{customerPerson}")
    public Collection<Invoice> getInvoicesByCustomerNip(@PathVariable String customerPerson) {
        return invoiceRepository.findAllByCustomerPerson(customerPerson);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addInvoice(@RequestBody Invoice invoice) {
        try {
            invoiceRepository.save(new Invoice(invoice));
            return Response.successfulCreation();
        } catch (Exception e) {
            return Response.failedCreation();
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "number/{number}")
    public ResponseEntity<?> updateProduct(@RequestBody Invoice invoice, @PathVariable Integer number) {
        Optional<Invoice> newInvoiceOptional = invoiceRepository.findByNumber(number);

        if(newInvoiceOptional.isPresent()) {
            Invoice newInvoice = newInvoiceOptional.get();
            newInvoice.setCustomer(invoice.getCustomer());
            newInvoice.setDate(invoice.getDate());
            newInvoice.setNumber(invoice.getNumber());
//            newInvoice.setProductSells(invoice.getProductSells());

            return Response.successfulUpdate();
        }
        return Response.failedUpdate();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "number/{number}")
    public ResponseEntity<?> deleteInvoice(@PathVariable Integer number) {
        try {
            invoiceRepository.deleteByNumber(number);
            return Response.successfulDelete();
        } catch (Exception e) {
            return Response.failedDelete();
        }
    }
}

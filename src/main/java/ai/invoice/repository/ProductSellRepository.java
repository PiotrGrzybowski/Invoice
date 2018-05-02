package ai.invoice.repository;

import ai.invoice.entity.ProductSell;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ProductSellRepository extends CrudRepository<ProductSell, Long> {
    Collection<ProductSell> findAllByProductName(String productName);
}

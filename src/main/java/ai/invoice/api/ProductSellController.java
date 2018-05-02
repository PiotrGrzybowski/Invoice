package ai.invoice.api;

import ai.invoice.entity.ProductSell;
import ai.invoice.repository.ProductSellRepository;
import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/sells")
public class ProductSellController {
    private ProductSellRepository productSellRepository;

    public ProductSellController(ProductSellRepository productSellRepository) {
        this.productSellRepository = productSellRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<ProductSell> getAllProductSells() {
        return Lists.newArrayList(productSellRepository.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "productName/{productName}")
    public Collection<ProductSell> getProductSellsByProductName(@PathVariable String productName) {
        return productSellRepository.findAllByProductName(productName);
    }
}

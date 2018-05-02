package ai.invoice.api;

import ai.invoice.core.Response;
import ai.invoice.entity.Product;
import ai.invoice.repository.ProductRepository;
import com.google.common.collect.Lists;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    Collection<Product> getAllProducts() {
        return Lists.newArrayList(productRepository.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "productId/{productId}")
    public Optional<Product> getProductById(@PathVariable Long customerId) {
        return productRepository.findById(customerId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "name/{name}")
    public Product getProductByCompany(@PathVariable String name) {
        return productRepository.findByName(name);
    }

    @RequestMapping(method = RequestMethod.POST, consumes="application/json")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        System.out.print("Dupa");
        try {
            productRepository.save(product);
            return Response.successfulCreation();
        } catch (Exception e) {
            return Response.failedCreation();
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "productId/{productId}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable Long productId) {
        Optional<Product> newProductOptional = productRepository.findById(productId);

        if(newProductOptional.isPresent()) {
            Product newProduct = newProductOptional.get();
            newProduct.setName(product.getName());
            newProduct.setTax(product.getTax());
            newProduct.setType(product.getType());

            if(productRepository.save(newProduct).getId().equals(productId)) {
                return Response.successfulUpdate();
            }
        }
        return Response.failedUpdate();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "productId/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId) {
        try {
            productRepository.deleteById(productId);
            return Response.successfulDelete();
        } catch (Exception e) {
            return Response.failedDelete();
        }
    }
}

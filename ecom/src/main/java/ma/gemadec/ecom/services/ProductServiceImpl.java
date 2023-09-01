package ma.gemadec.ecom.services;

import ma.gemadec.ecom.models.Product;
import ma.gemadec.ecom.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        product.setId(System.currentTimeMillis());
        product.setCreatedAt(new Date());
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        product.setCreatedAt(new Date());
        return productRepository.save(product);
    }

    @Override
    public List<Product> listAll() {
        return productRepository.findAll();
    }

    @Override
    public Product find(Long productID) {
        return productRepository.findById(productID).orElseGet(null);
    }

    @Override
    public void delete(Long productID) {
        productRepository.deleteById(productID);
    }
}

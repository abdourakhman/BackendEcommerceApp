package ma.gemadec.ecom.services;

import ma.gemadec.ecom.models.Product;

import java.util.List;

public interface ProductService {
    Product create(Product product);
    Product update(Product product);
    List<Product> listAll();
    Product find(Long productID);
    void delete(Long productID);
    List<Product> searchProduct(String key);
}

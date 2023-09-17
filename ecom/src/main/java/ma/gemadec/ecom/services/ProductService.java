package ma.gemadec.ecom.services;

import ma.gemadec.ecom.models.Product;
import org.bson.types.ObjectId;

import java.util.List;

public interface ProductService {
    Product create(Product product);
    Product update(Product product);
    List<Product> listAll();
    Product find(ObjectId productID);
    void delete(ObjectId productID);
    List<Product> searchProduct(String key);
}

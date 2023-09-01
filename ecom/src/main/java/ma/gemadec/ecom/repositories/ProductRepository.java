package ma.gemadec.ecom.repositories;

import ma.gemadec.ecom.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,Long> {
}

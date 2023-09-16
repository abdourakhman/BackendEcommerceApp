package ma.gemadec.ecom.repositories;

import ma.gemadec.ecom.models.Cart;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<Cart, ObjectId> {
}

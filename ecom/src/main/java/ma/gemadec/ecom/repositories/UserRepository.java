package ma.gemadec.ecom.repositories;

import ma.gemadec.ecom.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,Integer> {
    Optional<User>findUserByEmail(String email);
}

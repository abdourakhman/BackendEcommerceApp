package ma.gemadec.ecom.services;


import ma.gemadec.ecom.models.User;
import org.bson.types.ObjectId;

public interface UserService {
    void deleteUser(ObjectId id);
     User getUser(ObjectId id);

}

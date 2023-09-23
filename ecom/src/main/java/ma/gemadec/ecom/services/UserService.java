package ma.gemadec.ecom.services;


import ma.gemadec.ecom.models.User;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserService {
    void deleteUser(int id);
     User getUser(ObjectId id);

    List<User> listUser();
}

package ma.gemadec.ecom.services;

import ma.gemadec.ecom.models.Order;
import org.bson.types.ObjectId;

import java.util.List;

public interface OrderService {
    List<Order> findByUserID(ObjectId userID);

}

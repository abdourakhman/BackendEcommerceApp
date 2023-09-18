package ma.gemadec.ecom.services;

import lombok.RequiredArgsConstructor;
import ma.gemadec.ecom.models.Order;
import ma.gemadec.ecom.repositories.OrderRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    @Override
    public List<Order> findByUserID(ObjectId userID) {
        return orderRepository.findAll()
                .stream()
                .filter(order -> order.getUserID().equals(userID))
                .collect(Collectors.toList());
    }
}

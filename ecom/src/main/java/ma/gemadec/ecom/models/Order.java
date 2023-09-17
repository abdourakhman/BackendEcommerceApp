package ma.gemadec.ecom.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
@Document @Builder
@Data @NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    private ObjectId id;
    private ObjectId userID;
    private Collection<Product> products;
    private int quantity;
    private double subtotal;
    private double total;
    private String deliveryStatus ="pending";
    private String paymentStatus;
}

package ma.gemadec.ecom.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    private ObjectId productID;
    private int quantity = 1;
}

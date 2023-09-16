package ma.gemadec.ecom.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private ObjectId id;
    @DBRef
    private User  user;
    private Collection<CartItem> products;
}

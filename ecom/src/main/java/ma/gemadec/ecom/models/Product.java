package ma.gemadec.ecom.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@NoArgsConstructor @AllArgsConstructor
@Data
public class Product {
    @Id
    private ObjectId id;
    @DBRef
    private Order order;
    private String title;
    private String supplier;
    private String imageUrl;
    private String description;
    private String location;
    private double price;
    private Date createdAt;
}

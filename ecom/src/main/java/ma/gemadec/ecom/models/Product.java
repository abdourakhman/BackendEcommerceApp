package ma.gemadec.ecom.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@NoArgsConstructor @AllArgsConstructor
@Data
public class Product {
    @Id
    private Long id;
    private String title;
    private String supplier;
    private String imageUrl;
    private String description;
    private String location;
    private double price;
    private Date createdAt;
}

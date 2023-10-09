package ma.gemadec.ecom.controllers;

import ma.gemadec.ecom.models.CartItem;
import ma.gemadec.ecom.models.Product;
import ma.gemadec.ecom.services.ProductService;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/furniture")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.listAll();
    }
    @GetMapping("/products/{key}")
    public List<Product> searchProducts(@PathVariable String key){
        return productService.searchProduct(key);
    }

    @GetMapping("/product/{id}")
    public Product findProduct(@PathVariable int id){
        return productService.find(id);
    }

    @PostMapping("/product")
    public Product saveProduct(@RequestBody Product product){
        return productService.create(product);
    }
    @PostMapping("/products")
    public List<Product> getAllProducts(@RequestBody int[] productIDs){
        return productService.find(productIDs);
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product){
        return productService.update(product);
    }
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable ObjectId id){
        productService.delete(id);
    }
}


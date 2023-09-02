package ma.gemadec.ecom.controllers;

import ma.gemadec.ecom.models.Product;
import ma.gemadec.ecom.services.ProductService;
import org.springframework.web.bind.annotation.*;

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
    public Product findProduct(@PathVariable Long id){
        return productService.find(id);
    }

    @PostMapping("/product")
    public Product saveProduct(@RequestBody Product product){
        return productService.create(product);
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product){
        return productService.update(product);
    }
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.delete(id);
    }
}


package ma.gemadec.ecom.services;

import ma.gemadec.ecom.models.CartItem;
import ma.gemadec.ecom.models.Product;
import ma.gemadec.ecom.repositories.ProductRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        product.setCreatedAt(new Date());
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        product.setCreatedAt(new Date());
        return productRepository.save(product);
    }

    @Override
    public List<Product> listAll() {
        return productRepository.findAll();
    }

    @Override
    public Product find(int productID) {
        Optional<Product> optionalProduct =  productRepository.findAll()
                .stream()
                .filter(product -> product.getId().getTimestamp() == productID)
                .findFirst();
        return optionalProduct.orElse(null);
    }

    @Override
    public List<Product> find(int[] productIDs) {
        List<Product> products = new ArrayList<>();
        for (int productID : productIDs){
            Optional<Product> optionalProduct= productRepository.findAll()
                    .stream()
                    .filter(product -> product.getId().getTimestamp()==productID)
                    .findFirst();
            if(optionalProduct.isPresent()){
                products.add(optionalProduct.get());
            }
        }
        return products;
    }


    @Override
    public void delete(ObjectId productID) {
        productRepository.deleteById(productID);
    }

    @Override
    public List<Product> searchProduct(String key) {
        String term = key.toLowerCase();
        return productRepository.findAll()
                .stream()
                .filter(
                        (product ->
                                product.getTitle().toLowerCase().indexOf(term)!=-1 ||
                                        product.getDescription().toLowerCase().indexOf(term)!=-1 ||
                                        product.getSupplier().toLowerCase().indexOf(term)!=-1))
                .collect(Collectors.toList());
    }
}

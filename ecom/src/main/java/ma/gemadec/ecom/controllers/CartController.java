package ma.gemadec.ecom.controllers;

import ma.gemadec.ecom.models.Cart;
import ma.gemadec.ecom.models.CartItem;
import ma.gemadec.ecom.services.CartService;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    @PostMapping()
    public ResponseEntity<String> addCart(@RequestBody Cart cart ){
        cartService.addCart(cart);
        return ResponseEntity.ok("cart added successfully");
    }
    @PostMapping("/{userID}/new_article")
    public ResponseEntity<String> addProduct(@PathVariable ObjectId userID, @RequestBody CartItem product ){
        cartService.addToCart(userID,product);
        return ResponseEntity.ok("you add this product successfully");
    }
    @PostMapping("/{userID}/article/remove")
    public ResponseEntity<String> deleteProduct(@PathVariable ObjectId userID, @RequestBody CartItem product ){
        cartService.deleteCartItem(userID,product);
        return ResponseEntity.ok("article deleted successfully");
    }
    @PostMapping("/{userID}/article/decrease")
    public ResponseEntity<String> decrementProduct(@PathVariable ObjectId userID, @RequestBody CartItem product ){
        cartService.decrementCartItem(userID,product);
        return ResponseEntity.ok("article decreased successfully");
    }

}

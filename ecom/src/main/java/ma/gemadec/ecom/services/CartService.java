package ma.gemadec.ecom.services;

import ma.gemadec.ecom.models.Cart;
import ma.gemadec.ecom.models.CartItem;
import org.bson.types.ObjectId;

public interface CartService {
    Cart findCartByUserID(ObjectId userID);
    Cart addToCart(ObjectId userID, CartItem products);
    Cart addCart(Cart cart);
    void deleteCartItem(ObjectId userID,CartItem cartItem);
    void decrementCartItem(ObjectId userID, CartItem cartItem);
}

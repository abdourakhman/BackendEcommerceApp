package ma.gemadec.ecom.services;

import lombok.RequiredArgsConstructor;
import ma.gemadec.ecom.models.Cart;
import ma.gemadec.ecom.models.CartItem;
import ma.gemadec.ecom.repositories.CartRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    @Override
    public Cart findCartByUserID(ObjectId userID){
        return cartRepository
                .findAll()
                .stream()
                .filter(cart -> cart.getUser().getId().equals(userID))
                .findFirst().get();
    }

    @Override
    public Cart addToCart(ObjectId userID,CartItem product) {
        Cart userCart = findCartByUserID(userID);
        boolean isExist = userCart.getArticles().contains(product);
        if(isExist){
            for (CartItem item : userCart.getArticles()){
                if(item.equals(product)){
                    item.setQuantity(item.getQuantity()+1);
                    return cartRepository.save(userCart);
                }
            }
        }
        userCart.getArticles().add(product);
        return cartRepository.save(userCart);
    }

    @Override
    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void deleteCartItem(ObjectId userID, CartItem cartItem) {
        Cart userCart = findCartByUserID(userID);
        userCart.setArticles(
                userCart.getArticles()
                        .stream().
                        filter(product -> !product.equals(cartItem))
                        .collect(Collectors.toList())
        );
        cartRepository.save(userCart);
    }

    @Override
    public void decrementCartItem(ObjectId userID, CartItem cartItem) {
        Cart userCart = findCartByUserID(userID);
        userCart.getArticles()
                .forEach(item -> {
                    if (item.getProductID().equals(cartItem.getProductID()) && item.getQuantity() > 1) {
                        item.setQuantity(item.getQuantity() - 1);
                    }
                });
        cartRepository.save(userCart);
    }
}

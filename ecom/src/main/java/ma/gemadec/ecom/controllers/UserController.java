package ma.gemadec.ecom.controllers;

import ma.gemadec.ecom.models.Product;
import ma.gemadec.ecom.models.User;
import ma.gemadec.ecom.services.ProductService;
import ma.gemadec.ecom.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable ObjectId id){
        userService.deleteUser(id);
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable ObjectId id){
        return userService.getUser(id);
    }
}


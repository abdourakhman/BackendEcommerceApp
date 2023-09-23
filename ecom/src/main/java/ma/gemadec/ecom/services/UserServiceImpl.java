package ma.gemadec.ecom.services;

import lombok.RequiredArgsConstructor;
import ma.gemadec.ecom.models.User;
import ma.gemadec.ecom.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void deleteUser(int id){
        Optional<User> userOptional = userRepository.findAll()
                .stream()
                .filter(user1 -> user1.getId().getTimestamp() == id)
                .findFirst();

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            userRepository.delete(user);
        }
    }

    @Override
    public User getUser(ObjectId id){
        return userRepository.findById(id)
                .orElseThrow(()->new UsernameNotFoundException("user not found"));
    }

    @Override
    public List<User> listUser() {
        return userRepository.findAll();
    }
}

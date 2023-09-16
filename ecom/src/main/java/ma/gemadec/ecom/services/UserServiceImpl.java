package ma.gemadec.ecom.services;

import lombok.RequiredArgsConstructor;
import ma.gemadec.ecom.models.User;
import ma.gemadec.ecom.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void deleteUser(ObjectId id){
        userRepository.deleteById(id);
    }

    @Override
    public User getUser(ObjectId id){
        return userRepository.findById(id)
                .orElseThrow(()->new UsernameNotFoundException("user not found"));
    }
}

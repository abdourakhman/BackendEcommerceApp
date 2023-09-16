package ma.gemadec.ecom.services;

import lombok.RequiredArgsConstructor;
import ma.gemadec.ecom.enumerations.Role;
import ma.gemadec.ecom.models.User;
import ma.gemadec.ecom.models.auth.AuthenticationRequest;
import ma.gemadec.ecom.models.auth.AuthenticationResponse;
import ma.gemadec.ecom.models.auth.RegisterRequest;
import ma.gemadec.ecom.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest req) {
        User user  = User.builder()
                .firstname(req.getFirstname())
                .lastname(req.getLastname())
                .email((req.getEmail()))
                .password(passwordEncoder.encode(req.getPassword()))
                .location(req.getLocation())
                .roles(List.of("USER"))
                .build();
        userRepository.save(user);
        String jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwt)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest req) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        req.getEmail(),
                        req.getPassword()
                )
        );
        User user = userRepository.findUserByEmail(req.getEmail()).orElseThrow();
        String jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwt)
                .build();
    }
}

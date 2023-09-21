package ma.gemadec.ecom.models.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.gemadec.ecom.models.User;


@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class AuthenticationResponse {
    private User user;
    private String token;
}

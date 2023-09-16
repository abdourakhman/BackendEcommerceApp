package ma.gemadec.ecom.models;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import lombok.*;
import ma.gemadec.ecom.enumerations.Role;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
@Document(collection = "users")
@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class User implements UserDetails {
    //On utilise ObjectID pour que l'id soit auto généré
    @Id
    private ObjectId id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private String location;
    private Collection<Role> roles;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(roles.toString()));
        //TODO:create an string enum for role
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

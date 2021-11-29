package com.swoqe.adsformads.security;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data
@Entity
@Table
@NoArgsConstructor
public class CustomAuthority implements GrantedAuthority {

    @Id
    @Enumerated(value = EnumType.STRING)
    private AuthoritiesNames authority;

    public CustomAuthority(AuthoritiesNames authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority.name();
    }
}
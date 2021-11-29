package com.swoqe.adsformads.security;

import com.swoqe.adsformads.model.BaseSqlEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table
public class SecurityUser extends BaseSqlEntity implements UserDetails, Serializable {

    private boolean enabled = true;

    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<CustomAuthority> authorities = new HashSet<>();

    public SecurityUser() {}

    public SecurityUser(String username, String password) {
        this.username = username;
        this.password = password;
        this.enabled = true;
    }

    @Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }
}

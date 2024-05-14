package de.aittr.g_37_jp_shop.security;

import de.aittr.g_37_jp_shop.domain.entity.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;

public class AuthInfo implements Authentication {

    private boolean authenticated;
    private String username;
    private Set<Role> roles;

    public AuthInfo(String username, Set<Role> roles) {
        this.username = username;
        this.roles = roles;
    }

    // описание методов видео урока_13 -> 01:30:00
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }
    // следующие два метода мы не используем
    @Override
    public Object getCredentials() {
        return null;
    }
    @Override
    public Object getDetails() {
        return null;
    }
    // ---------
    @Override
    public Object getPrincipal() {
        return username;
    }
    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }
    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }
    @Override
    public String getName() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthInfo authInfo = (AuthInfo) o;

        if (authenticated != authInfo.authenticated) return false;
        if (!Objects.equals(username, authInfo.username)) return false;
        return Objects.equals(roles, authInfo.roles);
    }
    @Override
    public int hashCode() {
        int result = (authenticated ? 1 : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        return result;
    }
}

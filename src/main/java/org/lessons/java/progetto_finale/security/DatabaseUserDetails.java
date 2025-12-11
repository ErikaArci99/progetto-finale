package org.lessons.java.progetto_finale.security;

import org.lessons.java.progetto_finale.model.Role;
import org.lessons.java.progetto_finale.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class DatabaseUserDetails implements UserDetails {

    // ID dell'utente presente nel database
    private final Long id;

    // Username usato per l'autenticazione
    private final String username;

    // Password hashata presente nel database
    private final String password;

    // Insieme delle autorità (ruoli) riconosciuti da Spring Security
    private final Set<GrantedAuthority> authorities;

    // Costruttore che converte un oggetto User (entità JPA) in uno UserDetails
    public DatabaseUserDetails(User user) {

        this.id = user.getId(); // Imposta l'ID dell'utente
        this.username = user.getUsername(); // Imposta lo username
        this.password = user.getPassword(); // Imposta la password hashata
        this.authorities = new HashSet<>(); // Inizializza il set di autorità

        // Converte i ruoli dell'utente in oggetti GrantedAuthority
        for (Role role : user.getRoles()) {
            // Spring Security richiede il prefisso "ROLE_" per identificare i ruoli
            this.authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }

        // Debug: stampa i ruoli assegnati all'utente
        System.out.println("Authorities di " + user.getUsername() + ": " + authorities);
    }

    // Restituisce tutte le autorità (ruoli/permessi) associate all'utente
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    // Restituisce la password usata da Spring Security per l'autenticazione
    @Override
    public String getPassword() {
        return password;
    }

    // Restituisce lo username usato per il login
    @Override
    public String getUsername() {
        return username;
    }

    // Restituisce l'ID dell'utente (metodo custom, non richiesto da UserDetails)
    public Long getId() {
        return id;
    }

    // Indica che l'account non è scaduto (true = valido)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // Indica che l'account non è bloccato (true = non bloccato)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // Indica che le credenziali non sono scadute (true = valide)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // Indica che l'account è attivo (true = utilizzabile)
    @Override
    public boolean isEnabled() {
        return true;
    }
}

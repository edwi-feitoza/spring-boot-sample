package br.com.edwi.sistema.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service("oficial")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Usuario> usuario = this.repository.findByUsernameOrEmail(username);
        usuario.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: '" + username + "'."));
        return usuario.map(CustomUserDetails::new).get();
    }
}

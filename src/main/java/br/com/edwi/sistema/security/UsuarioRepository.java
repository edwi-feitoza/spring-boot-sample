package br.com.edwi.sistema.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u WHERE u.username = ?1 OR u.email = ?1")
    Optional<Usuario> findByUsernameOrEmail(String username);
}
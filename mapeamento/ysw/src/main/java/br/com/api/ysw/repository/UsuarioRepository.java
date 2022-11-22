package br.com.api.ysw.repository;

import br.com.api.ysw.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


    boolean existsByEmail(String email);
    @Transactional(readOnly = true)
    Optional<Usuario> findByEmail(String email);
}

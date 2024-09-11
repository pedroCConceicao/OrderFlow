package com.orderflow.repository;

import com.orderflow.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    Optional<Usuario> findOneByEmailAndSenha(String email, String senha);

}

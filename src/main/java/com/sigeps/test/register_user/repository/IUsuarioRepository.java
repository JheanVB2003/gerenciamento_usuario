package com.sigeps.test.register_user.repository;

import com.sigeps.test.register_user.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    Optional<UsuarioModel> findByUser(String cpf);
    boolean existsByCpf(String cpf); // Para verificar se o cpf já existe
}

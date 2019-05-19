package app.crud.repository;

import java.util.Optional;
import app.crud.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUsuario extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCpf(String cpf);
}

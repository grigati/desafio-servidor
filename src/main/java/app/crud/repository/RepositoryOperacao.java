package app.crud.repository;

import app.crud.model.Operacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryOperacao extends JpaRepository<Operacao, Long> {
}

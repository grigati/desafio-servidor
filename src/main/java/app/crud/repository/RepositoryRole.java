package app.crud.repository;

import app.crud.model.Role;
import app.crud.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RepositoryRole extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}

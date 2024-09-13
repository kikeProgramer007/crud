package bo.digicert.crud.infrastructure.repositories;

import bo.digicert.crud.infrastructure.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTaskRepository  extends JpaRepository<TaskEntity, Long> {
}

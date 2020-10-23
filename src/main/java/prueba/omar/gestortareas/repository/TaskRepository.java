package prueba.omar.gestortareas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prueba.omar.gestortareas.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}

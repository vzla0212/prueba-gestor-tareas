package prueba.omar.gestortareas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prueba.omar.gestortareas.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

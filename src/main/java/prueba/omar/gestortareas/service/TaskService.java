package prueba.omar.gestortareas.service;

import org.springframework.stereotype.Service;
import prueba.omar.gestortareas.domain.Task;

import java.util.List;

@Service
public interface TaskService {

    List<Task> getList();
    void delete(Long taskId);
    Task update(Task task);
    Task create(Task task);
}

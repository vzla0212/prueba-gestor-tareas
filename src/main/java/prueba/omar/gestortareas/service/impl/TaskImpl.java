package prueba.omar.gestortareas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba.omar.gestortareas.domain.Task;
import prueba.omar.gestortareas.repository.TaskRepository;
import prueba.omar.gestortareas.service.TaskService;

import java.util.List;

@Service
public class TaskImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> getList() {
        return taskRepository.findAll();
    }

    @Override
    public void delete(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public Task update(Task task) {
        return null;
    }

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }
}

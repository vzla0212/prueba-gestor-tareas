package prueba.omar.gestortareas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba.omar.gestortareas.domain.Task;
import prueba.omar.gestortareas.exception.TaskException;
import prueba.omar.gestortareas.repository.TaskRepository;
import prueba.omar.gestortareas.service.TaskService;
import prueba.omar.gestortareas.utils.CopyProperties;

import java.util.List;
import java.util.Optional;

/**
 * Class implementing services for Task
 */
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
        try {
            taskRepository.deleteById(taskId);
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            throw new TaskException("No Task found with id: " + taskId);
        } catch (Exception e) {
            throw new TaskException("Error occurred while executing deletion", e);
        }
    }

    @Override
    public Task update(Task task) {

        Optional<Task> taskEntity = taskRepository.findById(task.getId());

        if (taskEntity.isPresent()) {
            CopyProperties.copyTaskProperties(task, taskEntity.get());
            return taskRepository.save(taskEntity.get());
        } else {
            throw new TaskException("No task found for id: " + task.getId());
        }
    }

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }
}

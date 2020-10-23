package prueba.omar.gestortareas.service.impl;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import prueba.omar.gestortareas.domain.Task;
import prueba.omar.gestortareas.exception.TaskException;
import prueba.omar.gestortareas.repository.TaskRepository;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TaskImplTest {

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetList() {
        TaskImpl taskImpl = new TaskImpl();
        TaskRepository taskRepository = Mockito.mock(TaskRepository.class);
        taskImpl.taskRepository = taskRepository;

        Mockito.when(taskRepository.findAll()).thenReturn(new ArrayList<>());
        assertEquals(taskImpl.getList(),new ArrayList<>());
    }

    @Test
    public void testCreate() {
        TaskImpl taskImpl = new TaskImpl();
        TaskRepository taskRepository = Mockito.mock(TaskRepository.class);
        taskImpl.taskRepository = taskRepository;

        Task taskBeforeInsert = new Task();
        taskBeforeInsert.setDescription("desc");
        taskBeforeInsert.setValid(true);

        Task taskAfterInsert = new Task();
        taskAfterInsert.setId(1L);
        taskAfterInsert.setDescription("desc");
        taskAfterInsert.setValid(true);
        taskAfterInsert.setCreationDate(LocalDateTime.of(2015,
                Month.JULY, 29, 19, 30, 40));

        Mockito.when(taskRepository.save(Mockito.any(Task.class))).thenReturn(taskAfterInsert);

        assertEquals(taskImpl.create(taskBeforeInsert), taskAfterInsert);
    }

    @Test
    public void testDelete() {
        TaskImpl taskImpl = new TaskImpl();
        TaskRepository taskRepository = Mockito.mock(TaskRepository.class);
        taskImpl.taskRepository = taskRepository;

        taskImpl.delete(1L);

        Mockito.verify(taskRepository, Mockito.times(1)).deleteById(Mockito.anyLong());
    }

    @Test
    public void testDelete_EmptyResultDataAccessException() {
        TaskImpl taskImpl = new TaskImpl();
        TaskRepository taskRepository = Mockito.mock(TaskRepository.class);
        taskImpl.taskRepository = taskRepository;

        Mockito.doThrow(new org.springframework.dao.EmptyResultDataAccessException(1))
                .when(taskRepository).deleteById(Mockito.anyLong());

        Assertions.assertThrows(TaskException.class, () -> {
            taskImpl.delete(1L);
        });
    }

    @Test
    public void testUpdate() {
        TaskImpl taskImpl = new TaskImpl();
        TaskRepository taskRepository = Mockito.mock(TaskRepository.class);
        taskImpl.taskRepository = taskRepository;

        Task taskBeforeUpdate = new Task();
        taskBeforeUpdate.setId(1L);
        taskBeforeUpdate.setDescription("desc");
        taskBeforeUpdate.setValid(true);
        taskBeforeUpdate.setCreationDate(LocalDateTime.of(2015,
                Month.JULY, 29, 19, 30, 40));

        Task taskAfterUpdate = new Task();
        taskAfterUpdate.setId(1L);
        taskAfterUpdate.setDescription("descUpdated");
        taskAfterUpdate.setValid(false);
        taskAfterUpdate.setCreationDate(LocalDateTime.of(2015,
                Month.JULY, 29, 19, 30, 40));

        Mockito.when(taskRepository.findById(1L))
                .thenReturn(Optional.of(taskBeforeUpdate));
        Mockito.when(taskRepository.save(Mockito.any(Task.class)))
                .thenReturn(taskAfterUpdate);

        assertEquals(taskImpl.update(taskBeforeUpdate), taskAfterUpdate);
    }

    @Test
    public void testUpdate_Exception() {
        TaskImpl taskImpl = new TaskImpl();
        TaskRepository taskRepository = Mockito.mock(TaskRepository.class);
        taskImpl.taskRepository = taskRepository;

        Task taskBeforeUpdate = new Task();
        taskBeforeUpdate.setId(1L);
        taskBeforeUpdate.setDescription("desc");
        taskBeforeUpdate.setValid(true);
        taskBeforeUpdate.setCreationDate(LocalDateTime.of(2015,
                Month.JULY, 29, 19, 30, 40));

        Mockito.when(taskRepository.findById(1L))
                .thenReturn(Optional.empty());

        Assertions.assertThrows(TaskException.class, () -> {
            taskImpl.update(taskBeforeUpdate);
        });
    }
}

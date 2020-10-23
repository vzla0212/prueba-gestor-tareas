package prueba.omar.gestortareas.controller;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prueba.omar.gestortareas.domain.Task;
import prueba.omar.gestortareas.service.TaskService;

import java.util.List;

@Validated
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/list")
    public ResponseEntity<List<Task>> listTasks(){

        return new ResponseEntity<>(taskService.getList(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Task> addTask(@NotNull @RequestBody Task task){

        return new ResponseEntity<>(taskService.create(task), HttpStatus.OK);
    }

    @PutMapping("/update/")
    public ResponseEntity<Task> updateTask(@NotNull @RequestBody Task task){

        return new ResponseEntity<>(taskService.update(task), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTask(@NotNull @PathVariable("id") Long taskId){

        taskService.delete(taskId);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}

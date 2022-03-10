package edu.escuelaing.lab2.parte2.controller;

import edu.escuelaing.lab2.parte2.data.Task;
import edu.escuelaing.lab2.parte2.dto.TaskDto;
import edu.escuelaing.lab2.parte2.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/task")
@CrossOrigin(origins = "*")
public class TaskController {


    private final TaskService taskService;

    public TaskController(@Autowired TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody TaskDto taskDto){
        return new ResponseEntity<>(taskService.create(taskDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable String id){
        return new ResponseEntity<>(taskService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAll(){
        return new ResponseEntity<>(taskService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id){
        if (taskService.deleteById(id)){
            return new ResponseEntity<>(true, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@RequestBody TaskDto taskDto, @PathVariable String id){
        Task task = taskService.update(new Task(taskDto), id);
        if(task != null){
            return new ResponseEntity<>(task, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}

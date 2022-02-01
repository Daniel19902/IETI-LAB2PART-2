package edu.escuelaing.lab2.parte2.controller;

import edu.escuelaing.lab2.parte2.dto.TaskDto;
import edu.escuelaing.lab2.parte2.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TaskDto taskDto){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
        return null;
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        return null;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody TaskDto taskDto, @PathVariable String id){
        return null;
    }

}

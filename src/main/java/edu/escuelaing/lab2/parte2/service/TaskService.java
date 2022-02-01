package edu.escuelaing.lab2.parte2.service;

import edu.escuelaing.lab2.parte2.data.Task;
import edu.escuelaing.lab2.parte2.dto.TaskDto;

import java.util.List;

public interface TaskService {

    Task create(TaskDto taskDto);

    Task findById( String id );

    List<Task> getAll();

    boolean deleteById( String id );

    Task update( Task task, String id );
}

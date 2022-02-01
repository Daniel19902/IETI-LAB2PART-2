package edu.escuelaing.lab2.parte2.service;

import edu.escuelaing.lab2.parte2.data.Task;
import edu.escuelaing.lab2.parte2.dto.TaskDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class TaskServiceHashMap implements TaskService{

    private final HashMap<Long, Task> taskHashMap = new HashMap<>();

    public TaskServiceHashMap() {
    }

    @Override
    public Task create(TaskDto taskDto) {
        Task task1 = new Task(taskDto);
        taskHashMap.put(task1.getId(),task1);
        return task1;
    }

    @Override
    public Task findById(String id) {
        return null;
    }

    @Override
    public List<Task> getAll() {
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public Task update(Task task, String id) {
        return null;
    }
}

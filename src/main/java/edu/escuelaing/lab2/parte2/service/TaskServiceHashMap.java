package edu.escuelaing.lab2.parte2.service;

import edu.escuelaing.lab2.parte2.data.Task;
import edu.escuelaing.lab2.parte2.dto.TaskDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskServiceHashMap implements TaskService{

    private final HashMap<String, Task> taskHashMap = new HashMap<>();
    private final AtomicLong atomicLong = new AtomicLong();


    public TaskServiceHashMap() {
    }

    public HashMap<String, Task> getTaskHashMap() {
        return taskHashMap;
    }

    @Override
    public Task create(TaskDto taskDto) {
        Task task1 = new Task(taskDto);
        task1.setId(String.valueOf(atomicLong.incrementAndGet()));
        taskHashMap.put(task1.getId(),task1);
        return task1;
    }

    @Override
    public Task findById(String id) {
        return taskHashMap.get(id);
    }

    @Override
    public List<Task> getAll() {
        return new ArrayList<>(taskHashMap.values());
    }

    @Override
    public boolean deleteById(String id) {
        if (taskHashMap.containsKey(id)){
            taskHashMap.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Task update(Task task, String id) {
        if(deleteById(id)){
            task.setId(id);
            taskHashMap.put(id, task);
            return task;
        }
        return null;
    }
}

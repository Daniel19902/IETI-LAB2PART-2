package edu.escuelaing.lab2.parte2;


import edu.escuelaing.lab2.parte2.controller.TaskController;
import edu.escuelaing.lab2.parte2.dto.TaskDto;
import edu.escuelaing.lab2.parte2.service.TaskService;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Parte2ApplicationTests {


	@Autowired
	TaskService taskService;

	@Test
	void createTask() {
		TaskController taskController = new TaskController(taskService);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "Comer");
		jsonObject.put("description", "antes de dormir");
		jsonObject.put("status", "REVIEW");
		jsonObject.put("dueDate", "2022-02-01T19:03:46.400+00:00");

		assertEquals(taskController.create(new TaskDto(jsonObject)).getStatusCode(), HttpStatus.CREATED);
	}

	@Test
	void getAllTasks(){
		TaskController taskController = new TaskController(taskService);
		assertEquals(taskController.getAll().getStatusCode(), HttpStatus.OK);
	}

	@Test
	void findById(){
		TaskController taskController = new TaskController(taskService);
		createTask();
		assertEquals(taskController.findById("1").getStatusCode(), HttpStatus.OK);
	}

	@Test
	void deleteById(){
		TaskController taskController = new TaskController(taskService);
		createTask();
		assertEquals(taskController.deleteById("1").getStatusCode(), HttpStatus.OK);
	}

	JSONObject jsonObject(){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "dormir");
		jsonObject.put("description", "no comer antes de dormir");
		jsonObject.put("status", "REVIEW");
		jsonObject.put("dueDate", "2022-02-01T19:03:46.400+00:00");
		return jsonObject;
	}

	@Test
	void update(){
		TaskController taskController = new TaskController(taskService);
		createTask();
		assertEquals(taskController.update(new TaskDto(jsonObject()), "1").getStatusCode(), HttpStatus.CREATED);
	}

}

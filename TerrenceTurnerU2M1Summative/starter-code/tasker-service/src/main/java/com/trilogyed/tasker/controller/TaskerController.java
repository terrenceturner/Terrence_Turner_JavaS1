package com.trilogyed.tasker.controller;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import javax.validation.Valid;
import java.util.List;


@RestController
@RefreshScope
@RequestMapping("/tasks")
public class TaskerController {

    @Autowired
    TaskerServiceLayer service;


    public TaskerController(TaskerServiceLayer service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskViewModel getTask(@PathVariable int id)  {

        return service.fetchTask(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TaskViewModel> getAllTasks()  {

        return service.fetchAllTasks();
    }

    @GetMapping("/category/{category}")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskViewModel> getTasksByCategory(String category)  {

        return service.fetchTasksByCategory(category);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public TaskViewModel createTask(@RequestBody @Valid TaskViewModel taskView) {
        service.newTask(taskView);

        return taskView;
    }

    @PutMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateTask(@RequestBody TaskViewModel taskView){
        service.updateTask(taskView);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }
}

package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdServerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskerServiceLayer {

    TaskerDao dao;
    AdServerClient adServerClient;

    @Autowired
    public TaskerServiceLayer(TaskerDao dao, AdServerClient adServerClient) {
        this.dao = dao;
        this.adServerClient = adServerClient;
    }


    public TaskViewModel fetchTask(int id) {

        Task task = dao.getTask(id);
        TaskViewModel tvm = new TaskViewModel();

        tvm.setId(task.getId());
        tvm.setDescription(task.getDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());

        // TODO - get ad from Adserver and put in tvm
        tvm.setAdvertisement(adServerClient.getAd());

        return tvm;
    }

    public List<TaskViewModel> fetchAllTasks() {
        List<TaskViewModel> taskView = new ArrayList<>();
        dao.getAllTasks().stream().forEach(task -> taskView.add(buildTaskViewModel(task)));

        return taskView;
    }

    public List<TaskViewModel> fetchTasksByCategory(String category) {
        List<TaskViewModel> taskView = new ArrayList<>();
        dao.getTasksByCategory(category).stream().forEach(task -> taskView.add(buildTaskViewModel(task)));

        return taskView;
    }

    @Transactional
    public TaskViewModel newTask(TaskViewModel taskViewModel) {

        Task task = new Task();
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        task = dao.createTask(task);
        taskViewModel.setId(task.getId());

        // TODO - get ad from Adserver and put in taskViewModel

        taskViewModel.setAdvertisement(adServerClient.getAd());

        return taskViewModel;
    }

    public void deleteTask(int id) {
        dao.deleteTask(id);

    }

    public void updateTask(TaskViewModel taskViewModel) {

        Task task = new Task();
        task.setDescription(task.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        dao.updateTask(task);

    }

    private TaskViewModel buildTaskViewModel(Task task){

        TaskViewModel taskView = new TaskViewModel();
        taskView.setId(task.getId());
        taskView.setDescription(task.getDescription());
        taskView.setCreateDate(task.getCreateDate());
        taskView.setDueDate(task.getDueDate());
        taskView.setCategory(task.getCategory());
        taskView.setAdvertisement(adServerClient.getAd());

        return taskView;
    }
}

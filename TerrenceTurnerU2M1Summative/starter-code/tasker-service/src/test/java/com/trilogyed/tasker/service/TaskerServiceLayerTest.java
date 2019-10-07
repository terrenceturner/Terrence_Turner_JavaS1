package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdServerClient;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class TaskerServiceLayerTest {

    TaskerServiceLayer service;
    TaskerDao dao;
    AdServerClient client;


    @Before
    public void setUp() throws Exception {

        setUpTaskerDaoMock();
        setUpAdServerClientMock();

        service = new TaskerServiceLayer(dao, client);
    }

    public void setUpTaskerDaoMock() {
        dao = mock(TaskerDaoJdbcTemplateImpl.class);

        Task task = new Task();
        task.setId(1);
        task.setDescription("description");
        task.setCreateDate(LocalDate.of(2019,8,22));
        task.setDueDate(LocalDate.of(2019,9,18));
        task.setCategory("category");

        Task tvm = new Task();
        tvm.setDescription("another description");
        tvm.setCreateDate(LocalDate.of(2019,4,17));
        tvm.setDueDate(LocalDate.of(2019,9,13));
        tvm.setCategory("another category");

        List<Task> tList = new ArrayList<>();
        tList.add(task);

        doReturn(task).when(dao).createTask(tvm);
        doReturn(tList).when(dao).getAllTasks();
        doReturn(tList).when(dao).getTasksByCategory("Category");
        doReturn(task).when(dao).getTask(1);
    }

    public void setUpAdServerClientMock() {
        client = mock(AdServerClient.class);

        doReturn("Ad").when(client).getAd();
    }

    @Test
    public void fetchTask() {
//        TaskViewModel tvm = new TaskViewModel();
//        tvm.setDescription("description");
//        tvm.setCreateDate(LocalDate.of(2019, 8, 22));
//        tvm.setDueDate(LocalDate.of(2019,9,19));
//        tvm.setCategory("category");
//
//        tvm = service.newTask(tvm);
//        TaskViewModel taskFromService = service.fetchTask(tvm.getId());
//        assertEquals(tvm, taskFromService);

        TaskViewModel fromService = service.fetchTask(1);

        fromService.setAdvertisement(client.getAd());

        assertEquals(dao.getTask(1).getDescription(), fromService.getDescription());
    }

    @Test
    public void fetchAllTasks() {

        TaskViewModel tvm = new TaskViewModel();
        tvm.setDescription("description");
        tvm.setCreateDate(LocalDate.of(2019, 8, 22));
        tvm.setDueDate(LocalDate.of(2019,9,19));
        tvm.setCategory("category");


        List<TaskViewModel> tasks = service.fetchAllTasks();
        assertEquals(1, tasks.size());
    }

    @Test
    public void fetchTasksByCategory() {
        TaskViewModel tvm = new TaskViewModel();
        tvm.setDescription("description");
        tvm.setCreateDate(LocalDate.of(2019, 8, 22));
        tvm.setDueDate(LocalDate.of(2019,9,19));
        tvm.setCategory("category");
        tvm.setAdvertisement(client.getAd());

        tvm = service.newTask(tvm);

        TaskViewModel tvm2 = new TaskViewModel();
        tvm2.setDescription("another description");
        tvm2.setCreateDate(LocalDate.of(2019,4,17));
        tvm2.setDueDate(LocalDate.of(2019,9,13));
        tvm2.setCategory("category");

        tvm2 = service.newTask(tvm2);
        List<TaskViewModel> taskFromService = service.fetchTasksByCategory("category");
        assertEquals(2, taskFromService.size());


    }

    @Test
    public void newTask() {
        TaskViewModel tvm = new TaskViewModel();
        tvm.setDescription("description");
        tvm.setCreateDate(LocalDate.of(2019, 8, 22));
        tvm.setDueDate(LocalDate.of(2019,9,19));
        tvm.setCategory("category");
        tvm.setAdvertisement(client.getAd());

        TaskViewModel taskFromService = service.newTask(tvm);
        tvm.setId(taskFromService.getId());

        assertEquals(tvm, taskFromService);

    }

    @Test
    public void deleteTask() {
        TaskViewModel tvm = new TaskViewModel();
        tvm.setId(1);

        service.deleteTask(tvm.getId());
    }

    @Test
    public void updateTask() {

        TaskViewModel tvm = new TaskViewModel();
        tvm.setDescription("updated description");
        tvm.setCreateDate(LocalDate.of(2019, 8, 22));
        tvm.setDueDate(LocalDate.of(2019,9,19));
        tvm.setCategory("updated category");

        service.updateTask(tvm);
    }
}
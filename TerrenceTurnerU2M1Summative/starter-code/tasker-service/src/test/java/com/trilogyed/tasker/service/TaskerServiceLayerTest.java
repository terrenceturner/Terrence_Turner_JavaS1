package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdServerClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TaskerServiceLayerTest {

    //Mock is for unit tests From Mockito library, same as doing the gameDao = mock(gameDao.class)
    //MockBeans is for integration tests (it actually creates a bean)
    //Part of Spring, and mockBean creates a mock instance in the ApplicationContext and then it will be injected
    //into the instance.

    //This is where the Mock Beans will be injected into
    @InjectMocks
    TaskerServiceLayer service;
    //Mocking tasker and AdServer
    @Mock
    TaskerDao dao;
    @Mock
    AdServerClient client;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        setUpTaskerDaoMock();
        setUpAdServerClientMock();

        //This is filled with the InjectMock annotation
        //service = new TaskerServiceLayer(dao, client);


    }

    public void setUpTaskerDaoMock() {
        //Service layer mock is testing that the business logic of the service layer is working properly
        //Purpose of making Mock is To make sure that everything is working as attended
        //Managing the behavior of the dependency
        //Mock annotation does it for you
       // dao = mock(TaskerDaoJdbcTemplateImpl.class);

        Task task = new Task();
        task.setId(1);
        task.setDescription("description");
        task.setCreateDate(LocalDate.of(2019,8,22));
        task.setDueDate(LocalDate.of(2019,9,18));
        task.setCategory("category");

        //The value you are passing in
        Task inputTask = new Task();
        inputTask.setDescription("another description");
        inputTask.setCreateDate(LocalDate.of(2019,4,17));
        inputTask.setDueDate(LocalDate.of(2019,9,13));
        inputTask.setCategory("another category");

        List<Task> tList = new ArrayList<>();
        tList.add(task);

        doReturn(task).when(dao).createTask(inputTask);
        doReturn(tList).when(dao).getAllTasks();
        doReturn(tList).when(dao).getTasksByCategory("Category");
        doReturn(task).when(dao).getTask(1);
    }

    public void setUpAdServerClientMock() {
        //Mock annotation does it for you
        //client = mock(AdServerClient.class);

        doReturn("Ad").when(client).getAd();
    }

    @Test
    public void fetchTask() {

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
        //No id because the method we are testing are supposed to create the id
        tvm.setDescription("description");
        tvm.setCreateDate(LocalDate.of(2019, 8, 22));
        tvm.setDueDate(LocalDate.of(2019,9,19));
        tvm.setCategory("category");


        //To test to make sure that the IDs were created through the service
        TaskViewModel taskFromService = service.newTask(tvm);
        tvm.setId(taskFromService.getId());
        tvm.setAdvertisement(taskFromService.getAdvertisement());

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
        tvm.setId(1);
        tvm.setDescription("updated description");
        tvm.setCreateDate(LocalDate.of(2019, 8, 22));
        tvm.setDueDate(LocalDate.of(2019,9,19));
        tvm.setCategory("updated category");
        tvm.setAdvertisement("ad");

        Task expectedTask = new Task();
        expectedTask.setId(1);
        expectedTask.setDescription("new description");
        expectedTask.setCreateDate(LocalDate.of(2000,10,2));
        expectedTask.setDueDate(LocalDate.of(2001,9,1));
        expectedTask.setCategory("new category");

        //to capture value service is passing to DAO layer
//        ArgumentCaptor<Task> captor = ArgumentCaptor.forClass(Task.class);
//        doNothing().when(dao).updateTask(captor.capture());

        service.updateTask(tvm);

        //Verify that the update task is called at least once
        //verify(dao,times(1)).updateTask(captor.getValue());
        verify(dao,times(1)).updateTask(expectedTask);

//        assertEquals(expectedTask, captor.getValue());


    }
}
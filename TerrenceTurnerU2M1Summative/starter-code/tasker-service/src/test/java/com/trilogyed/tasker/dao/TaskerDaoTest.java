package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskerDaoTest {

    @Autowired
    TaskerDao taskerDao;

    @Before
    public void setUp() throws Exception {
        //Clean out database
        taskerDao.deleteAll();

    }

    @Test
    public void createTask() {
        Task task = new Task("description", LocalDate.of(2019,8,22),
                LocalDate.of(2019,9,18),"category" );
        task = taskerDao.createTask(task);
        Task fromDao = taskerDao.getTask(task.getId());
        assertEquals(fromDao, task);

    }

    @Test
    public void getTask() {

        Task task = new Task("description", LocalDate.of(2019,8,22),
                LocalDate.of(2019,9,18),"category" );
        task = taskerDao.createTask(task);
        Task fromDao = taskerDao.getTask(task.getId());
        assertEquals(fromDao, task);
    }

    @Test
    public void getAllTasks() {

        Task task = new Task("description", LocalDate.of(2019,8,22),
                LocalDate.of(2019,9,18),"category" );

        Task task2 = new Task("another description", LocalDate.of(2019,4,17),
                LocalDate.of(2019,9,13), "another category");

        List<Task> tasks = taskerDao.getAllTasks();

        assertEquals(2, tasks.size());
    }

    @Test
    public void getTasksByCategory() {

        Task task = new Task("description", LocalDate.of(2019,8,22),
                LocalDate.of(2019,9,18),"category" );

        Task task2 = new Task("another description", LocalDate.of(2019,4,17),
                LocalDate.of(2019,9,13), "another category");

        Task task3 = new Task("description too", LocalDate.of(2019,10,6),
                LocalDate.of(2019,10,7), "category");

        List<Task> tasks = taskerDao.getTasksByCategory("category");
        assertEquals(2, tasks.size());

        List<Task> tasks1 = taskerDao.getTasksByCategory("another category");
        assertEquals(1, tasks1.size());
    }

    @Test
    public void updateTask() {

        Task task = new Task("description", LocalDate.of(2019,8,22),
                LocalDate.of(2019,9,18),"category" );
        task = taskerDao.createTask(task);
        task.setCreateDate(LocalDate.of(2019,3,22));
        taskerDao.updateTask(task);
        Task fromDao = taskerDao.getTask(task.getId());
        assertEquals(task, fromDao);
    }

    @Test
    public void deleteTask() {

        Task task = new Task("description", LocalDate.of(2019,8,22),
                LocalDate.of(2019,9,18),"category" );
        task = taskerDao.createTask(task);
        taskerDao.deleteTask(task.getId());
        Task fromDao = taskerDao.getTask(task.getId());
        assertNull(fromDao);
    }
}
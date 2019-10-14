package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PostDaoTest {

    @Autowired
    PostDao dao;

    @Before
    public void setUp() throws Exception {
        dao.deleteAll();
    }

    @Test
    public void addPost() {
        Post post = new Post(LocalDate.of(2019,7,14),"poster name","post");

        post = dao.addPost(post);

        Post fromDao = dao.getPost(post.getPostId());
        assertEquals(fromDao, post);
    }

    @Test
    public void getPost() {
        Post post = new Post(LocalDate.of(2019,7,14),"poster name","post");

        post = dao.addPost(post);

        Post fromDao = dao.getPost(post.getPostId());
        assertEquals(fromDao, post);
    }

    @Test
    public void getAllPosts() {
        Post post = new Post(LocalDate.of(2019,7,14),"poster name","post");
        dao.addPost(post);

        post = new Post(LocalDate.of(2019,6,19),"other poster name","post2");
        dao.addPost(post);

        List<Post> posts = dao.getAllPosts();
        assertEquals(2, posts.size());
    }

    @Test
    public void updatePost() {
        Post post = new Post(LocalDate.of(2019,7,14),"poster name","post");

        post = dao.addPost(post);
        post.setPost("post2");
        dao.updatePost(post);
        Post fromDao = dao.getPost(post.getPostId());
        assertEquals(fromDao, post);


    }

    @Test
    public void deletePost() {
        Post post = new Post(LocalDate.of(2019,7,14),"poster name","post");

        post = dao.addPost(post);

        dao.deletePost(post.getPostId());
        Post fromDao = dao.getPost(post.getPostId());

        assertNull(fromDao);
    }

    @Test
    public void getByPosterName() {

        Post post = new Post(LocalDate.of(2019,7,14),"poster name","post");
        dao.addPost(post);

        post = new Post(LocalDate.of(2019,6,19),"other poster name","post2");
        dao.addPost(post);

        post = new Post(LocalDate.of(2019,5,24),"other poster name","post2");
        dao.addPost(post);

        List<Post> posts = dao.getByPosterName("other poster name");
        assertEquals(2, posts.size());

        posts = dao.getByPosterName("poster name");
        assertEquals(1, posts.size());


    }
}
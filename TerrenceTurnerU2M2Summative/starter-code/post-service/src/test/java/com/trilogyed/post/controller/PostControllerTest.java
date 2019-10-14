package com.trilogyed.post.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.model.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PostControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    PostDao dao;

    ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void addPost() throws Exception {


        Post inputPost = new Post(LocalDate.of(2019,7,14),"poster name","post");
        Post outputPost = new Post(LocalDate.of(2019,7,14),"poster name","post");
        outputPost.setPostId(1);


        String outputJson = mapper.writeValueAsString(outputPost);
        String inputJson = mapper.writeValueAsString(inputPost);

        when(dao.addPost(inputPost)).thenReturn(outputPost);

        mvc.perform(MockMvcRequestBuilders.post("/posts")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.postId")
                        .exists());
    }

    @Test
    public void getPost() throws Exception {

        Post post = new Post(LocalDate.of(2019,7,14),"poster name","post");
        post.setPostId(8);

        // Since findById returns an Optional, we create one with our rsvp object as the value
        Optional<Post> returnVal = Optional.of(post);

        //Object to JSON in String
        String outputJson = mapper.writeValueAsString(post);

        // Mocking DAO response
        // This is another way to mock using mockito
        // same as doReturn(returnVal).when(repo).findById(8);
        // We could also set up our mocks in a separate method, if we so chose
        when(dao.getPost(8)).thenReturn(returnVal.get());


        this.mvc.perform(get("/posts/8"))
                .andDo(print())
                .andExpect(status().isOk())
                //use the objectmapper output with the json method
                .andExpect(content().json(outputJson));


    }

    @Test
    public void getAllPosts() throws Exception {

        Post post = new Post(LocalDate.of(2019,7,14),"poster name","post");
        post.setPostId(8);

        Post post2 = new Post(LocalDate.of(2019,5,24),"other poster name","post2");
        post2.setPostId(9);

        List<Post> postList = new ArrayList<>();
        postList.add(post);
        postList.add(post2);

        //Object to JSON in String
        when(dao.getAllPosts()).thenReturn(postList);

        List<Post> listChecker = new ArrayList<>();
        listChecker.addAll(postList);
        //To confirm the test is testing what we think it is... add another Post.
        // Uncommenting the below line causes the test to fail. As expected!
        // listChecker.add(new Post(10, "Donald Duck", 2));
        String outputJson = mapper.writeValueAsString(listChecker);

        this.mvc.perform(get("/posts"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }

    @Test
    public void updatePost() throws Exception {

        Post post = new Post(LocalDate.of(2019,7,14),"poster name","post");
        post.setPostId(8);

        //these will be the same
        String inputJson = mapper.writeValueAsString(post);
        String outputJson = mapper.writeValueAsString(post);

        this.mvc.perform(put("/posts/" + post.getPostId())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }

    @Test
    public void deletePost() throws Exception{

        //can't mock the call to delete. it returns void
        this.mvc.perform(MockMvcRequestBuilders.delete("/posts/8"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""));

    }

    @Test
    public void getPostsByPosterName() throws Exception{

        Post post = new Post(LocalDate.of(2019,7,14),"poster_name","post");
        post.setPostId(8);

        Post post2 = new Post(LocalDate.of(2019,5,24),"poster_name","post2");
        post2.setPostId(9);

        List<Post> postList = new ArrayList<>();
        postList.add(post);
        postList.add(post2);

        when(dao.getByPosterName("poster_name")).thenReturn(postList);

        List<Post> postList2 = new ArrayList<>();

        postList2.addAll(postList);

        String outputJson = mapper.writeValueAsString(postList2);

        this.mvc.perform(get("/user/{poster_name}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }
}
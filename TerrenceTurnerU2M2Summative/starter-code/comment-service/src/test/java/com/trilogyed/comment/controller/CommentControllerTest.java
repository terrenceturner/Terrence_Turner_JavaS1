package com.trilogyed.comment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.model.Comment;
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
public class CommentControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    CommentDao dao;

    ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void addComment() throws Exception{

        Comment inputComment = new Comment(1, LocalDate.of(2019,8,22),
                "Peyton", "This is a comment");
        Comment outputComment = new Comment(1, LocalDate.of(2019,8,22),
                "Peyton", "This is a comment");
        outputComment.setCommentId(1);


        String outputJson = mapper.writeValueAsString(outputComment);
        String inputJson = mapper.writeValueAsString(inputComment);

        when(dao.addComment(inputComment)).thenReturn(outputComment);

        mvc.perform(MockMvcRequestBuilders.post("/comments")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.commentId")
                        .exists());
    }

    @Test
    public void getComment() throws Exception{

        Comment comment = new Comment(1, LocalDate.of(2019,8,22),
                "Peyton", "This is a comment");
        comment.setCommentId(8);

        Optional<Comment> returnVal = Optional.of(comment);

        //Object to JSON in String
        String outputJson = mapper.writeValueAsString(comment);

        // Mocking DAO response
        // This is another way to mock using mockito
        // same as doReturn(returnVal).when(repo).findById(8);
        // We could also set up our mocks in a separate method, if we so chose
        when(dao.getComment(8)).thenReturn(returnVal.get());


        this.mvc.perform(get("/comments/8"))
                .andDo(print())
                .andExpect(status().isOk())
                //use the objectmapper output with the json method
                .andExpect(content().json(outputJson));

    }

    @Test
    public void getAllComments() throws Exception {

        Comment comment = new Comment(1, LocalDate.of(2019,8,22),
                "Peyton", "This is a comment");
        comment.setCommentId(8);

        Comment comment2 = new Comment(2, LocalDate.of(2019,8,25),
                "Graham", "Also a comment");
        comment2.setCommentId(9);

        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);
        commentList.add(comment2);

        //Object to JSON in String
        when(dao.getAllComments()).thenReturn(commentList);

        List<Comment> listChecker = new ArrayList<>();
        listChecker.addAll(commentList);
        //To confirm the test is testing what we think it is... add another Comment.
        // Uncommenting the below line causes the test to fail. As expected!
        // listChecker.add(new Comment(10, "Donald Duck", 2));
        String outputJson = mapper.writeValueAsString(listChecker);

        this.mvc.perform(get("/comments"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getCommentsByPostId() throws Exception {

        Comment comment = new Comment(2, LocalDate.of(2019,8,22),
                "Peyton", "This is a comment");
        comment.setCommentId(8);

        Comment comment2 = new Comment(2, LocalDate.of(2019,8,25),
                "Graham", "Also a comment");
        comment2.setCommentId(9);

        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);
        commentList.add(comment2);

        when(dao.getCommentByPostId(2)).thenReturn(commentList);

        List<Comment> postList2 = new ArrayList<>();

        postList2.addAll(commentList);

        String outputJson = mapper.writeValueAsString(postList2);

        this.mvc.perform(get("/post/{post_id}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void updateComment() throws Exception{

        Comment comment = new Comment(2, LocalDate.of(2019,8,22),
                "Peyton", "This is a comment");
        comment.setCommentId(8);

        //these will be the same
        String inputJson = mapper.writeValueAsString(comment);
        String outputJson = mapper.writeValueAsString(comment);

        this.mvc.perform(put("/comments/" + comment.getPostId())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void deleteComment() throws Exception {

        //can't mock the call to delete. it returns void
        this.mvc.perform(MockMvcRequestBuilders.delete("/comments/8"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""));
    }
}
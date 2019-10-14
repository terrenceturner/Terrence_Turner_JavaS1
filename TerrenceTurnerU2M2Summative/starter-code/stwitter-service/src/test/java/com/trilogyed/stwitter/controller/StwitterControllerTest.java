package com.trilogyed.stwitter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.service.ServiceLayer;
import com.trilogyed.stwitter.util.feign.CommentServiceClient;
import com.trilogyed.stwitter.viewModel.PostViewModel;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@RunWith(SpringJUnit4ClassRunner.class)
public class StwitterControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    ServiceLayer service;

    CommentServiceClient commentClient;

    ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void addPost() throws Exception {

        PostViewModel inputPost = new PostViewModel();
        inputPost.setPostDate(LocalDate.of(2019,7,14));
        inputPost.setPosterName("poster name");
        inputPost.setPost("post");
        inputPost.setCommentList(commentClient.fetchAllComments());

        PostViewModel outputPost = new PostViewModel(9, LocalDate.of(2019,7,14),
                "other poster name","post2", commentClient.fetchAllComments());

        String outputJson = mapper.writeValueAsString(outputPost);
        String inputJson = mapper.writeValueAsString(inputPost);

        when(service.savePost(inputPost)).thenReturn(outputPost);

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

        PostViewModel post = new PostViewModel(8, LocalDate.of(2019,7,14),
                "poster name","post", commentClient.fetchAllComments());

        // Since findById returns an Optional, we create one with our rsvp object as the value
        Optional<PostViewModel> returnVal = Optional.of(post);

        //Object to JSON in String
        String outputJson = mapper.writeValueAsString(post);

        // Mocking DAO response
        // This is another way to mock using mockito
        // same as doReturn(returnVal).when(repo).findById(8);
        // We could also set up our mocks in a separate method, if we so chose
        when(service.fetchPost(8)).thenReturn(returnVal.get());


        this.mvc.perform(get("/posts/8"))
                .andDo(print())
                .andExpect(status().isOk())
                //use the objectmapper output with the json method
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getPostsByPosterName() throws Exception {

        PostViewModel post = new PostViewModel(8, LocalDate.of(2019,7,14),
                "poster name","post", commentClient.fetchAllComments());

        PostViewModel post2 = new PostViewModel(9, LocalDate.of(2019,5,24),
                "other poster name","post2", commentClient.fetchAllComments());

        List<PostViewModel> postList = new ArrayList<>();
        postList.add(post);
        postList.add(post2);

        when(service.fetchPostsByPosterName("poster_name")).thenReturn(postList);

        List<PostViewModel> postList2 = new ArrayList<>();

        postList2.addAll(postList);

        String outputJson = mapper.writeValueAsString(postList2);

        this.mvc.perform(get("/user/{poster_name}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllPosts() throws Exception {

        PostViewModel post = new PostViewModel(8, LocalDate.of(2019,7,14),
                "poster name","post", commentClient.fetchAllComments());

        PostViewModel post2 = new PostViewModel(9, LocalDate.of(2019,5,24),
                "other poster name","post2", commentClient.fetchAllComments());

        List<PostViewModel> postList = new ArrayList<>();
        postList.add(post);
        postList.add(post2);

        //Object to JSON in String
        when(service.fetchAllPosts()).thenReturn(postList);

        List<PostViewModel> listChecker = new ArrayList<>();
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
    public void createComment() throws Exception{
        Comment inputComment = new Comment(1, LocalDate.of(2019,8,22),
                "Peyton", "This is a comment");
        Comment outputComment = new Comment(1, LocalDate.of(2019,8,22),
                "Peyton", "This is a comment");
        outputComment.setCommentId(1);


        String outputJson = mapper.writeValueAsString(outputComment);
        String inputJson = mapper.writeValueAsString(inputComment);

        when(service.saveComment(inputComment)).thenReturn(outputComment);

        mvc.perform(MockMvcRequestBuilders.post("/comments/post/{post_id}")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.commentId")
                        .exists());
    }

    @Test
    public void updatePost() throws Exception {

        PostViewModel post = new PostViewModel(8, LocalDate.of(2019,7,14),
                "poster name","post", commentClient.fetchAllComments());

        //these will be the same
        String inputJson = mapper.writeValueAsString(post);
        String outputJson = mapper.writeValueAsString(post);

        this.mvc.perform(put("/posts/" + post.getId())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void updateComment() throws Exception {

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
    public void deletePost() throws Exception {

        //can't mock the call to delete. it returns void
        this.mvc.perform(MockMvcRequestBuilders.delete("/posts/8"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""));
    }
}
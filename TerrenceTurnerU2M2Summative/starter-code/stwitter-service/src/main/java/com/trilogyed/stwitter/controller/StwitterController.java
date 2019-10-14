package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.service.ServiceLayer;
import com.trilogyed.stwitter.viewModel.PostViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RefreshScope
@RestController
public class StwitterController {

    @Autowired
    ServiceLayer service;

    @PostMapping("/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public PostViewModel addPost(@RequestBody @Valid PostViewModel post) {
        return service.savePost(post);
    }

    @GetMapping(value = "/posts/{id}")
    public PostViewModel getPost(@PathVariable int id) {
        return service.fetchPost(id);
    }

    @GetMapping(value = "/posts/user/{poster_name}")
    public List<PostViewModel> getPostsByPosterName(@PathVariable String poster_name) {
        return service.fetchPostsByPosterName(poster_name);
    }

    @GetMapping("/posts")
    public List<PostViewModel> getAllPosts (){
        return service.fetchAllPosts();
    }

    @PostMapping(value = "/comments/post/{post_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createComment(@PathVariable int post_id, @RequestBody @Valid Comment comment) {
        comment.setPostId(post_id);
        service.saveComment(comment);
    }

    @PutMapping(value = "/posts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(@PathVariable int id, @RequestBody PostViewModel pvm) {
        pvm.setId(id);
        service.updatePost(pvm);
    }

    @PutMapping(value = "/comments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateComment(@PathVariable int id, @RequestBody Comment comment) {
        comment.setCommentId(id);
        service.updateComment(comment);
    }

    @DeleteMapping(value = "/posts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable int id) {
        service.removePost(id);
    }

    @DeleteMapping(value = "/comments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable int id) {
        service.removeComment(id);
    }
}

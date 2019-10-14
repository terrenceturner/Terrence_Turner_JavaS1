package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.model.Comment;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "comment-service")
public interface CommentServiceClient {

    @GetMapping(value = "/comments/{comment_id}")
     Comment fetchComment(@PathVariable int comment_id);

    @GetMapping(value = "/comments/post/{post_id}")
     List<Comment> fetchCommentsByPostId(@PathVariable int post_id);

    @GetMapping(value = "/comments")
     List<Comment> fetchAllComments();

    @PostMapping(value = "/posts")
    Comment saveComment(@RequestBody Comment post);

    @PutMapping(value = "/posts/{id}")
     void updateComment(@RequestBody Comment comment);

    @DeleteMapping(value = "/comments/{comment_id}")
     void deleteComment(@PathVariable int comment_id);
}

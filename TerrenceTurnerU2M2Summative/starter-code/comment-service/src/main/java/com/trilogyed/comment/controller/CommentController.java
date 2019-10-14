package com.trilogyed.comment.controller;

import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/comments")
@CacheConfig(cacheNames = {"comments"})
public class CommentController {

    @Autowired
    CommentDao dao;

    @CachePut(key = "#result.getCommentId()")
    @PostMapping
    public Comment addComment(@RequestBody Comment comment) {
        return dao.addComment(comment);
    }

    @Cacheable
    @GetMapping(value = "/{id}")
    public Comment getComment(@PathVariable int id) {
        return dao.getComment(id);
    }

    @GetMapping
    public List<Comment> getAllComments() {
        return dao.getAllComments();
    }

    @GetMapping(value = "/post/{post_id}")
    public List<Comment> getCommentsByPostId(@PathVariable int post_id) {
        return dao.getCommentByPostId(post_id);
    }

    @CacheEvict(key = "#comment.getCommentId()")
    @PutMapping(value = "/{id}")
    public void updateComment(@RequestBody Comment comment, @PathVariable int id) {
        comment.setCommentId(id);
        dao.updateComment(comment);
    }

    @CacheEvict
    @DeleteMapping(value = "/{id}")
    public void deleteComment(@PathVariable int id) {
        dao.deleteComment(id);
    }
}

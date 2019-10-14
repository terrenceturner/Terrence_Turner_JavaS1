package com.trilogyed.commentqueueconsumer.util.feign;

import com.trilogyed.commentqueueconsumer.util.messages.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "comment-service")
@RequestMapping("/comments")
public interface CommentClient {

    @PostMapping
    Comment createComment(Comment comment);

    @PutMapping(value = "/{id}")
    void updateComment(@PathVariable int id, @RequestBody Comment comment);
}

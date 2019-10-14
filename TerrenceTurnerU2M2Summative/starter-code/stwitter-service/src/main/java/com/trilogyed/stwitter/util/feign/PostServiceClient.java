package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.viewModel.PostViewModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "post-service")
public interface PostServiceClient {

    @GetMapping(value = "/posts/{id}")
     Post fetchPost(@PathVariable int id);

    @GetMapping(value = "/posts/user/{poster_name}")
     List<Post> fetchPostByPosterName(@PathVariable String poster_name);

    @RequestMapping(value = "/posts/", method = RequestMethod.GET)
     List<Post> fetchAllPosts();

    @PostMapping(value = "/posts")
     Post createPost(@RequestBody Post post);

    @PutMapping(value = "/posts/{id}")
     void updatePost(@RequestBody Post post);

    @DeleteMapping(value = "/posts/{id}")
     void deletePost(@PathVariable int id);
}

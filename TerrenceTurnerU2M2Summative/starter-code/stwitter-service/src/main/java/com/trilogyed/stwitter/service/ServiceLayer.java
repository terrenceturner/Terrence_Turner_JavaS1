package com.trilogyed.stwitter.service;

import com.sun.jersey.api.NotFoundException;
import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.util.feign.CommentServiceClient;
import com.trilogyed.stwitter.util.feign.PostServiceClient;
import com.trilogyed.stwitter.viewModel.PostViewModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {


    private RabbitTemplate rabbitTemplate;
    private CommentServiceClient commentClient;
    private PostServiceClient postClient;

    public static final String EXCHANGE = "comment-exchange";

    public static final String ROUTING_KEY = "create.controller";

    @Autowired
    public ServiceLayer(RabbitTemplate rabbitTemplate, CommentServiceClient commentClient, PostServiceClient postClient) {
        this.rabbitTemplate = rabbitTemplate;
        this.commentClient = commentClient;
        this.postClient = postClient;
    }


    public PostViewModel savePost(PostViewModel postView){
        Post post = new Post();
        post.setPostDate(postView.getPostDate());
        post.setPosterName(postView.getPosterName());
        post.setPost(postView.getPost());
        post = postClient.createPost(post);
        postView.setId(post.getPostID());

        return postView;
    }

    public Comment saveComment(Comment comment) {
        if (postClient.fetchPost(comment.getPostId()) == null)
            throw new IllegalArgumentException("Post ID in path must match an existing post");
        return commentClient.saveComment(comment);
    }


    public PostViewModel fetchPost(int id){
        Post post = postClient.fetchPost(id);
        PostViewModel postViewModel;
        if (post == null){
            throw new NotFoundException("Post ID: " + id + " was not found!");
        }else {
            return postViewModel = buildPostViewModel(post);
        }

    }

    public List<PostViewModel> fetchAllPosts(){
        List<Post> postList = postClient.fetchAllPosts();
        List<PostViewModel> postViewModelList = new ArrayList<>();

        for (Post post : postList){
            PostViewModel postViewModel = buildPostViewModel(post);
            postViewModelList.add(postViewModel);
        }
        return postViewModelList;
    }

    public List<PostViewModel> fetchPostsByPosterName(String poster_name) {
        if (postClient.fetchPostByPosterName(poster_name).size() == 0)
            throw new NotFoundException(poster_name + " has not made any posts");
        List<PostViewModel> pvmList = new ArrayList<>();
        postClient.fetchPostByPosterName(poster_name).stream().forEach(post -> pvmList.add(buildPostViewModel(post)));

        return pvmList;
    }


    public void updatePost(PostViewModel postView) {
        Post post = new Post();
        post.setPostID(postView.getId());
        post.setPostDate(postView.getPostDate());
        post.setPosterName(postView.getPosterName());
        post.setPost(postView.getPost());

        postClient.updatePost(post);
    }

    public void updateComment(Comment comment){
        Comment comment1 = new Comment();
        comment1.setCommentId(comment.getCommentId());
        comment1.setPostId(comment.getPostId());
        comment1.setCreateDate(comment.getCreateDate());
        comment1.setCommenterName(comment.getCommenterName());
        comment1.setComment(comment.getComment());

        commentClient.updateComment(comment1);
    }

    public void removePost(int id) {

        postClient.deletePost(id);
    }



    public void removeComment(int id) {

        commentClient.deleteComment(id);
    }





    private PostViewModel buildPostViewModel(Post post) {
        PostViewModel pvm = new PostViewModel();
        pvm.setId(post.getPostID());
        pvm.setPostDate(post.getPostDate());
        pvm.setPosterName(post.getPosterName());
        pvm.setPost(post.getPost());
        pvm.setCommentList(commentClient.fetchCommentsByPostId(post.getPostID()));

        return pvm;
    }
}

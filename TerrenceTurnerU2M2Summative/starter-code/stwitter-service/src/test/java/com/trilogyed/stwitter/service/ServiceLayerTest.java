package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.util.feign.CommentServiceClient;
import com.trilogyed.stwitter.util.feign.PostServiceClient;
import com.trilogyed.stwitter.viewModel.PostViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ServiceLayerTest {
    @InjectMocks
    ServiceLayer service;

    @Mock
    CommentServiceClient commentClient;

    @Mock
    PostServiceClient postClient;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        setUpCommentServiceClientMock();
        setUpPostServiceClientMock();

    }


    public void setUpCommentServiceClientMock() {

        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019, 10, 11));
        comment.setCommenterName("name");
        comment.setComment("comment");

        Comment inputComment = new Comment();
        inputComment.setPostId(1);
        inputComment.setCreateDate(LocalDate.of(2019, 10, 11));
        inputComment.setCommenterName("name");
        inputComment.setComment("comment");

        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);

        doReturn(comment).when(commentClient).fetchComment(1);
        doReturn(comment).when(commentClient).saveComment(inputComment);
        doReturn(commentList).when(commentClient).fetchAllComments();
        doReturn(commentList).when(commentClient).fetchCommentsByPostId(1);

    }

    public void setUpPostServiceClientMock() {

        Post post = new Post();
        post.setPostID(1);
        post.setPostDate(LocalDate.of(2019, 10, 11));
        post.setPosterName("name");
        post.setPost("post");

        Post post1 = new Post();
        post1.setPostDate(LocalDate.of(2019, 10, 11));
        post1.setPosterName("name");
        post1.setPost("post");

        List<Post> postList = new ArrayList<>();
        postList.add(post);

        doReturn(post).when(postClient).fetchPost(1);
        doReturn(post).when(postClient).createPost(post1);
        doReturn(postList).when(postClient).fetchAllPosts();
        doReturn(postList).when(postClient).fetchPostByPosterName("name");

    }


    @Test
    public void savePost(){
        PostViewModel pvm = new PostViewModel();
        pvm.setPostDate(LocalDate.of(2019,10,11));
        pvm.setPosterName("name");
        pvm.setPost("post");
        pvm.setCommentList(commentClient.fetchAllComments());

        pvm = service.savePost(pvm);
        PostViewModel fromService = service.fetchPost(pvm.getId());

        assertEquals(pvm, fromService);
    }

    @Test
    public void fetchPost(){

        PostViewModel pvm = new PostViewModel();
        pvm.setPostDate(LocalDate.of(2019,10,11));
        pvm.setPosterName("name");
        pvm.setPost("post");
        pvm.setCommentList(commentClient.fetchAllComments());

        pvm = service.savePost(pvm);
        PostViewModel fromService = service.fetchPost(pvm.getId());

        assertEquals(pvm, fromService);

    }

    @Test
    public void fetchByPosterName(){
        PostViewModel pvm = new PostViewModel();
        pvm.setId(1);
        pvm.setPostDate(LocalDate.of(2019,10,11));
        pvm.setPosterName("name");
        pvm.setPost("post");
        pvm.setCommentList(commentClient.fetchAllComments());

        List<PostViewModel> postList = new ArrayList<>();
        postList.add(pvm);

        assertEquals(service.fetchPostsByPosterName("name"), postList);

    }

    @Test
    public void saveComment() {
        Comment comment = new Comment();

        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019, 01, 01));
        comment.setCommenterName("name");
        comment.setComment("comment");

        comment = service.saveComment(comment);
        Comment fromService = commentClient.fetchComment(comment.getCommentId());
        assertEquals(comment, fromService);
    }

    @Test
    public void updatePost() {
        PostViewModel pvm = new PostViewModel();
        pvm.setId(1);
        pvm.setPostDate(LocalDate.of(2019,10,21));
        pvm.setPosterName("name");
        pvm.setPost("post");
        pvm.setCommentList(commentClient.fetchAllComments());

        Post expectedPost = new Post();
        expectedPost.setPostID(1);
        expectedPost.setPostDate(LocalDate.of(2019,10,21));
        expectedPost.setPosterName("name");
        expectedPost.setPost("post");

        service.updatePost(pvm);

        verify(postClient,times(1)).updatePost(expectedPost);

    }

    @Test
    public void updateComment() {
        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,10,11));
        comment.setCommenterName("new name");
        comment.setComment("new comment");

        Comment expectedComment = new Comment();
        expectedComment.setCommentId(1);
        expectedComment.setPostId(1);
        expectedComment.setCreateDate(LocalDate.of(2019,10,11));
        expectedComment.setCommenterName("new name");
        expectedComment.setComment("new comment");

        service.updateComment(comment);

        verify(commentClient,times(1)).updateComment(expectedComment);

    }

    @Test
    public void deletePost() {
        Post post = new Post();
        post.setPostID(1);

        service.removePost(post.getPostID());

        ArgumentCaptor<Integer> postCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(postClient).deletePost(postCaptor.capture());
        assertEquals(post.getPostID(), postCaptor.getValue().intValue());
    }

    @Test
    public void deleteComment() {
        Comment comment = new Comment();
        comment.setCommentId(1);

        service.removeComment(comment.getCommentId());

        ArgumentCaptor<Integer> commentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(commentClient).deleteComment(commentCaptor.capture());
        assertEquals(comment.getCommentId(), commentCaptor.getValue().intValue());
    }

}
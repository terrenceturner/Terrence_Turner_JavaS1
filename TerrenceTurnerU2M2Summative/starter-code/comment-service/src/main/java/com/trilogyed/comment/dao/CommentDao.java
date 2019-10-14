package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;

import java.util.List;

public interface CommentDao {
    public Comment getComment(int id);
    public List<Comment> getAllComments();
    public Comment addComment(Comment comment);
    public void updateComment(Comment comment);
    public void deleteComment(int id);
    public List<Comment> getCommentByPostId(int post_id);
    public void deleteAll();
}

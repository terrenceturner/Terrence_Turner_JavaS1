package com.trilogyed.stwitter.viewModel;

import com.trilogyed.stwitter.model.Comment;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class PostViewModel {

    private int id;
    @NotNull(message = "Post date cannot be null")
    private LocalDate postDate;
    @NotNull(message = "Poster name cannot be null")
    private String posterName;
    private String post;
    private List<Comment> commentList;

    public PostViewModel() {
    }


    public PostViewModel(int postID, @NotNull(message = "Post date cannot be null") LocalDate postDate, @NotNull(message = "Poster name cannot be null") String posterName, String post, List<Comment> commentList) {
        this.id = postID;
        this.postDate = postDate;
        this.posterName = posterName;
        this.post = post;
        this.commentList = commentList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostViewModel that = (PostViewModel) o;
        return id == that.id &&
                postDate.equals(that.postDate) &&
                posterName.equals(that.posterName) &&
                Objects.equals(post, that.post) &&
                Objects.equals(commentList, that.commentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, postDate, posterName, post, commentList);
    }

    @Override
    public String toString() {
        return "PostViewModel{" +
                "id=" + id +
                ", postDate=" + postDate +
                ", posterName='" + posterName + '\'' +
                ", post='" + post + '\'' +
                ", commentList=" + commentList +
                '}';
    }
}

package com.trilogyed.post.model;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

public class Post {

    @NotNull
    private int postId;
    @NotNull
    private LocalDate postDate;
    @NotNull
    private String posterName;
    private String post;

    public Post(){

    }

    public Post(LocalDate postDate, String posterName, String post) {
        this.postDate = postDate;
        this.posterName = posterName;
        this.post = post;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post1 = (Post) o;
        return postId == post1.postId &&
                postDate.equals(post1.postDate) &&
                posterName.equals(post1.posterName) &&
                post.equals(post1.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, postDate, posterName, post);
    }
}

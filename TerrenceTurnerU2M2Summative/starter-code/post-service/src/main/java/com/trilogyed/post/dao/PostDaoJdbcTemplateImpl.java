package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PostDaoJdbcTemplateImpl implements PostDao {

    //Prepared Statements
    public static final String INSERT_POST =
            "insert into post (post_date, poster_name, post) values (?, ?, ?)";
    public static final String SELECT_POST_BY_ID =
            "select * from post where post_id = ?";
    public static final String SELECT_ALL_POSTS =
            "select * from post";
    public static final String UPDATE_POST =
            "update post set post_date = ?, poster_name = ?, post = ? where post_id = ?";
    public static final String DELETE_POST =
            "delete from post where post_id = ?";
    public static final String SELECT_POSTS_BY_POSTER_NAME =
            "select * from post where poster_name = ?";
    private static final String DELETE_ALL_SQL =
            "delete from post";


    //Jdbc Constructor
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public PostDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Post addPost(Post post) {
        jdbcTemplate.update(
                INSERT_POST,
                post.getPostDate(),
                post.getPosterName(),
                post.getPost());

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        post.setPostId(id);

        return post;
    }

    @Override
    public Post getPost(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_POST_BY_ID, this::mapRowToPost, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Post> getAllPosts() {
        return jdbcTemplate.query(SELECT_ALL_POSTS, this::mapRowToPost);
    }



    @Override
    public void updatePost(Post post) {
        jdbcTemplate.update(
                UPDATE_POST,
                post.getPostDate(),
                post.getPosterName(),
                post.getPost(),
                post.getPostId());

    }

    @Override
    public void deletePost(int post_id) {
        jdbcTemplate.update(DELETE_POST, post_id);

    }

    @Override
    public List<Post> getByPosterName(String poster_name) {
        return jdbcTemplate.query(SELECT_POSTS_BY_POSTER_NAME, this::mapRowToPost, poster_name);
    }

    @Override
    public void deleteAll() {
        jdbcTemplate.update(DELETE_ALL_SQL);
    }

    //RowMapper
    private Post mapRowToPost(ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();
        post.setPostId(rs.getInt("post_id"));
        post.setPostDate(rs.getDate("post_date").toLocalDate());
        post.setPosterName(rs.getString("poster_name"));
        post.setPost(rs.getString("post"));

        return post;
    }
}

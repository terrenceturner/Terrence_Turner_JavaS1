package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CommentDaoTest {


    @Autowired
    CommentDao dao;


    @Before
    public void setUp() throws Exception {

        dao.deleteAll();
    }

    @Test
    public void getComment() {
        Comment comment = new Comment();

        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,4,15));
        comment.setCommenterName("Peyton");
        comment.setComment("This is a comment");

        comment = dao.addComment(comment);

        Comment fromDao = dao.getComment(comment.getCommentId());
        assertEquals(fromDao, comment);

    }

    @Test
    public void getAll() {
        Comment comment = new Comment(1, LocalDate.of(2019,8,22),
                "Peyton", "This is a comment");
        dao.addComment(comment);

        comment = new Comment(2, LocalDate.of(2019,8,25),
                "Graham", "Also a comment");
        dao.addComment(comment);

        List<Comment> comments = dao.getAllComments();
        assertEquals(2, comments.size());

    }

    @Test
    public void addComment() {
        Comment comment = new Comment(1, LocalDate.of(2019,8,22),
                "Peyton Turner", "This is a comment");

        comment = dao.addComment(comment);

        Comment fromDao = dao.getComment(comment.getCommentId());
        assertEquals(fromDao, comment);
    }

    @Test
    public void updateComment() {
        Comment comment = new Comment(1, LocalDate.of(2019,8,22),
                "Peyton", "This is a comment");
        comment = dao.addComment(comment);
        comment.setPostId(5);
        dao.updateComment(comment);
        Comment fromDao = dao.getComment(comment.getCommentId());
        assertEquals(fromDao, comment);
    }

    @Test
    public void deleteComment() {

        Comment comment = new Comment(1, LocalDate.of(2019,8,22),
                "Peyton Turner", "This is a comment");

        comment = dao.addComment(comment);

        dao.deleteComment(comment.getCommentId());

        Comment fromDao = dao.getComment(comment.getCommentId());

        assertNull(fromDao);
    }

    @Test
    public void getCommentByPostId() {
        Comment comment = new Comment(1, LocalDate.of(2019,8,22),
                "Peyton", "This is a comment");
        dao.addComment(comment);

        comment = new Comment(2, LocalDate.of(2019,8,25),
                "Graham", "Also a comment");
        dao.addComment(comment);

        comment = new Comment(2, LocalDate.of(2019,8,25),
                "Greyston", "Last comment");
        dao.addComment(comment);

        List<Comment> comments = dao.getCommentByPostId(2);
        assertEquals(2, comments.size());

        comments = dao.getCommentByPostId(1);
        assertEquals(1, comments.size());
    }
}
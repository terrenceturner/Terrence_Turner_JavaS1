package com.company.TerrenceTurnerU1M5Summative.dao;

import com.company.TerrenceTurnerU1M5Summative.model.Author;
import com.company.TerrenceTurnerU1M5Summative.model.Book;
import com.company.TerrenceTurnerU1M5Summative.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorDaoTest {

    @Autowired
    AuthorDao authorDao;

    @Autowired
    BookDao bookDao;

    @Autowired
    PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception {

        // Clean up the test db
        List<Author> authorList = authorDao.getAllAuthors();
        for (Author author : authorList) {
            authorDao.deleteAuthor(author.getAuthor_id());
        }

        List<Book> bookList = bookDao.getAllBooks();

        for (Book book : bookList) {
            bookDao.deleteBook (book.getBook_id());
        }

        List<Publisher> publisherList = publisherDao.getAllPublishers();

        for (Publisher publisher : publisherList) {
            publisherDao.deletePublisher(publisher.getPublisher_id());
        }
    }

    @Test
    public void addGetDeleteAuthor() {

        Author author = new Author();
        author.setFirst_name("Joe");
        author.setLast_name("Blow");
        author.setStreet("123 Main St");
        author.setCity("Atlanta");
        author.setState("GA");
        author.setPostal_code("30310");
        author.setPhone("770-936-9359");
        author.setEmail("joe@gmail.com");

        author = authorDao.addAuthor(author);

        Author author1 = authorDao.getAuthor(author.getAuthor_id())

        assertEquals(author, author1);

        authorDao.deleteAuthor(author.getAuthor_id());

        author1 = authorDao.getAuthor(author.getAuthor_id());

        assertNull(author1);


    }

    @Test
    public void updateAuthor(){

        Author author = new Author();
        author.setFirst_name("Joe");
        author.setLast_name("Blow");
        author.setStreet("123 Main St");
        author.setCity("Atlanta");
        author.setState("GA");
        author.setPostal_code("30310");
        author.setPhone("770-936-9359");
        author.setEmail("joe@gmail.com");

        author = authorDao.addAuthor(author);

        author.setPhone("404-936-9359");
        author.setEmail("jblow@gmail.com");

        authorDao.updateAuthor(author);

        Author author1 = authorDao.getAuthor(author.getAuthor_id());

        assertEquals(author, author1);


    }

    @Test
    public void getAllAuthors(){

        Author author = new Author();
        author.setFirst_name("Joe");
        author.setLast_name("Blow");
        author.setStreet("123 Main St");
        author.setCity("Atlanta");
        author.setState("GA");
        author.setPostal_code("30310");
        author.setPhone("770-936-9359");
        author.setEmail("joe@gmail.com");

        author = authorDao.addAuthor(author);

        author = new Author();
        author.setFirst_name("Jesse");
        author.setLast_name("James");
        author.setStreet("124 Other St");
        author.setCity("Atlanta");
        author.setState("GA");
        author.setPostal_code("30314");
        author.setPhone("704-936-9328");
        author.setEmail("jessee@gmail.com");

        author = authorDao.addAuthor(author);

        List<Author> authorList = authorDao.getAllAuthors();

        assertEquals(2, authorList.size());


    }


}
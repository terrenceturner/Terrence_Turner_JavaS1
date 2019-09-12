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
public class PublisherDaoTest {

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
    public void addGetDeletePublisher() {

        Publisher publisher = new Publisher();
        publisher.setName("Publisher");
        publisher.setStreet("Street");
        publisher.setCity("City");
        publisher.setState("NC");
        publisher.setPostal_code("28277");
        publisher.setPhone("704-936-9359");
        publisher.setEmail("publisher@publisher.com");

        publisher = publisherDao.addPublisher(publisher);

        Publisher publisher1 = publisherDao.getPublisher(publisher.getPublisher_id());

        assertEquals(publisher, publisher1);

        publisherDao.deletePublisher(publisher.getPublisher_id());

        publisher1 = publisherDao.getPublisher(publisher.getPublisher_id());

        assertNull(publisher1);
    }

    @Test
    public void updatePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("BookCo");
        publisher.setStreet("194 Lucky St.");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setPostal_code("98432");
        publisher.setPhone("213-914-2244");
        publisher.setEmail("bookco@gmail.com");

        publisherDao.addPublisher(publisher);

        publisher.setName("Book Company");
        publisher.setStreet("777 Low St");
        publisher.setCity("Jackson City");
        publisher.setState("MS");
        publisher.setPostal_code("28980");
        publisher.setPhone("740-982-8039");
        publisher.setEmail("book@gmail.com");

        publisherDao.updatePublisher(publisher);

        Publisher publisher1 = publisherDao.getPublisher(publisher.getPublisher_id());

        assertEquals(publisher, publisher1);
    }

    @Test
    public void getAllPublishers() {

        Publisher publisher = new Publisher();
        publisher.setName("BookCo");
        publisher.setStreet("194 Lucky St.");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setPostal_code("98432");
        publisher.setPhone("213-914-2244");
        publisher.setEmail("bookco@gmail.com");

        publisherDao.addPublisher(publisher);

        publisher.setName("Book Company");
        publisher.setStreet("777 Low St");
        publisher.setCity("Jackson City");
        publisher.setState("MS");
        publisher.setPostal_code("28980");
        publisher.setPhone("740-982-8039");
        publisher.setEmail("book@gmail.com");

        publisherDao.updatePublisher(publisher);

        List<Publisher> publisherList = publisherDao.getAllPublishers();

        assertEquals(2, publisherList.size());

    }
}
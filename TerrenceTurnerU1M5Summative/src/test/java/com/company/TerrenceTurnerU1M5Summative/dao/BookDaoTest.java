package com.company.TerrenceTurnerU1M5Summative.dao;

import com.company.TerrenceTurnerU1M5Summative.model.Author;
import com.company.TerrenceTurnerU1M5Summative.model.Book;
import com.company.TerrenceTurnerU1M5Summative.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestExecutionListeners;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {

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
    public void addGetDeleteBook() {

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

        Publisher publisher = new Publisher();
        publisher.setName("BookCo");
        publisher.setStreet("194 Lucky St.");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setPostal_code("98432");
        publisher.setPhone("213-914-2244");
        publisher.setEmail("bookco@gmail.com");

        publisher = publisherDao.addPublisher(publisher);

        Book book = new Book();
        book.setIsbn("999891234");
        book.setPublish_date(LocalDate.of(2019,04,17));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("The Awesome Book");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("17.92"));
        book = bookDao.addBook(book);

        Book book1 = bookDao.getBook(book.getBook_id());

        assertEquals(book, book1);

        bookDao.deleteBook(book.getBook_id());

        book1 = bookDao.getBook(book.getBook_id());

        assertNull(book1);
    }

    @Test
    public void updateBook(){

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

        Publisher publisher = new Publisher();
        publisher.setName("BookCo");
        publisher.setStreet("194 Lucky St.");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setPostal_code("98432");
        publisher.setPhone("213-914-2244");
        publisher.setEmail("bookco@gmail.com");

        publisher = publisherDao.addPublisher(publisher);

        Book book = new Book();
        book.setIsbn("999891234");
        book.setPublish_date(LocalDate.of(2019,04,17));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("The Awesome Book");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("17.92"));
        book = bookDao.addBook(book);

        book.setTitle("The Okay Book");
        book.setPrice(new BigDecimal("19.99"));

        bookDao.updateBook(book);

        Book book1 = bookDao.getBook(book.getBook_id());

        assertEquals(book, book1);


    }


    @Test
    public void getAllBooks(){

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

        Publisher publisher = new Publisher();
        publisher.setName("BookCo");
        publisher.setStreet("194 Lucky St.");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setPostal_code("98432");
        publisher.setPhone("213-914-2244");
        publisher.setEmail("bookco@gmail.com");

        publisher = publisherDao.addPublisher(publisher);

        Book book = new Book();
        book.setIsbn("999891234");
        book.setPublish_date(LocalDate.of(2019,04,17));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("The Awesome Book");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("17.92"));
        book = bookDao.addBook(book);

        book = new Book();
        book.setIsbn("9991894123");
        book.setPublish_date(LocalDate.of(2019,02,19));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("The Okay Book");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("18.88"));
        book = bookDao.addBook(book);

        List<Book> bookList = bookDao.getAllBooks();

        assertEquals(2, bookList.size());

    }

    @Test
    public void getBooksByAuthor(){

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

        Author author2 = new Author();
        author2.setFirst_name("Jim");
        author2.setLast_name("Brown");
        author2.setStreet("4355 Hidden Ct");
        author2.setCity("Beverley Hills");
        author2.setState("CA");
        author2.setPostal_code("90210");
        author2.setPhone("921-114-40215");
        author2.setEmail("brown@gmail.com");

        author2 = authorDao.addAuthor(author2);


        Publisher publisher = new Publisher();
        publisher.setName("BookCo");
        publisher.setStreet("194 Lucky St.");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setPostal_code("98432");
        publisher.setPhone("213-914-2244");
        publisher.setEmail("bookco@gmail.com");

        publisher = publisherDao.addPublisher(publisher);

        Book book = new Book();
        book.setIsbn("999891234");
        book.setPublish_date(LocalDate.of(2019,04,17));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("The Awesome Book");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("17.92"));
        book = bookDao.addBook(book);

        book = new Book();
        book.setIsbn("9991894123");
        book.setPublish_date(LocalDate.of(2019,02,19));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("The Okay Book");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("18.88"));
        book = bookDao.addBook(book);

        book = new Book();
        book.setIsbn("999189827");
        book.setPublish_date(LocalDate.of(2019,11,12));
        book.setAuthor_id(author2.getAuthor_id());
        book.setTitle("The Alright Book");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("20.11"));
        book = bookDao.addBook(book);

        List<Book> bookList = bookDao.getBooksByAuthor(author.getAuthor_id());
        assertEquals(2, bookList.size());

        bookList = bookDao.getBooksByAuthor(author2.getAuthor_id());
        assertEquals(1, bookList.size());


    }

}
package com.company.TerrenceTurnerU1M5Summative.controller;

import com.company.TerrenceTurnerU1M5Summative.model.Author;
import com.company.TerrenceTurnerU1M5Summative.model.Book;
import com.company.TerrenceTurnerU1M5Summative.model.Publisher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {


    //Book
    private List<Book> bookList = new ArrayList<Book>();

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Book addBook(@RequestBody @Valid Book book) {
        bookList.add(book);

        return book;
    }

    @RequestMapping(value = "/book/{book_id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Book> getBooks(@PathVariable int book_id) {

        return bookList;
    }

    @RequestMapping(value = "/book/{author_id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Book getBook(@PathVariable Integer author_id) {

        for (Book book : bookList) {
            if (book.getAuthor_id().equals(author_id))
                return book;
        }

        throw new IllegalArgumentException("Book not found.");
    }

    @RequestMapping(value = "/book/{book_id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteBook(@PathVariable int book_id) {

        int index = 0;
        boolean found = false;

        if (found)
            bookList.remove(index);
        else throw new IllegalArgumentException("Book not found.");
    }

    @RequestMapping(value = "/book/{book_id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updatedBook(@RequestBody @Valid Book book, @PathVariable int book_id) {

        if (book_id != book.getBook_id()) {
            throw new IllegalArgumentException("Book ID on path must match the ID in the book object");
        }

    }


    // Author
    private List<Author> authorList = new ArrayList<Author>();

    @RequestMapping(value = "/author", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Author addBook(@RequestBody @Valid Author author) {
        authorList.add(author);

        return author;
    }

    @RequestMapping(value = "/author/{author_id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Author> getAuthors(@PathVariable int author_id) {

        return authorList;
    }

    @RequestMapping(value = "/author/{author_id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteAuthor(@PathVariable int author_id) {

        int index = 0;
        boolean found = false;

        if (found)
            authorList.remove(index);
        else throw new IllegalArgumentException("Author not found.");
    }

    @RequestMapping(value = "/author/{author_id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updatedAuthor(@RequestBody @Valid Author author, @PathVariable int author_id) {

        if (author_id != author.getAuthor_id()) {
            throw new IllegalArgumentException("Author ID on path must match the ID in the author object");
        }

    }

    //Publisher
    private List<Publisher> publisherList = new ArrayList<>();

    @RequestMapping(value = "/publisher", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Publisher addPublisher(@RequestBody @Valid Publisher publisher) {
        publisherList.add(publisher);

        return publisher;
    }

    @RequestMapping(value = "/publisher/{publisher_id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Author> getPublishers(@PathVariable int publisher_id) {

        return authorList;
    }

    @RequestMapping(value = "/publisher{publisher_id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deletePublisher(@PathVariable int publisher_id) {

        int index = 0;
        boolean found = false;

        if (found)
            publisherList.remove(index);
        else throw new IllegalArgumentException("Publisher not found.");
    }

    @RequestMapping(value = "/publisher/{publisher_id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updatedPublisher(@RequestBody @Valid Publisher publisher, @PathVariable int publisher_id) {

        if (publisher_id != publisher.getPublisher_id()) {
            throw new IllegalArgumentException("Publisher ID on path must match the ID in the publisher object");
        }


    }

}





package com.company.TerrenceTurnerU1M5Summative.controller;

import com.company.TerrenceTurnerU1M5Summative.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {


    private List<Book> bookList = new ArrayList<Book>();

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Book addBook(@RequestBody @Valid Book book) {
        bookList.add(book);

        return book;
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Book> getBooks() {

        return bookList;
    }

    @RequestMapping(value = "/book/{author}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Book getBook(@PathVariable Integer author_id) {

        for(Book book : bookList) {
            if (book.getAuthor_id().equals(author_id))
                return book;
        }

        throw new IllegalArgumentException("Book not found.");
    }

    @RequestMapping(value = "/book", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteBook(){

        int pos = 0;
        boolean found = false;

        if (found)
            bookList.remove(pos);
        else throw new IllegalArgumentException("Book not found.");
    }

}





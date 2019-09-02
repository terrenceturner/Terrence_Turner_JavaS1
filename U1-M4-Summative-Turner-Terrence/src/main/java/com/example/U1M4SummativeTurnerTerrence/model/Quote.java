package com.example.U1M4SummativeTurnerTerrence.model;

import com.sun.org.apache.xpath.internal.operations.Quo;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

public class Quote {

    @NotEmpty(message = "You must supply a value for quote")
    private String quote;

    @NotEmpty(message = "You must supply a value for author")
    private String author;

    public Quote(@NotEmpty(message = "You must supply a value for quote") String quote,
                 @NotEmpty(message = "You must supply a value for author") String author) {
        this.quote = quote;
        this.author = author;
    }

    @NotEmpty(message = "You must supply a value for name")

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public static List<Quote> quoteList = new ArrayList<Quote>();

    public static List<Quote> getQuoteList() {
        return quoteList;
    }

    public static void setQuoteList(List<Quote> quoteList) {
        Quote.quoteList = quoteList;
    }
}

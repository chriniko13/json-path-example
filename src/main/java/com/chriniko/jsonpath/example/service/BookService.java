package com.chriniko.jsonpath.example.service;

import com.chriniko.jsonpath.example.domain.Book;

import java.util.List;

public interface BookService {

    List<String> getAllTitles();

    List<String> getAllAuthors();

    List<Double> getAllPrices();

    List<String> getBooksTitlesWithIsbn();

    int getNumberOfBooks();

    String getAuthorNameOfFirstBook();

    List<Book> getBooksWithIsbn();

}

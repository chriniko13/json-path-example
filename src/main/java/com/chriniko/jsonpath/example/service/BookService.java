package com.chriniko.jsonpath.example.service;

import com.chriniko.jsonpath.example.domain.Book;

import java.util.List;
import java.util.Map;

public interface BookService {

    List<String> getAllTitles();

    List<String> getAllAuthors();

    List<Double> getAllPrices();

    List<String> getBooksTitlesWithIsbn();

    int getNumberOfBooks();

    String getAuthorNameOfFirstBook();

    List<Book> getBooksWithIsbn();

    // Note: actually a POJO is a List<Map<String, Object>> which every entry in the list, is a singleton map.
    List<Map<String, Object>> getExpensiveBooks();

}

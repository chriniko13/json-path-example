package com.chriniko.jsonpath.example.service;

import com.chriniko.jsonpath.example.dao.BookDao;
import com.chriniko.jsonpath.example.domain.Book;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.TypeRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;


    @Override
    public List<String> getAllTitles() {

        String serializedBooksData = bookDao.getSerializedBooksData();

        return JsonPath.read(serializedBooksData, "$.store.books[*].title");

    }

    @Override
    public List<String> getAllAuthors() {

        String serializedBooksData = bookDao.getSerializedBooksData();

        return JsonPath.read(serializedBooksData, "$..author");
    }

    @Override
    public List<Double> getAllPrices() {

        String serializedBooksData = bookDao.getSerializedBooksData();

        return JsonPath.read(serializedBooksData, "$..price");
    }

    @Override
    public List<String> getBooksTitlesWithIsbn() {

        String serializedBooksData = bookDao.getSerializedBooksData();

        return JsonPath.read(serializedBooksData, "$..books[?(@.isbn)].title");

    }

    @Override
    public int getNumberOfBooks() {
        String serializedBooksData = bookDao.getSerializedBooksData();

        List<Integer> result = JsonPath.read(serializedBooksData, "$..books.length()");

        return result.get(0);
    }

    @Override
    public String getAuthorNameOfFirstBook() {
        String serializedBooksData = bookDao.getSerializedBooksData();

        return JsonPath.read(serializedBooksData, "$.store.books[0].author");
    }

    @Override
    public List<Book> getBooksWithIsbn() {
        String serializedBooksData = bookDao.getSerializedBooksData();

        TypeRef<List<Book>> typeRef = new TypeRef<List<Book>>() {};

        return JsonPath.parse(serializedBooksData).read("$..books[?(@.isbn)]", typeRef);
    }

}

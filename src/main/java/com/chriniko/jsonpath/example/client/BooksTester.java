package com.chriniko.jsonpath.example.client;

import com.chriniko.jsonpath.example.domain.Book;
import com.chriniko.jsonpath.example.service.BookService;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Map;

public class BooksTester {


    public static void firstExample(ApplicationContext context) {

        final BookService bookService = context.getBean("bookServiceImpl", BookService.class);


        // 1st example display all authors...
        System.out.println("~~~ AUTHORS ~~~");
        List<String> allAuthors = bookService.getAllAuthors();
        allAuthors.forEach(System.out::println);

        System.out.println();


        // 2nd example display all titles...
        System.out.println("~~~ TITLES ~~~");
        List<String> allTitles = bookService.getAllTitles();
        allTitles.forEach(System.out::println);

        System.out.println();


        // 3rd example display all titles...
        System.out.println("~~~ BOOKS TITLES WITH ISBN ~~~");
        List<String> booksTitlesWithIsbn = bookService.getBooksTitlesWithIsbn();
        booksTitlesWithIsbn.forEach(System.out::println);

        System.out.println();


        // 4th example display prices...
        System.out.println("~~~ PRICES ~~~");
        List<Double> allPrices = bookService.getAllPrices();
        allPrices.forEach(System.out::println);

        System.out.println();


        // 5th example display first book author name...
        System.out.println("~~~ FIRST BOOK AUTHOR NAME ~~~");
        String firstBookAuthorName = bookService.getAuthorNameOfFirstBook();
        System.out.println("firstBookAuthorName = " + firstBookAuthorName);

        System.out.println();


        // 6th example display number of books...
        System.out.println("~~~ NUMBER OF BOOKS ~~~");
        int numberOfBooks = bookService.getNumberOfBooks();
        System.out.println("numberOfBooks = " + numberOfBooks);

        System.out.println();


        // 7th example display all books...
        System.out.println("~~~ BOOKS ~~~");
        List<Book> booksWithIsbn = bookService.getBooksWithIsbn();
        booksWithIsbn.forEach(System.out::println);

        System.out.println();


        // 8th example display all expensive books...
        System.out.println("~~~ EXPENSIVE BOOKS ~~~");
        List<Map<String, Object>> expensiveBooks = bookService.getExpensiveBooks();
        expensiveBooks.forEach(System.out::println);

        System.out.println();

    }
}

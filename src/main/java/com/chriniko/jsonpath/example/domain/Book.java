package com.chriniko.jsonpath.example.domain;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@ToString

public class Book {

    private String category;
    private String author;
    private String title;
    private String isbn;
    private BigDecimal price;

}

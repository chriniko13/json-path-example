package com.chriniko.jsonpath.example.dao;

import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BookDaoImpl implements BookDao {

    private String cachedValue;

    @Override
    public String getSerializedBooksData() {

        if (cachedValue != null) { //quick n dirty caching...
            return cachedValue;
        }

        try {
            URI uri = Optional
                    .ofNullable(this.getClass().getClassLoader()
                    .getResource("files/sample-data.json")).orElseThrow(() -> new IllegalStateException("could not find resource!"))
                    .toURI();

            String serializedBooksData = Files
                    .readAllLines(Paths.get(uri))
                    .stream()
                    .collect(Collectors.joining());

            cachedValue = serializedBooksData;

            return serializedBooksData;

        } catch (URISyntaxException | IOException e) {
            throw new IllegalStateException("system error during read of a resource");
        }

    }
}

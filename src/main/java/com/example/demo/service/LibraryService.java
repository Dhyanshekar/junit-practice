package com.example.demo.service;

import com.example.demo.entity.BookDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LibraryService {

    private final RestTemplate restTemplate;
    private static final String MOCKED_DOWNSTREAM_URL = "http://localhost:9090/LibraryURL";

    @Autowired
    public LibraryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public BookDetails getBookDetails(Long id) {
        String url = MOCKED_DOWNSTREAM_URL + "/books/" + id;
        return restTemplate.getForObject(url, BookDetails.class);
    }

    public BookDetails addBook(BookDetails bookDetails) {
        String url = MOCKED_DOWNSTREAM_URL + "/books";
        return restTemplate.postForObject(url, bookDetails, BookDetails.class);
    }
}
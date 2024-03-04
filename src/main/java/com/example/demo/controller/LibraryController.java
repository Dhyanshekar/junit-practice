package com.example.demo.controller;

import com.example.demo.entity.BookDetails;
import com.example.demo.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/books/{id}")
    public BookDetails getBookDetails(@RequestParam Long id) {
        return libraryService.getBookDetails(id);
    }

    @PostMapping("/books")
    public BookDetails addBook(@RequestBody BookDetails bookDetails) {
        return libraryService.addBook(bookDetails);
    }
}
package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookDetails {

    private Long id;
    private String name;
    private String author;
    private String description;
    private double rating;

}
package com.interview.java.designpatterns.librarymanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Table
@Entity
public class Book {

    @Id
    private String isbn;
    private String title;
    private String publisher;
    private String authors;
    private String publishedDate;

    public Book(){

    }

    public Book(String isbn, String title, String publisher, String authors,String publishedDate){
        this.isbn = isbn;
        this.title = title;
        this.publisher = publisher;
        this.authors = authors;
        this.publishedDate = publishedDate;
    }



}

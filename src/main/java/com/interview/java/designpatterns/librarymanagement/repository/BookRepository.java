package com.interview.java.designpatterns.librarymanagement.repository;

import com.interview.java.designpatterns.librarymanagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {


}

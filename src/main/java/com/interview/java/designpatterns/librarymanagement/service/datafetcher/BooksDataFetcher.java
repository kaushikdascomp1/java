package com.interview.java.designpatterns.librarymanagement.service.datafetcher;

import com.interview.java.designpatterns.librarymanagement.model.Book;
import com.interview.java.designpatterns.librarymanagement.repository.BookRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BooksDataFetcher implements DataFetcher<Book> {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book get(DataFetchingEnvironment dataFetchingEnvironment) {
        Optional<Book> bookItem = bookRepository.findById(dataFetchingEnvironment.getArgument("id"));
        return bookItem.isPresent() ? bookItem.get() : null ;
    }
}

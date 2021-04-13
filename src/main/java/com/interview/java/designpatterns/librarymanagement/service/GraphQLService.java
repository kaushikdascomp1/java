package com.interview.java.designpatterns.librarymanagement.service;

import com.interview.java.designpatterns.librarymanagement.model.Book;
import com.interview.java.designpatterns.librarymanagement.repository.BookRepository;
import com.interview.java.designpatterns.librarymanagement.service.datafetcher.AllBooksDataFetcher;
import com.interview.java.designpatterns.librarymanagement.service.datafetcher.BooksDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

@Service
public class GraphQLService {

    @Value("classpath:books.graphql")
    Resource resource;

    @Autowired
    BookRepository bookRepository;

    private GraphQL graphQL;

    @Autowired
    AllBooksDataFetcher allBooksDataFetcher;

    @Autowired
    BooksDataFetcher booksDataFetcher;

    @PostConstruct
    public void loadSchema() throws IOException {
        //Load Books into Repository
        loadDataIntoHSQL();
        //get the schema
        File schemaFile = resource.getFile();
        //parse schema
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private void loadDataIntoHSQL() {

        Stream.of(
                new Book("123","Book Of Clouds","Kindle Edition", "Chloe Ardijs","Nov 2017"),
                new Book("124","Cloud Arch","Orieilly", "Peter","Oct 2018"),
                new Book("125","Java 9 Programming","Orieilly", "Venkat","Oct 2019")


        ).forEach(book->{
            bookRepository.save(book);
        });
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query",typeWiring->typeWiring
                .dataFetcher("allBooks",allBooksDataFetcher)
                .dataFetcher("book",booksDataFetcher))
                .build();

    }

    public GraphQL getGraphQL(){
        return graphQL;
    }


}

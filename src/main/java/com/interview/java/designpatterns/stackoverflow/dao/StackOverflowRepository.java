package com.interview.java.designpatterns.stackoverflow.dao;


import com.interview.java.designpatterns.stackoverflow.model.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StackOverflowRepository  extends CrudRepository<Question,Long> {

    @Override
    <S extends Question> S save(S s);

    @Override
    Iterable<Question> findAll();

    @Query("SELECT t FROM Question t where t.title LIKE %:text%")
    List<Question> findByTitle(@Param("text") String text);

    @Query("SELECT t FROM Question t where (t.title LIKE %:text% or t.desc LIKE %:text%)")
    List<Question> search(@Param("text") String text);


}

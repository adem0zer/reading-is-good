package com.adem.readingisgood.repository;

import com.adem.readingisgood.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsByBookName(String bookName);

    @Query("select b from Book b where b.id in ?1")
    List<Book> findByIdIn(Collection<Long> ids);

}

package com.example.easynotes.repository;

import com.example.easynotes.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Book, Long> {

}

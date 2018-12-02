package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Book;
import com.example.easynotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by hansa
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class BookController {

    @Autowired
    NoteRepository bookRepository;


    @GetMapping("/books")
    public List<Book> getAllNotes() {
        return bookRepository.findAll();
    }

    @PostMapping("/books")
    public Book createNote(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("/books/{id}")
    public Book getNoteById(@PathVariable(value = "id") Long noteId) {
        return bookRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", noteId));
    }

    @PutMapping("/books/{id}")
    public Book updateNote(@PathVariable(value = "id") Long noteId,
                           @Valid @RequestBody Book bookDetails) {

        Book book = bookRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", noteId));

        book.setTitle(bookDetails.getTitle());
        book.setContent(bookDetails.getContent());
        book.setAuthor(bookDetails.getAuthor());
        book.setImage(bookDetails.getImage());

        Book updatedBook = bookRepository.save(book);
        return updatedBook;
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        Book book = bookRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", noteId));

        bookRepository.delete(book);

        return ResponseEntity.ok().build();
    }

    //---------------------------------------DVD s--------------------------------------------------------//
}
package com.example.easynotes.controller;


import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Book;
import com.example.easynotes.model.Dvd;
import com.example.easynotes.repository.DvdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class DvdController {

    @Autowired
    DvdRepository dvdRepository;

    @GetMapping("/dvds")
    public List<Dvd> getAllNotes() {
        return dvdRepository.findAll();
    }

    @PostMapping("/dvds")
    public Dvd createNote(@Valid @RequestBody Dvd dvd) {
        return dvdRepository.save(dvd);
    }

    @GetMapping("/dvds/{id}")
    public Dvd getNoteById(@PathVariable(value = "id") Long dvdId) {
        return dvdRepository.findById(dvdId)
                .orElseThrow(() -> new ResourceNotFoundException("Dvd", "id", dvdId));
    }

    @PutMapping("/dvds/{id}")
    public Dvd updateNote(@PathVariable(value = "id") Long dvdId,
                           @Valid @RequestBody Book bookDetails) {

        Dvd dvd = dvdRepository.findById(dvdId)
                .orElseThrow(() -> new ResourceNotFoundException("Dvd", "id", dvdId));

        dvd.setTitle(bookDetails.getTitle());
        dvd.setContent(bookDetails.getContent());
        dvd.setAuthor(bookDetails.getAuthor());
        dvd.setImage(bookDetails.getAuthor());

        Dvd updatedDvd = dvdRepository.save(dvd);
        return updatedDvd;
    }

    @DeleteMapping("/dvds/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long dvdId) {
        Dvd dvd = dvdRepository.findById(dvdId)
                .orElseThrow(() -> new ResourceNotFoundException("Dvd", "id", dvdId));

        dvdRepository.delete(dvd);

        return ResponseEntity.ok().build();
    }

}



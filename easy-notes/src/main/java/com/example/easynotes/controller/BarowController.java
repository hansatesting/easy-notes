package com.example.easynotes.controller;


import com.example.easynotes.model.Barrow;
import com.example.easynotes.model.Book;
import com.example.easynotes.repository.BarrowRepository;
import com.example.easynotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class BarowController {

    @Autowired
    BarrowRepository barrowRepository;


    @PostMapping("/barrow")
    public Barrow createNote(@Valid @RequestBody Barrow barrow) {
        return barrowRepository.save(barrow);
    }
}

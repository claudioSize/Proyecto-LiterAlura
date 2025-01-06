package org.example.literatualura.Controller;

import org.example.literatualura.DTO.DTOMapAuthorLang;
import org.example.literatualura.DTO.DTOMapBook;
import org.example.literatualura.Entitys.LibroEntity;
import org.example.literatualura.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class Controller {

    @Autowired
    private GetBooks getBooks;
    @Autowired
    SaveBook saveBook;
    @Autowired
    GetAuthoresYear getAuthoresYear;
    @Autowired
    GetByLanguage getByLanguage;
    @Autowired
    GetAuthor getAuthors;

    @GetMapping("/books/list")
    @Transactional
    public ResponseEntity<List<DTOMapBook>> getLibro() {
        return ResponseEntity.ok(getBooks.getBooksList());
    }
    @GetMapping("/author/list")
    @Transactional
    public ResponseEntity<List<DTOMapAuthorLang>> getAuthorList() {
        return ResponseEntity.ok(getAuthors.getAuthor());
    }

    @GetMapping("/author/birth/{year}")
    @Transactional
    public ResponseEntity<List<DTOMapAuthorLang>> getAuthorByYears(@PathVariable Integer year) {
        return ResponseEntity.ok(getAuthoresYear.getAuthorYears(year));
    }

    @GetMapping("/books/language/{lang}")
    @Transactional
    public ResponseEntity<List<DTOMapAuthorLang>> getBookByLang(@PathVariable String lang) {
        return ResponseEntity.ok(getByLanguage.getBookByLanguages(lang));
    }


    @PostMapping("/search/{book}")
    @Transactional
    public ResponseEntity<LibroEntity> saveLibro(@PathVariable String book) {

        return ResponseEntity.ok(saveBook.saveBook(book));
    }

}



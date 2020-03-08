package com.lixian.daarbibli.web.rest;

import com.lixian.daarbibli.service.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksResource {

    BooksService booksService;

    public BooksResource(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/default")
    public ResponseEntity<List<String>> getFilesName(@RequestParam("word") String word) {
        return ResponseEntity.ok(booksService.getAllFileNameContainingTheWord(word));
    }
    @GetMapping("/closeness")
    public ResponseEntity<List<String>> getFilesNameCloseness(@RequestParam("word") String word) {
        return ResponseEntity.ok(booksService.sortBookByClosness(booksService.getAllFileNameContainingTheWord(word)));
    }
    @GetMapping("/suggestion")
    public ResponseEntity<List<String>> getFilesNameSuggestion(@RequestParam("filename") String filename) {
        return ResponseEntity.ok(booksService.getFilesSuggestion(filename));
    }

}

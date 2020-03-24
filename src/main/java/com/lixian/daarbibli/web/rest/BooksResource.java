package com.lixian.daarbibli.web.rest;

import com.lixian.daarbibli.service.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
public class BooksResource {

    BooksService booksService;

    public BooksResource(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/default")
    public ResponseEntity<List<String>> getFilesName(@RequestParam("word") String word) {
        return ResponseEntity.ok(booksService.getAllFileNameContainingTheWord(word).subList(0,20));
    }
    @GetMapping("/closeness")
    public ResponseEntity<List<String>> getFilesNameCloseness(@RequestParam("word") String word) {
        return ResponseEntity.ok(booksService.sortBookByClosness(booksService.getAllFileNameContainingTheWord(word)).subList(0,20));
    }
    @GetMapping("/suggestion")
    public ResponseEntity<List<String>> getFilesNameSuggestion(@RequestParam("filename") String filename) {
        return ResponseEntity.ok(booksService.getFilesSuggestion(filename,10));
    }
//    @GetMapping("/getTitleAndAuthor")
//    public  ResponseEntity<Map<String,String>> getTitleAndAuthor(@RequestParam("filename") String filename) {
//        return ResponseEntity.ok();
//    }
}

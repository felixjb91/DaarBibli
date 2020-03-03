package com.lixian.daarbibli.web.rest;

import com.lixian.daarbibli.service.IndexingService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksResource {

    IndexingService indexingService;

    public BooksResource(IndexingService indexingService) {
        this.indexingService = indexingService;
    }

    @GetMapping("/fileName")
    public ResponseEntity<List<String>> getFileNameFromIndex(@RequestParam("word") String word){
        return ResponseEntity.ok(indexingService.getAllFileNameContainingTheWord(word));
    }
}

package com.lixian.daarbibli.web.rest;

import com.lixian.daarbibli.service.BooksService;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
    public ResponseEntity getFilesName(@RequestParam("word") String word, @RequestParam("page") int numPage) {
        List<String> list = booksService.getAllFileNameContainingTheWord(word);

        PagedListHolder page = new PagedListHolder(list);
        page.setPageSize(20);
        page.setPage(numPage);

        page.getPageCount();
        page.getPageList();

        return ResponseEntity.ok(page.getPageList());
    }

//    @GetMapping("/default")
//    public ResponseEntity getFilesName(@RequestParam("word") String word, @RequestParam("page") int numPage, @RequestParam("pageSize") int pageSize) {
//        List<String> list = booksService.getAllFileNameContainingTheWord(word);
//
//        PagedListHolder page = new PagedListHolder(list);
//        page.setPageSize(pageSize);
//        page.setPage(numPage);
//        page.getPageCount();
//        page.getPageList();
//
//        Map<String,Object> result = new HashMap<>();
//        Map<String,Object> map = new HashMap<>();
//        map.put("page",page.getPageList());
//        map.put("pageLength",page.getPageCount());
//        result.put("result",result);
//        return ResponseEntity.ok(result);
//    }
//
    @GetMapping("/closeness")
    public ResponseEntity<List<String>> getFilesNameCloseness(@RequestParam("word") String word) {
        return ResponseEntity.ok(booksService.sortBookByClosness(booksService.getAllFileNameContainingTheWord(word)));
    }
    @GetMapping("/suggestion")
    public ResponseEntity<List<String>> getFilesNameSuggestion(@RequestParam("filename") String filename) {
        return ResponseEntity.ok(booksService.getFilesSuggestion(filename,10));
    }
}

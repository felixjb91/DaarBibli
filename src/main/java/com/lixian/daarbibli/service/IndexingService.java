package com.lixian.daarbibli.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class IndexingService {

    String pathIndex = "src/main/resources/booksResources/indexedFiles";

    public IndexingService() {}

    public List<String> getAllFileNameContainingTheWord(String word) {
        List<File> files = Arrays.asList(Objects.requireNonNull(new File(pathIndex).listFiles()));
        return files.stream()
            .filter(file -> {
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String st;
                    while ((st = br.readLine()) != null) {
                        String current = st.split(" ")[0];
                        if(current.matches(word)){
                            br.close();
                            return true;
                        }
                    }
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return false;
            })
            .map(file -> file.getName().substring(9))
            .collect(Collectors.toList());
    }
}

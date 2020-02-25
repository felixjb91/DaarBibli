package com.lixian.daarbibli;

import com.lixian.daarbibli.service.algosDocuments.Indexing;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class mainTest {
    public static void main(String[] args) {
        List<String> results = new ArrayList<String>();

        List<File> files = Arrays.asList(Objects.requireNonNull(new File("src/main/resources/gutenbergBooks").listFiles()));
        files.subList(0,20).forEach(Indexing::new);
    }
}

package com.lixian.daarbibli;

import com.lixian.daarbibli.service.BooksService;
import com.lixian.daarbibli.service.algosDocuments.Closeness;
import com.lixian.daarbibli.service.algosDocuments.DistanceJaccard;
import com.lixian.daarbibli.service.algosDocuments.Indexing;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class mainTest {
    public static void main(String[] args) throws IOException {

        String booksResources = "src/main/resources/booksResources/";

        // Décommenter quand on voudra charger tous les livres

//        List<File> files = Arrays.asList(Objects.requireNonNull(new File(booksResources+"gutenbergBooks").listFiles()));
//        files.forEach(f -> new Indexing2(f.getName()));
//        files.forEach(Indexing2::new);

//        DistanceJaccard dj = new DistanceJaccard();
//        dj.calculer();
//
//        Closeness cl = new Closeness();
//        cl.calculer();
    }
}

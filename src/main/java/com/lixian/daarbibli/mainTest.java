package com.lixian.daarbibli;

import com.lixian.daarbibli.service.IndexingService;
import com.lixian.daarbibli.service.algosDocuments.DistanceJaccard;
import com.lixian.daarbibli.service.algosDocuments.Indexing;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class mainTest {
    public static void main(String[] args) throws IOException {

        String booksResources = "src/main/resources/booksResources/";

        // Décommenter quand on voudra charger tous les livres
        /*
        List<File> files = Arrays.asList(Objects.requireNonNull(new File(booksResources+"gutenbergBooks").listFiles()));
        files.subList(0,20).forEach(Indexing::new);

        IndexingService is = new IndexingService();
        System.out.println(is.getAllFileNameContainingTheWord("Sargon"));

        DistanceJaccard dj = new DistanceJaccard();
        dj.calculer();
        */


    }
}

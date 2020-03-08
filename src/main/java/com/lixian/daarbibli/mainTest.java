package com.lixian.daarbibli;

import com.lixian.daarbibli.service.algosDocuments.Closeness;

import java.io.IOException;

public class mainTest {
    public static void main(String[] args) throws IOException {

        String booksResources = "src/main/resources/booksResources/";

        // Décommenter quand on voudra charger tous les livres
        /*
        List<File> files = Arrays.asList(Objects.requireNonNull(new File(booksResources+"gutenbergBooks").listFiles()));
        files.forEach(Indexing::new);

        IndexingService is = new IndexingService();
        System.out.println(is.getAllFileNameContainingTheWord("Sargon"));

        DistanceJaccard dj = new DistanceJaccard();
        dj.calculer();

        Closeness cl = new Closeness();
        cl.calculer();
        */
    }
}

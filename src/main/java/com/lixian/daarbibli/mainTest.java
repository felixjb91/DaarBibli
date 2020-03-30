package com.lixian.daarbibli;

import com.lixian.daarbibli.service.BooksService;
import com.lixian.daarbibli.service.Utile;
import com.lixian.daarbibli.service.algosDocuments.Closeness;
import com.lixian.daarbibli.service.algosDocuments.DistanceJaccard;
import com.lixian.daarbibli.service.algosDocuments.Indexing;
import com.lixian.daarbibli.service.algosDocuments.Indexing2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class mainTest {
    public static void main(String[] args) throws IOException {

        String booksResources = "src/main/resources/booksResources/";


        List<File> files = Arrays.asList(Objects.requireNonNull(new File(booksResources+"gutenbergBooks").listFiles()));
        List<String> filesName = files.subList(0,100).stream().map(File::getName).collect(Collectors.toList());
        List<Map<String,String>> resultTxt = Utile.getTitleAndAuthorFromTxt(filesName);
        List<Map<String,String>> resultWeb = Utile.getTitleAndAuthorFromTxt(filesName);

        System.out.println(resultTxt.get(0).keySet().size()+resultWeb.get(0).keySet().size());

//        List<String> filesname = files.stream().map(File::getName).collect(Collectors.toList());
//        System.out.println(Utile.getTitleAndAuthorFromWeb(filesname.subList(0,5)));

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

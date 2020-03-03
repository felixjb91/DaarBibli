package com.lixian.daarbibli.service.algosDocuments;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Closeness {

    private String booksResources = "src/main/resources/booksResources/";
    private List<File> fichiers;
    private List<String> result;

    public Closeness() throws IOException {
        this.result = new ArrayList<String>();
        this.fichiers =  Arrays.asList(Objects.requireNonNull(new File(this.booksResources+"indexedFiles").listFiles()));
    }

    public void calculer() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(booksResources+"jaccardDistances.txt"));
        ArrayList<ArrayList<String>> jaccards = new ArrayList<ArrayList<String>>();
        String st;
        while ((st = br.readLine()) != null) {
            String[] decoupe = st.split("=");
            String[] fichiers = decoupe[0].split(",");

            ArrayList<String> jacc = new ArrayList<String>();

            jacc.add(fichiers[0].trim());
            jacc.add(fichiers[1].trim());
            jacc.add(decoupe[1].trim());

            jaccards.add(jacc);
        }

        for (File f : fichiers) {
            Double result = 0.0;
            for (ArrayList<String> ja : jaccards) {
                if (ja.get(0).equals(f.getName()) || ja.get(1).equals(f.getName())) {
                    result += Double.parseDouble(ja.get(2).trim());
                }
            }
            if (result != 0.0) {
                result = 1 / result;
            }
            this.result.add(f.getName()+"="+result);
        }
        publierValeur();
    }

    public void publierValeur() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(booksResources+"closeness.txt"));
        for (String f : result) {
            writer.write(f);
            writer.write('\n');
        }

        writer.close();
    }
}

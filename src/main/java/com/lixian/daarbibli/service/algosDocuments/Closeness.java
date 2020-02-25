package com.lixian.daarbibli.service.algosDocuments;

import java.io.*;
import java.util.ArrayList;

public class Closeness {
    private ArrayList<String> fichiers;
    private ArrayList<String> result;
    public Closeness(ArrayList<String> fichiers) throws IOException {
        this.result = new ArrayList<String>();
        this.fichiers = fichiers;
        calculer();
    }

    public void calculer() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("jaccard.txt"));
        ArrayList<ArrayList<String>> jaccards = new ArrayList<ArrayList<String>>();
        String st;
        while ((st = br.readLine()) != null) {
            String[] decoupe = st.split("=");
            String[] fichiers = decoupe[0].split(",");

            ArrayList<String> ne = new ArrayList<String>();

            ne.add(fichiers[0].trim());
            ne.add(fichiers[1].trim());
            ne.add(decoupe[1].trim());

            jaccards.add(ne);
        }

        for (String f : fichiers) {
            Double result = 0.0;
            for (ArrayList<String> ja : jaccards) {
                if (ja.get(0).equals(f) || ja.get(1).equals(f)) {
                    result += Double.parseDouble(ja.get(2).trim());
                }
            }
            if (result != 0.0) {
                result = 1 / result;
            }
            this.result.add(f+"="+result);
        }
        publierValeur();
    }

    public void publierValeur() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("closeness.txt"));
        for (String f : result) {
            writer.write(f);
            writer.write('\n');
        }

        writer.close();
    }
}

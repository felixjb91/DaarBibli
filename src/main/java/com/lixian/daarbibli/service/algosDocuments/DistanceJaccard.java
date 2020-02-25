package com.lixian.daarbibli.service.algosDocuments;

import com.lixian.daarbibli.domain.algoEntities.Jaccard;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DistanceJaccard {
    private String booksResources = "src/main/resources/booksResources/";
    private List<File> fichiers;
    private List<String> result;

    public DistanceJaccard() throws IOException {
        this.fichiers =  Arrays.asList(Objects.requireNonNull(new File(booksResources+"indexedFiles").listFiles()));;
        this.result = new ArrayList<String>();
        calculer();
    }

    public void calculer() throws IOException {

        for (int i = 0; i < fichiers.size(); i++) {
            for (int j = i+1; j < fichiers.size(); j++) {

                File file1 = fichiers.get(i);
                File file2 = fichiers.get(j);

                System.out.println(file1.getName()+ " ; "+file2.getName());

                Jaccard jaccard1 = this.readIndexWithOccurence(file1);
                Jaccard jaccard2 = this.readIndexWithOccurence(file2);

                float sommeSoustraction = 0;
                float sommeMax = 0;

                List<String> mots1 = jaccard1.getMots();
                List<String> mots2 = jaccard2.getMots();

                List<String> intersection = mots1.stream().filter(mots2::contains).collect(Collectors.toList());
                List<String> difference = mots1.stream().filter(mot -> !intersection.contains(mot)).collect(Collectors.toList());
                difference.addAll(mots2.stream().filter(mot -> !intersection.contains(mot)).collect(Collectors.toList()));

                for(String mot: intersection) {
                    int nbW1 = jaccard1.getOccurences().get(mots1.indexOf(mot));
                    int nbW2 = jaccard2.getOccurences().get(mots2.indexOf(mot));
                    sommeSoustraction += (Integer.max(nbW1, nbW2) - Integer.min(nbW1, nbW2));
                    sommeMax += Integer.max(nbW1, nbW2);
                }
                for(String mot: difference) {
                    int nbW = mots1.contains(mot) ?
                            jaccard1.getOccurences().get(mots1.indexOf(mot)) :
                            jaccard2.getOccurences().get(mots2.indexOf(mot));
                    sommeSoustraction += nbW;
                    sommeMax += nbW;
                }
                float distanceJaccard = sommeSoustraction / sommeMax;
                this.result.add(file1.getName()+","+file2.getName()+"="+distanceJaccard);
            }
        }
        publierValeur();
    }

    public void publierValeur() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(booksResources+"jaccardDistances.txt"));
        for (String r : result) {
            writer.write(r);
            writer.write('\n');
        }
        writer.close();
    }


    /**
     *
     * @return
     * @throws IOException
     */
    public ArrayList<String> readIndex(File file) throws IOException {
        ArrayList<String> result = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(booksResources + "indexedFiles/indexing_"+file.getName()));
        String st;
        while ((st = br.readLine()) != null) {
            //Index index = new Index();
            String[] ligne = st.split("=");
            //index.setMot(ligne[0].trim());
            //String[] liste_mots = ligne[1].split("-");
            //index.setNb_apparition(liste_mots.length);
            result.add(ligne[0].trim());
        }
        return result;
    }

    public Jaccard readIndexWithOccurence(File file) throws IOException {

        ArrayList<String> mot = new ArrayList<String>();
        ArrayList<Integer> occurence = new ArrayList<Integer>();

        BufferedReader br = new BufferedReader(new FileReader(booksResources + "indexedFiles/"+file.getName()));
        String st;
        while ((st = br.readLine()) != null) {
            String[] ligne = st.split("=");
            mot.add(ligne[0].trim());
            String[] nb_occurence = ligne[1].trim().split("-");
            occurence.add(nb_occurence.length);
        }

        Jaccard result = new Jaccard(mot, occurence);

        return result;
    }
}

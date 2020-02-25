package com.lixian.daarbibli.service.algosDocuments;

import com.lixian.daarbibli.domain.algoEntities.Jaccard;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DistanceJaccard {
    private ArrayList<String> fichiers;
    private ArrayList<String> result;

    public DistanceJaccard(ArrayList<String> fichiers) throws IOException {
        this.fichiers = fichiers;
        this.result = new ArrayList<String>();
        calculer();
    }

    public void calculer() throws IOException {
//
//        for (int i = 0; i < fichiers.size(); i++) {
//            for (int j = i+1; j < fichiers.size(); j++) {
//
//                String fichier1 = fichiers.get(i);
//                String fichier2 = fichiers.get(j);
//
//                Indexing i1 = new Indexing(fichier1, 2);
//                Jaccard liste_1 = i1.readIndexWithOccurence();
//
//                Indexing i2 = new Indexing( fichier2, 2);
//                Jaccard liste_2 = i2.readIndexWithOccurence();
//
//                int gauche = liste_1.total();
//                int droit = liste_2.total();
//                int inter = 0;
//
//                for (int k = 0; k < liste_1.getMots().size(); k++) {
//                    for (int l = 0; l < liste_2.getMots().size(); l++) {
//
//                        if (liste_1.getMots().get(k).equals(liste_2.getMots().get(l))) {
//
//                            if (liste_1.getOccurences().get(k)==liste_2.getOccurences().get(l)) {
//                                inter += liste_1.getOccurences().get(k);
//                                gauche -= liste_1.getOccurences().get(k);
//                                droit -= liste_1.getOccurences().get(k);
//                            } else if (liste_1.getOccurences().get(k)>liste_2.getOccurences().get(l)) {
//                                inter += liste_2.getOccurences().get(l);
//                                //gauche += liste_1.getOccurences().get(k)-liste_2.getOccurences().get(l);
//                                gauche -= liste_2.getOccurences().get(l);
//                                droit -= liste_2.getOccurences().get(l);
//                            } else {
//                                inter += liste_1.getOccurences().get(k);
//                                //droit += liste_2.getOccurences().get(l)-liste_1.getOccurences().get(k);
//                                gauche -= liste_1.getOccurences().get(k);
//                                droit -= liste_1.getOccurences().get(k);
//                            }
//
//                        }
//                    }
//                }
//
//                int denominateur = gauche + droit - inter;
//                float result = (float)inter / denominateur;
//                this.result.add(fichier1+","+fichier2+"="+result);
//            }
//        }
//        publierValeur();
    }

    public void publierValeur() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("jaccard.txt"));
        for (String r : result) {
            writer.write(r);
            writer.write('\n');
        }
        writer.close();
    }
}

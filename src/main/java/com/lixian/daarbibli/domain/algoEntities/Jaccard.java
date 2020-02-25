package com.lixian.daarbibli.domain.algoEntities;

import java.util.List;

public class Jaccard {
    private List<String> mots;
    private List<Integer> occurences;

    public Jaccard(List<String> mots, List<Integer> occurences) {
        this.mots = mots;
        this.occurences = occurences;
    }

    public List<String> getMots() {
        return mots;
    }

    public List<Integer> getOccurences() {
        return occurences;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < mots.size(); i++) {
            result += getMots().get(i)+"-"+getOccurences().get(i)+"\n";
        }
        return result;
    }

    public Integer nbWords() { return this.occurences.stream().reduce(0, Integer::sum); }
}

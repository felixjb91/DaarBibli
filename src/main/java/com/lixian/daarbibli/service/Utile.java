package com.lixian.daarbibli.service;

import java.util.*;
import java.util.stream.Collectors;

public class Utile {

    public static Map<String,Double> sortResultByValueDouble(Map<String,Double> result) {
        return result.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new)
            );
    }

    public static Map<String,Integer> sortResultByValueInteger(Map<String,Integer> result) {
        return result.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new)
            );
    }

    public static Map<String,Double> sortResultByValueDoubleReversed(Map<String,Double> result) {
        return result.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new)
            );
    }

//    public static Map<String,Double> getTopResultSorted(Map<String,Double> input, int nbSuggestion) {
//        Map<String,Double> result = new HashMap<>();
//        List<String> resultKey = new ArrayList<>();
//        List<Double> resultValue = new ArrayList<>();
//        int indexOfMax=0;
//        for(Map.Entry<String,Double> entry : input.entrySet()) {
//            if (resultKey.size() < nbSuggestion) {
//                resultKey.add(entry.getKey());
//                resultValue.add(entry.getValue());
//            }
//            else {
//                indexOfMax = resultValue.indexOf(Collections.max(resultValue));
//                if (entry.getValue() < Collections.min(resultValue)) {
//                    resultKey.set(indexOfMax, entry.getKey());
//                    resultValue.set(indexOfMax, entry.getValue());
//                }
//            }
//        }
//        for(int i=0; i<nbSuggestion; i++)  result.put(resultKey.get(i), resultValue.get(i));
//        return sortResultByValueDoubleReversed(result);
//    }

}

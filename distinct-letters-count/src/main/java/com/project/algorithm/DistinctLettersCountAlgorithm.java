package com.project.algorithm;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Alper Gurek
 * @since  11.03.2021
 */

public class DistinctLettersCountAlgorithm {

    private ArrayList<Integer> totalSameLetterCounts ;
    private int distinctLettersCount;

    /**
     *
     * @param line Every line of the file will be check about the distinct
     *             letters counts. If there will be constraints. It shows screen.
     *             Otherwise , the result will be shown on the command line.
     * @return  Times of the delete items count about the line will be return of that method.
     */
    public int getDistinctLettersCountOnLine(String line)
    {
        distinctLettersCount = 0;
        totalSameLetterCounts = new ArrayList<>();
        totalSameLetterCounts = getTotalSameLettersCounts(line);
        Collections.sort(totalSameLetterCounts);

            if (totalSameLetterCounts.size() > 1) {
                int i=0;
                while(i < totalSameLetterCounts.size()) {
                    int count = totalSameLetterCounts.get(i);
                    if(count >0) {
                        for (int j = 0; j < totalSameLetterCounts.size(); j++) {
                            int countNextElement = totalSameLetterCounts.get(j);
                            if (i != j && count == countNextElement) {
                                    totalSameLetterCounts.set(i, count - 1);
                                    distinctLettersCount++;
                                    i = i - 1;
                                    break;
                            }
                        }
                    }
                    i++;
                }
            } else {
                return 0;
            }
        return distinctLettersCount;
    }

    /**
     * That method represents a letter in the file how many times included in a line of that txt file.
     * Simple way of the calculate the times of a single letter in a line included.
     * @param line Every line of the file will be input to that method.
     * @return
     */
    private ArrayList<Integer> getTotalSameLettersCounts(String line) {
        ArrayList<Integer> list = new ArrayList<>();
        try {
            int i = 0;
            while (i < line.length()) {
                String ch = Character.toString(line.charAt(i));
                int count = line.length() - line.replaceAll(ch, "").length();
                line = line.replaceAll(ch, "");
                list.add(count);
            }
            return list;
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return list;
    }
}

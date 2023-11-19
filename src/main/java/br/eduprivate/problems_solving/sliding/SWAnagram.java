package br.eduprivate.problems_solving.sliding;

import java.util.*;

class SWAnagram {
    public static int countAnagrams(String text, String word)
    {
        // change CHARACTERS to support range of supported
        // characters
        int CHARACTERS = 256;
        int sn = text.length();
        int pn = word.length();
        int count = 0;
        if (sn < 0 || pn < 0 || sn < pn)
            return 0;

        char[] pArr = new char[CHARACTERS];
        char[] sArr = new char[CHARACTERS];
        int i = 0;
        // till window size
        for (; i < pn; i++) {
            sArr[CHARACTERS - text.charAt(i)]++;
            pArr[CHARACTERS - word.charAt(i)]++;
        }
        if (Arrays.equals(pArr, sArr))
            count += 1;
        // next window
        for (; i < sn; i++) {
            sArr[CHARACTERS - text.charAt(i)]++;
            sArr[CHARACTERS - text.charAt(i - pn)]--;

            if (Arrays.equals(pArr, sArr))
                count += 1;
        }
        return count;
    }

    public static void main(String args[])
    {
        String text = "forxxorfxdofr";
        String word = "for";
        System.out.print(countAnagrams(text, word));
    }
}
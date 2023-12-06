package br.eduprivate.problems_solving.longestcommonsubstring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommonSubstring2 {

    public static void main(String[] args)
    {
        String X = "OldSite:GeeksforGeeks.orgPalindromes";
        String Y = "NewSite:GeeksQuiz.comPalindromes";

        int m = X.length();
        int n = Y.length();

        System.out.println(
                "Length of Longest Common Substring is "
                        + LCSubStr(X.toCharArray(), Y.toCharArray(), m,
                        n));
    }

    private static String LCSubStr(char[] charArray, char[] charArray1, int m, int n) {

        int size = 0;
        List<Integer> sizes = new ArrayList<>();
        for (int i = 0; i < charArray.length && i < charArray1.length; i++) {

            if(charArray[i] == charArray1[i]) {
                size++;
            } else{
                sizes.add(size);
                size = 0;
            }
        }
        Collections.sort(sizes);
        return sizes.get(sizes.size()-1).toString();
    }
}

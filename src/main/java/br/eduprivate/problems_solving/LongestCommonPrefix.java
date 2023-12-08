package br.eduprivate.problems_solving;

import br.eduprivate.dswalgol.vector.NodeList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        List<String> prefix = new ArrayList<>();
        Arrays.sort(strs);
        int size = strs.length;

        int sizeT = Math.min(strs[0].length(), strs[size-1].length());

        int count = 0;
        while (count < sizeT && strs[0].charAt(count) == strs[size-1].charAt(count)){
            count++;
        }

        return strs[0].substring(0,count);
    }

    public static void main(String[] args)
    {
        String arr[] = new String[]{"flower","flow","flight"};
        LongestCommonPrefix commonPrefix = new LongestCommonPrefix();
        System.out.println(commonPrefix.longestCommonPrefix(arr));
    }
}

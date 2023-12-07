package br.eduprivate.problems_solving;

import java.math.BigInteger;
class LargestOddNumber {
    public String largestOddNumber(String num) {

        Integer last = Integer.parseInt(num.substring(num.length()-1));
        if (!(last % 2 == 0)) {
            return num;
        }

        for(int i = num.length()-1; i >= 0; i--){

           last = Character.getNumericValue(num.charAt(i));
            if (!(last % 2 == 0)) {
                if (i == 0) {
                    return last.toString();
                }else
                    return num.substring(0, i+1);
            }
        }

        return "";
    }

    public static void main(String[] args) {
        LargestOddNumber largest = new LargestOddNumber();
        System.out.println(largest.largestOddNumber("10133890"));
    }
}
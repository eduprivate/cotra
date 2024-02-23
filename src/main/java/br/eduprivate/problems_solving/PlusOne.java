package br.eduprivate.problems_solving;

import java.util.Arrays;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >=0 ; i--) {
            if (digits[i] < 9) {
                digits[i]++;
            }
            digits[i] = 0;
        }

        int digits2[] = new int[digits.length + 1];
        digits2[0] = 1;
        return digits2;
    }


    public static void main(String[] args) {
        int[] digits = {1,9};
        PlusOne plusOne = new PlusOne();
        System.out.println(Arrays.toString(plusOne.plusOne(digits)));
    }
}

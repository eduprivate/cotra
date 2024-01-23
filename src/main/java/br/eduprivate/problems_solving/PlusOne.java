package br.eduprivate.problems_solving;

public class PlusOne {

    public int[] plusOne(int[] digits) {

        int lastDigit = digits.length;
        int digit = digits[lastDigit];

        digit = digit+1;
        if (digit == 10) {
            int[] newDigits = new int[digits.length + 1];

            for (int i = 1; i < newDigits.length; i++) {
                newDigits[i] = digits[i-1];
            }
            digits = newDigits;

            changeDigit(digits, lastDigit);
        } else{
            digits[lastDigit] = digit;
        }

        return digits;
    }

    private void changeDigit(int[] digits, int i) {
        if (i == 0) {
            digits[i] = 1;
        }
        else {
            int digit = digits[i]+1;
            if (digit == 10) {
                digits[i] = 0;
                changeDigit(digits, i-1);
            }
            else{
                digits[i] = digit;
            }
        }
    }


    public static void main(String[] args) {
        int[] digits = {1};
        PlusOne plusOne = new PlusOne();
        System.out.println(plusOne.plusOne(digits));
    }
}

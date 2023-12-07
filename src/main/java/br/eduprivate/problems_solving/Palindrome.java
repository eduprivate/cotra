package br.eduprivate.problems_solving;

import java.util.Arrays;

public class Palindrome {
    public boolean isPalindrome(int x) {
        String original = Integer.toString(x);
        String reverse = new StringBuilder(original).reverse().toString();

        return original.equalsIgnoreCase(reverse);
    }

    public static void main(String[] args)
    {
        Palindrome palindrome = new Palindrome();
        int target = 33;

        System.out.println(palindrome.isPalindrome(target));
    }

}

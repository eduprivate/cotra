package br.eduprivate.problems_solving.sliding;


public class BTSubstringContainingPattern {

    // Function to check if any substring of length mid contains
    // all characters of the pattern
    static boolean isValid(String str, String pattern, int mid, int[] start) {
        // Count the frequency of each character in the pattern
        int[] count = new int[256];

        // Stores number of distinct characters in pattern
        int distinct = 0;

        boolean found = false;

        // Count the frequency of each character in the pattern
        for (char c : pattern.toCharArray()) {
            count[c]++;
            if (count[c] == 1)
                distinct++;
        }

        // Stores the number of characters in a substring of size
        // mid in str whose frequency is the same as the frequency in
        // pattern
        int currCount = 0;
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]--;
            if (count[str.charAt(i)] == 0) {
                currCount++;
            }
            if (i >= mid) {
                count[str.charAt(i - mid)]++;
                if (count[str.charAt(i - mid)] == 1) {
                    currCount--;
                }
            }
            if (i >= mid - 1) {

                // Substring of length mid found which contains
                // all the characters of the pattern
                if (currCount == distinct) {

                    found = true;

                    // Stores the starting index of that substring
                    start[0] = (i - mid) + 1;
                    break;
                }
            }
        }

        return found;
    }

    // Function to find the smallest substring containing all
    // characters of the pattern
    static String findSmallestSubstring(String str, String pattern) {
        int lenStr = str.length();
        int lenPattern = pattern.length();
        String smallestSubstring = "";

        int minLength = Integer.MAX_VALUE;

        // Lower bound and Upper Bound for Binary Search
        int lowBound = 1, highBound = lenStr;

        // Stores starting index of min length substring
        int[] idx = new int[1];

        // Applying Binary Search on answer
        while (lowBound <= highBound) {
            int mid = (lowBound + highBound) / 2;
            int[] start = new int[1];

            // If a substring of length mid is found which
            // contains all the characters of the pattern then
            // update minLength and highBound, otherwise update
            // lowBound
            if (isValid(str, pattern, mid, start)) {
                if (mid < minLength) {
                    minLength = mid;
                    idx[0] = start[0];
                }
                highBound = mid - 1;
            } else {
                lowBound = mid + 1;
            }
        }

        return smallestSubstring = str.substring(idx[0], idx[0] + minLength);
    }

    public static void main(String[] args) {
        String str1 = "this is a test string";
        String pattern1 = "tist";
        System.out.println("Input: string = \"" + str1
                + "\", pattern = \"" + pattern1 + "\"");
        System.out.println("Output: \""
                + findSmallestSubstring(str1, pattern1) + "\""
        );

        String str2 = "geeksforgeeks";
        String pattern2 = "ork";
        System.out.println("Input: string = \"" + str2
                + "\", pattern = \"" + pattern2 + "\"");
        System.out.println("Output: \""
                + findSmallestSubstring(str2, pattern2) + "\""
        );
    }
}

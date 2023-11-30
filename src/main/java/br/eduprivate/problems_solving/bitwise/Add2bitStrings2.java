package br.eduprivate.problems_solving.bitwise;

// see geeksforgeeks

class Add2bitStrings2 {

    // The main function that adds two-bit
    // sequences and returns the addition
    static String addBitStrings(StringBuilder str1,
                                StringBuilder str2)
    {
        StringBuilder ans = new StringBuilder();
        int i = str1.length() - 1;
        int j = str2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry>0) {
            if (i >= 0)
                carry += str1.charAt(i--) - '0';
            if (j >= 0)
                carry += str2.charAt(j--) - '0';
            ans.append(carry % 2);
            carry = carry/2;
        }
        return ans.reverse().toString();
    }

    // Driver Code
    public static void main(String[] args)
    {
        String str1 = "1100011";
        String str2 = "10";
        System.out.println("Sum is "+ addBitStrings(new StringBuilder(str1),
                new StringBuilder(str2)));
    }
}
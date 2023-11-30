package br.eduprivate.problems_solving.bitwise;

// see geeksforgeeks

class Add2bitStrings
{

    // Helper method: given two unequal sized bit strings,
    // converts them to same length by adding leading 0s
    // in the smaller string. Returns the new length
    // Using StringBuilder as Java only uses call by value
    static int makeEqualLength(StringBuilder str1,
                               StringBuilder str2)
    {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 < len2)
        {
            for (int i = 0; i < len2 - len1; i++)
                str1.insert(0, '0');
            return len2;
        }
        else if (len1 > len2)
        {
            for (int i = 0; i < len1 - len2; i++)
                str2.insert(0, '0');
        }

        return len1; // If len1 >= len2
    }

    // The main function that adds two-bit sequences
    // and returns the addition
    static String addBitStrings(StringBuilder str1,
                                StringBuilder str2)
    {
        String result = ""; // To store the sum bits

        // make the lengths same before adding
        int length = makeEqualLength(str1, str2);

        // Convert StringBuilder to Strings
        String first = str1.toString();
        String second = str2.toString();

        int carry = 0; // Initialize carry

        // Add all bits one by one
        for (int i = length - 1; i >= 0; i--)
        {
            int firstBit = first.charAt(i) - '0';
            int secondBit = second.charAt(i) - '0';

            // boolean expression for sum of 3 bits
            int sum = (firstBit ^ secondBit ^ carry) + '0';

            result = String.valueOf((char) sum) + result;

            // boolean expression for 3-bit addition
            carry = (firstBit & secondBit) |
                    (secondBit & carry) |
                    (firstBit & carry);
        }

        // if overflow, then add a leading 1
        if (carry == 1)
            result = "1" + result;
        return result;
    }

    // Driver Code
    public static void main(String[] args)
    {
        String str1 = "1100011";
        String str2 = "10";
        System.out.println("Sum is " +
                addBitStrings(new StringBuilder(str1),
                        new StringBuilder(str2)));
    }
}

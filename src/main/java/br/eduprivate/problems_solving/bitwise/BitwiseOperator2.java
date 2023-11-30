package br.eduprivate.problems_solving.bitwise;

// see geeksforgeeks

class BitwiseOperator2 {
    public static void main (String[] args) {

        String binary[]={
                "0000","0001","0010","0011","0100","0101",
                "0110","0111","1000","1001","1010",
                "1011","1100","1101","1110","1111"
        };

        // initializing the values of a and b
        int a=3; // 0+2+1 or 0011 in binary
        int b=6; // 4+2+0 or 0110 in binary

        // bitwise or
        int c= a | b;

        // bitwise and
        int d= a & b;

        // bitwise xor
        int e= a ^ b;

        // bitwise not
        int f= (~a & b)|(a &~b);
        int g= ~a & 0x0f;


        System.out.println(" a= "+binary[a]);
        System.out.println(" b= "+binary[b]);
        System.out.println(" a|b= "+binary);
        System.out.println(" a&b= "+binary[d]);
        System.out.println(" a^b= "+binary[e]);
        System.out.println("~a & b|a&~b= "+binary[f]);
        System.out.println("~a= "+binary[g]);
    }
}
package br.eduprivate.problems_solving;

public class RomanToInt {

    char[] roman = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    int[] num = new int[]{1, 5, 10, 50, 100, 500, 1000};

    public int findIndex(char romanChar) {
        for (int i = 0; i < roman.length; i++) {
            if(romanChar == roman[i]){
                return i;
            }
        }
        return 0;
    }

    private int depreciate(String s, char actual, int i) {
        if( i + 1 < s.length()){
            char last = s.charAt(i+1);
            int indexLast = findIndex(last);
            int indexActual = findIndex(actual);
            if(indexActual < indexLast) {
                return num[indexActual];
            }
        }
        return 0;
    }
    public int romanToInt(String s) {
        int result = 0;

        for (int i = s.length()-1; i >= 0; i--) {
            char actual = s.charAt(i);
            int dep = depreciate(s, actual, i);

            if (dep > 0) {
                result -= dep;
                dep = 0;
                continue;
            }

            for (int j = 0; j < roman.length; j++) {
                if (roman[j] == actual) {
                    result += num[j];
                    break;
                }
            }
        }

        return result;
    }



    public static void main(String[] args)
    {
        RomanToInt romanToInt = new RomanToInt();
        String roman = new String("MCMXCIV"); //1994
        System.out.println(romanToInt.romanToInt(roman));
    }
}

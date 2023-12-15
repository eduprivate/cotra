package br.eduprivate.problems_solving;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int count = 0;
        int countWord = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && countWord == 0) {
                continue;
            } else if (s.charAt(i) == ' ' && countWord > 0) {
                break;
            } else {
                count++;
                countWord++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        System.out.println(lengthOfLastWord.lengthOfLastWord("Hello World"));
    }
}

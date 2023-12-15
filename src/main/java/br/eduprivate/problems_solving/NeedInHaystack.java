package br.eduprivate.problems_solving;

public class NeedInHaystack {

    public int naiveStrStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int strStr(String haystack, String needle) {

        char[] haystackArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();

        if (needleArr.length > haystackArr.length)
            return -1;

        for (int i = 0; i <= haystackArr.length - needleArr.length; i++) {
            int j = 0;
            while(j<needleArr.length && haystackArr[i+j]==needleArr[j]) {
                j++;
            }
            if (j == needleArr.length){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "a", needle = "a";
        NeedInHaystack needInHaystack = new NeedInHaystack();
        System.out.println(needInHaystack.strStr(haystack, needle));
    }
}

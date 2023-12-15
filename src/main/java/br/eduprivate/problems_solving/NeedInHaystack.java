package br.eduprivate.problems_solving;

public class NeedInHaystack {

    public int naiveStrStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";
        NeedInHaystack needInHaystack = new NeedInHaystack();
        System.out.println(needInHaystack.strStr(haystack, needle));
    }
}

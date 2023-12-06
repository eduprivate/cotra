package br.eduprivate.problems_solving.knapsack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyNaiveKnapsack {

    public static void main(String args[])
    {
        int profits[] = new int[] { 60, 100, 120 };
        int weights[] = new int[] { 10, 20, 30 };
        int W = 50;
        System.out.println(knapSack(W, weights, profits));
    }

    private static boolean knapSack(int w, int[] weights, int[] profits) {

        List<Integer> max = new ArrayList<>();

        for (int i = 0; i < weights.length; i++) {
            int weight = weights[i];



        }
        return true;
    }
}

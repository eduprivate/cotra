package br.eduprivate.dswalgol.array;

import java.util.Arrays;
import java.util.Random;

public class ArrayTest {
    public static void main(String[] args) {
        int num[] = new int[10];
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());

        for (int i = 0; i < num.length; i++) {
            num[i] = rand.nextInt(100);
        }
        int[] old = (int[]) num.clone();
        System.out.println("arrays equals before sort: " + Arrays.equals(old, num));
        Arrays.sort(num);
        System.out.println("arrays equals after sort: " + Arrays.equals(old, num));
        System.out.println("old = "+Arrays.toString(old));
        System.out.println("num = "+Arrays.toString(num));
    }
}

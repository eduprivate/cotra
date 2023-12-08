package br.eduprivate.problems_solving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {

    static int removeDuplicates2(int arr[])
    {
        int n = arr.length;

        if (n == 0 || n == 1)
            return n;

        int[] temp = new int[n];

        int j = 0;
        for (int i = 0; i < n - 1; i++)
            if (arr[i] != arr[i + 1])
                temp[j++] = arr[i];


        temp[j++] = arr[n - 1];

        for (int i = 0; i < j; i++)
            arr[i] = temp[i];


        return j-1;
    }

    static int removeDuplicates(int arr[], int n)
    {
        if (n == 0 || n == 1)
            return n;

        int[] temp = new int[n];

        int j = 0;
        for (int i = 0; i < n - 1; i++)
            if (arr[i] != arr[i + 1])
                temp[j++] = arr[i];


        temp[j++] = arr[n - 1];

        for (int i = 0; i < j; i++)
            arr[i] = temp[i];


        return j-1;
    }
    public int removeDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int size = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int actual = nums[i];
            if(result.contains(actual)) {
                continue;
            } else {
                result.add(actual);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < result.size()) {
                nums[i] = result.get(i);
            } else {
                nums[i] = -1000;
            }

        }

        return result.size();
    }

    public static void main(String[] args)
    {
        int[] s = new int[]{0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.removeDuplicates(s));
        System.out.println(removeDuplicates.removeDuplicates(s, s.length));
    }
}

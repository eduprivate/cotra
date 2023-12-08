package br.eduprivate.problems_solving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {

        int size = nums.length;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]) {
                nums[i+1] = -1000;
                size--;
            }
        }

        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == -1000) {
                int temp = nums[i+1];
                nums[i] = temp;
                nums[i+1] = -1000;
            }
        }

        return size;
    }

    public static void main(String[] args)
    {
        int[] s = new int[]{1,1,2};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.removeDuplicates(s));
    }
}

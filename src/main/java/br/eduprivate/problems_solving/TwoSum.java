package br.eduprivate.problems_solving;

import br.eduprivate.dswalgol.vector.List;

import java.util.Arrays;

class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] results = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int result = nums[i] + nums[j];
                if (result == target) {
                    results[0] = i;
                    results[1] = j;
                    return results;
                }
            }
        }
        return results;
    }

    public static void main(String[] args)
    {
        int[] values = new int[]{3,2,4};
        int target = 6;

        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(values, target)));
    }
}
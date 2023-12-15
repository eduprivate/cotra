package br.eduprivate.problems_solving;

import java.util.Arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[count]=nums[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int val = 2;
        int[] nums = {0,1,2,2,3,0,4,2};

        System.out.println(removeElement.removeElement(nums, val));
    }
}

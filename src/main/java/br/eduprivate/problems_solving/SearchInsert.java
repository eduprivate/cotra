package br.eduprivate.problems_solving;

public class SearchInsert {

    public int searchInsert(int[] nums, int target) {

        int low = 0;
        int hight = nums.length-1;

        while(low <= hight) {
            int mid = low + (hight-low)/2;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] > target){
                hight = mid-1;
            } else {
                low = mid+1;
            }

        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3};
        int target = 2;
        SearchInsert searchInsert = new SearchInsert();
        System.out.println(searchInsert.searchInsert(nums, target));
    }
}

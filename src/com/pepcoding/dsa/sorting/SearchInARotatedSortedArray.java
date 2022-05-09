package com.pepcoding.dsa.sorting;

public class SearchInARotatedSortedArray {

    public static int search(int[] nums, int target) {
/*        the array is possibly rotated so,first we have to find the pivot ,and after we find it we have to
            search on the left or right side of it depending on the target we are looking for*/

        int lo = 0;
        int hi = nums.length - 1;
        int pivotIndex = findPivotIndex(nums);
        //case when array is not rotated at all ,i.e. pivotIndex is zero
        if (pivotIndex == 0) {
            //array not rotated at all,hence we would just do a binary search
            return binarySearch(nums, lo, hi, target);
        } else //case when sorted array is rotated
        {
            //if element at pivot is the target
            if (nums[pivotIndex] == target) {
                return pivotIndex;
            } else if (nums[lo] <= target) {
                //target lies in left half of pivot
                return binarySearch(nums, lo, pivotIndex - 1, target);
            } else {
                //target lies in right half of pivot
                return binarySearch(nums, pivotIndex + 1, hi, target);
            }
        }
    }

    private static int binarySearch(int[] input, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (input[mid] == target) {
                return mid;
            } else if (input[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;//if element not found
    }

    private static int findPivotIndex(int[] input) {
        int lo = 0;
        int hi = input.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (input[mid] < input[hi]) {
                hi = mid;//pivot should lie
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {

        //int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int[] nums = {1, 3};
        System.out.println(findPivotIndex(nums));
        System.out.println(search(nums, 3));

    }
}

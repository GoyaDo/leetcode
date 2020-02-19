package com.elevengeek.goya.easy;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cj
 * @create 2020-02-19-22:31
 */
public class Solution {

    public static int[] MyTwoSum(int[] nums, int target) {
        for (int j = 0; j < nums.length; j++) {
            for (int i = j + 1; i < nums.length; i++) {
                if ((nums[j] + nums[i]) == target) {
                    int arr[] = new int[2];
                    arr[0] = j;
                    arr[1] = i;
                    return arr;
                }
            }
        }
        return null;
    }


    @Test
    public void test() {
//        int arr[] = {2,7,11,15};
//        int arr[] = {3,2,4};
        int arr[] = {3, 2, 2, 4};
        int[] ints = MyTwoSum(arr, 6);
        System.out.println(Arrays.toString(ints));
    }


    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

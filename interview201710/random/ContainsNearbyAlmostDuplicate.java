/*
Given an array of integers, find out whether there are two distinct indices i and j
in the array such that the absolute difference between nums[i] and nums[j] is at most t
and the absolute difference between i and j is at most k.
 */

import java.util.*;
import java.lang.Math;

class ContainsNearbyAlmostDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[] { -1,2147483647 };
        int k = 1;
        int t = 2147483647;

        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
        System.out.println(containsNearbyAlmostDuplicate2(nums, k, t));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0) return false;

        TreeSet<Long> tree = new TreeSet<>();

        for(int i = 0; i < nums.length; i++) {
            Long upperBound = tree.floor((long) nums[i] + t);
            Long lowerBound = tree.ceiling((long) nums[i] - t);
            if((lowerBound != null && lowerBound <= nums[i]) ||
               (upperBound != null && upperBound >= nums[i])) return true;

            tree.add((long) nums[i]);
            if(i >= k) tree.remove((long) nums[i-k]);
        }

        return false;
    }

    public static boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0 || t < 0) return false;

        HashMap<Long, Long> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            long curr = (long) nums[i];
            long bucketId = getBucketId(curr, t);

            if(map.containsKey(bucketId)) return true;
            if(map.containsKey(bucketId-1) && Math.abs(curr - map.get(bucketId-1)) <= t) return true;
            if(map.containsKey(bucketId+1) && Math.abs(map.get(bucketId+1) - curr) <= t) return true;

            map.put(bucketId, curr);
            if(i >= k) map.remove(getBucketId((long) nums[i-k], t));
        }

        return false;
    }

    public long getBucketId(long value, int bucketSize) {
        if(bucketSize == 0) return value;
        return value < 0 ? value/bucketSize-1 : value/bucketSize;
    }
}

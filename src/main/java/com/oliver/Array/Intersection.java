package com.oliver.Array;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.oliver.Array.ArrayUtils.intArray2List;

/**
 * Created by Yanliang Han on 2016/7/13.
 */
public class Intersection {
    private final static Logger logger = LoggerFactory.getLogger(Intersection.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        testIntersection();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    private static void testIntersection() {
        int[] result1 = intersection(new int[]{5, 1, 2, 3, 4}, new int[]{3, 2, 2, 4, 5, 6});
        logger.info("result1 = {}", result1);

        int[] result2 = intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        logger.info("result2 = {}", result2);
    }

    public static int[] convert2IntArray(List<Integer> list) {
        if (list == null || list.size() < 1) {
            return new int[0];
        }

        int len = list.size();
        int[] ret = new int[len];
        int i = 0;
        for (Integer integer : list) {
            ret[i++] = integer;
        }

        return ret;
    }

    public static int[] convert2IntArray(Set<Integer> set1) {
        if (set1 == null || set1.size() < 1) {
            return new int[0];
        }

        int len = set1.size();
        int[] ret = new int[len];
        int i = 0;
        for (Integer integer : set1) {
            ret[i++] = integer;
        }

        return ret;
    }

    public static void removeDuplicates(List<Integer> list) {
        if (list == null || list.size() < 1) {
            return;
        }
//        logger.info("list = {}", list);

        int len = list.size();
        int lastVal = list.get(0);
        for (int k = 1; k < len; ) {
            if (list.get(k) != lastVal) {
                lastVal = list.get(k++);
            } else {
                list.remove(k);
                len--;
            }
        }

//        logger.info("newlist = {}, newLen = {}", list, list.size());
        return;
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length < 1) {
            return nums1;
        } else if (nums2 == null || nums2.length < 1) {
            return nums2;
        }

        List<Integer> list1 = intArray2List(nums1);
        List<Integer> list2 = intArray2List(nums2);

        Collections.sort(list1);
        Collections.sort(list2);
        removeDuplicates(list1);
        removeDuplicates(list2);
        list1.retainAll(list2);

        return convert2IntArray(list1);
    }

    public static int[] removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) {
            return nums;
        }
//        logger.info("nums = {}", nums);

        int len = nums.length;
        int lastVal = nums[0];
        int newLen = 1;
        for (int k = 1; k < len; k++) {
            if (nums[k] != lastVal) {
                lastVal = nums[k];
                nums[newLen++] = nums[k];
            }
        }

        int[] result = new int[newLen];
        for (int i = 0; i < newLen; i++) {
            result[i] = nums[i];
        }

//        logger.info("result = {}, newLen = {}", result, newLen);
        return result;
    }

    public static int[] intersectTwoSortedArray(int[] A, int[] B) {
        if (A == null) {
            return B;
        } else if (B == null) {
            return A;
        }

        List<Integer> retList = new LinkedList<Integer>();

        for (int target : A) {
            if (sortedArrayContains(B, target)) {
                retList.add(target);
            }
        }

        int[] resultArray = new int[retList.size()];
        int i = 0;
        for (Integer integer : retList) {
            resultArray[i++] = integer;
        }

        return resultArray;
    }

    public static boolean sortedArrayContains(int[] B, int target) {
        if (B == null || B.length < 1) {
            return false;
        }

        int start = 0, end = B.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (B[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (B[start] == target) {
            return true;
        } else if (B[end] == target) {
            return true;
        }

        return false;
    }

    public static int[] intersection2(int[] nums1, int[] nums2) {
        List<Integer> integerList1 = intArray2List(nums1);
        List<Integer> integerList2 = intArray2List(nums2);

        Set<Integer> set1 = new HashSet<Integer>(integerList1);
        Set<Integer> set2 = new HashSet<Integer>(integerList2);

        List<Integer> retList = new LinkedList<Integer>();
        for (int i : set2) {
            if (set1.contains(i)) {
                retList.add(i);
            }
        }

        return convert2IntArray(retList);
    }

    public static int[] intersection1(int[] nums1, int[] nums2) {
        List<Integer> integerList1 = intArray2List(nums1);
        List<Integer> integerList2 = intArray2List(nums2);

        Set<Integer> set1 = new HashSet<Integer>(integerList1);
        Set<Integer> set2 = new HashSet<Integer>(integerList2);

        set1.retainAll(set2);
        int[] ret = new int[set1.size()];
        int i = 0;
        for (Integer integer : set1) {
            ret[i++] = integer;
        }
        convert2IntArray(set1);

        return ret;
    }
}

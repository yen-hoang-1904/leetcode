package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 Runtime: 90 ms, faster than 5.02% of Java online submissions for Median of Two Sorted Arrays.
 Memory Usage: 48.1 MB, less than 43.06% of Java online submissions for Median of Two Sorted Arrays.
 */
/**/
public class MedianTwoSortedArrays2 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if (len1 >= len2) {
            List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
            for (int num:nums2) {
                putInTheRightOrder(list1, num, 0, list1.size() - 1);
            }

            for (int i = 0; i < list1.size(); i++) {
                System.out.println(list1.get(i));
            }
            double medium = 0;

            if (list1.size() % 2 != 0) {
                medium = list1.get(list1.size()/2);
            } else {
                medium = ((double)list1.get(list1.size()/2 - 1) + (double)list1.get(list1.size()/2))/2;
            }

            return medium;

        } else {
            List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
            for (int num:nums1) {
                putInTheRightOrder(list2, num, 0, list2.size() - 1);
            }
            for (Integer nu: list2) {
                System.out.println(nu);
            }
            double medium = 0;

            if (list2.size() % 2 != 0) {
                medium = list2.get(list2.size()/2);
            } else {
                medium = ((double)list2.get(list2.size()/2 - 1) + (double)list2.get(list2.size()/2))/2;
            }

            return medium;
        }
    }

    public static void putInTheRightOrder(List<Integer> list, int num, int lo, int hi) {
        if (num <= list.get(lo).intValue()){
            list.add(lo, num);
            return;
        }

        if (num >= list.get(hi).intValue()) {
            list.add(hi + 1, num);
            return;
        }

        if (lo + 1 >= hi) {
            list.add(lo + 1, num);
            return;
        } else {
            int mid = (hi - lo)/2 + lo;
            int numMid = list.get(mid).intValue();
            if (num > numMid) {
                lo = mid + 1;
                putInTheRightOrder(list, num, lo , hi);
            } else if (num < numMid) {
                hi = mid - 1;
                putInTheRightOrder(list, num, lo , hi);
            } else {
                list.add(mid, numMid);
                return;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        MedianTwoSortedArrays2.findMedianSortedArrays(nums1, nums2);
    }
}

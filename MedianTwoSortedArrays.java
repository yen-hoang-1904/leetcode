package leetcode;

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
 * Runtime: 15 ms, faster than 8.00% of Java online submissions for Median of Two Sorted Arrays.
 * Memory Usage: 41.9 MB, less than 98.61% of Java online submissions for Median of Two Sorted Arrays.
 */
/**/
public class MedianTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len3 = len1 + len2;
        int[] nums3 = new int[len3];
        int curr1 = 0;
        int curr2 = 0;

        for (int i = 0; i < len3 ; i++) {
            if (curr1 >= len1 && curr2 < len2) {
                nums3[i] = nums2[curr2];
                curr2++;
                continue;
            }

            if (curr1 < len1 && curr2 >= len2) {
                nums3[i] = nums1[curr1];
                curr1++;
                continue;
            }

            if (nums1[curr1] < nums2[curr2]) {
                nums3[i] = nums1[curr1];
                curr1++;
            } else if (nums1[curr1] >= nums2[curr2]) {
                nums3[i] = nums2[curr2];
                curr2++;
            }
        }


        for (int i = 0; i < len3 ; i++) {
            System.out.println("");
            System.out.print(nums3[i] + " ");
            System.out.println("");
        }

        double medium = 0;

        if (len3 % 2 != 0) {
            medium = nums3[len3/2];
        } else {
            System.out.println("=================");
            System.out.println(nums3[len3/2 - 1]);
            System.out.println(nums3[len3/2]);
            System.out.println("=================");
            medium = ((double)nums3[len3/2 - 1] + (double)nums3[len3/2])/2;
        }

        System.out.println("Medium - " + medium);

        return medium;

    }

    public static void main(String[] args) {
        int[] nums1 = {3,4,6,7,8,9,10};
        int[] nums2 = {1,2,3,8,9};
        MedianTwoSortedArrays.findMedianSortedArrays(nums1, nums2);
    }
}

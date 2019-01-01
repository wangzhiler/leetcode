package leetcodeJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;



class Solution{

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //取更小的数组进行二分操作
//        if (nums1.length > nums2.length) {
//            return findMedianSortedArrays(nums2, nums1);
//        }
//        System.out.println(nums1 + "----" + nums2);
//        int len = nums1.length + nums2.length;
//
//        int cut1 = 0, cut2 = 0, cutL = 0;
//        int cutR = nums1.length - 1;
//
//        while (cut1 <= nums1.length) {
//            System.out.println("len:" + len);
//            System.out.println("cutR:"+cutR+"cutL:"+cutL);
//            cut1 = (cutR - cutL) / 2 + cutL;
//            cut2 = len / 2 - cut1;
//            System.out.println("cut1: " + cut1 + "cut2: " + cut2);
//            double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
//            double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
//            double R1 = (cut1 == 0) ? Integer.MAX_VALUE : nums1[cut1];
//            double R2 = (cut2 == 0) ? Integer.MAX_VALUE : nums2[cut2];
//
//            if (L1 > R2) {
//                cutR = cut1 - 1;
//            } else if (L2 > R1) {
//                cutL = cut1 + 1;
//            } else {
//                //处理奇偶问题
//                if (len % 2 == 0) {
//                    //取L1L2中的最大值,R1R2中的最小值
//                    L1 = L1 > L2 ? L1 : L2;
//                    R1 = R1 < R2 ? R1 : R2;
//                    System.out.println("L1:" + L1 + "L2:" + L2);
//                    return (L1 + R1) / 2;
//                } else {
//                    R1 = (R1 < R2) ? R1 : R2;
//                    return R1;
//                }
//            }
//
//        }
//        return -1;

        int m = nums1.length, n = nums2.length;
        //取更小的数组进行二分操作
        if (m < n)
            return findMedianSortedArrays(nums2, nums1);
        if (n == 0)
            return (nums1[(m - 1) / 2] + nums1[m / 2]) / 2.0;
        int left = 0, right = 2 * n;
        while (left <= right) {
            int mid2 = (left + right) / 2;
            int mid1 = m + n - mid2;
            double L1 = mid1 == 0 ? Double.MIN_VALUE : nums1[(mid1 - 1) / 2];
            double L2 = mid2 == 0 ? Double.MIN_VALUE : nums2[(mid2 - 1) / 2];
            double R1 = mid1 == m * 2 ? Double.MAX_VALUE : nums1[mid1 / 2];
            double R2 = mid2 == n * 2 ? Double.MAX_VALUE : nums2[mid2 / 2];

            //处理奇偶问题
            if (L1 > R2)
                left = mid2 + 1;
            else if (L2 > R1)
                right = mid2 - 1;
            else
                return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
        }
        return -1;
    }

}

public class Medianof2SortedArrays {

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String doubleToString(double input) {
        return new DecimalFormat("0.00000").format(input);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums1 = stringToIntegerArray(line);
            line = in.readLine();
            int[] nums2 = stringToIntegerArray(line);

            double ret = new Solution().findMedianSortedArrays(nums1, nums2);

            String out = doubleToString(ret);

            System.out.print(out);
        }
    }

}
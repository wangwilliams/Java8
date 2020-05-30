package com.wangyunpeng.chapter1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyunpeng
 * @date 2020/5/29
 */
public class JavaSolution {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 1};
        int[] B = {2, 7, 9, 3, 1};
        int[] C = {1,2,3,1,2,9,8};
        System.out.println(rob(A));
        System.out.println(rob(B));
        System.out.println(rob(C));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        } else if (nums.length == 3) {
            return nums[0] + nums[2] > nums[1] ? nums[0] + nums[2] : nums[1];
        }
        int size = 0;
        size = (int) nums.length / 3;
        int A = nums[0];
        int B = nums[1];
        int C = nums[0] + nums[2];
        for (int i = 1; i < size; i++) {
            if (B > A) {
                A = B + nums[i * 3];
            } else {
                A = A + nums[i * 3];
            }

            if (C > B) {
                B = C + nums[i * 3 + 1];
            } else {
                B = B + nums[i * 3 + 1];
            }

            if (A > C) {
                C = A + nums[i * 3 + 2];
            } else {
                C = C + nums[i * 3 + 2];
            }
        }
        if (nums.length % 3 == 0){
            return B > C ? B : C;
        }
        if (nums.length % 3 == 1) {
            if (B > A) {
                A = B + nums[nums.length - 1];
            } else {
                A = A + nums[nums.length - 1];
            }
            return A > C ? A : C;
        }

        if (B > A) {
            A = B + nums[nums.length - 2];
        } else {
            A = A + nums[nums.length - 2];
        }
        if (C > B) {
            B = C + nums[nums.length - 1];
        } else {
            B = B + nums[nums.length - 1];
        }
        return A > B ? A : B;
    }
}

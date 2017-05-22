package com.peter.leetcode;

import java.util.Arrays;

/**
 * Created by peter on 2017/5/22.
 */
public class LeetCode279 {
    public static void main(String ss[]) {
        System.out.print(numSquares( 17));
    }

    public static int numSquares(int n) {
        int[] nums = new int[n + 1];
        Arrays.fill(nums, Integer.MAX_VALUE);
        nums[0] = 0;
        // 将所有整平方数的结果置1
        for (int i = 0; i*i <= n; ++i)
        {
            nums[i*i] = 1;
        }//for
        // 从小到大找任意数a
        for (int a = 0; a <= n; ++a)
        {
            // 从小到大找平方数b*b
            for (int b = 0; a + b*b <= n; ++b)
            {
                // 因为a+b*b可能本身就是平方数，所以我们要取两个中较小的
                nums[a + b*b] = Math.min(nums[a] + 1, nums[a + b*b]);
            }//for
        }//for

        for(int j:nums){
            //System.out.println(j);
        }
        return nums[n];
    }








    public static int numSquares_best(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while(i - j*j >= 0) {
                min = Math.min(min, dp[i - j*j] + 1);
                j++;
            }
            dp[i] = min;
        }
        for(int j:dp){
            //System.out.println(j);
        }
        return dp[n];
    }
}

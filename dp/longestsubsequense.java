package dp;
import java.util.*;
public class longestsubsequense {
    public static int longestsequencecount(int[] nums){
        int[] dp = new int[nums.length];
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int max = 1;
        for(int i=0;i<n;i++){
            dp[i] = 1;
            for(int j = 0; j<i;j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
               
            }
             max = Math.max(max,dp[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        //Longest Increasing Subsequence
        //Given an integer array nums, return the length of the longest strictly increasing subsequence.

 

        // Example 1:

        // Input: nums = [10,9,2,5,3,7,101,18]
        // Output: 4
        // Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
        int nums[] = {10,9,2,5,3,7,101,18};
        System.out.println(longestsequencecount(nums));

    }
}

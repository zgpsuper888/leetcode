package com.peter.leetcode;

/**
 * Created by peter on 2017/5/17.
 */
public class LeetCode275 {
    public static void main(String ss[]) {
        int[] citations={1,1,3,5,6};
        System.out.print(hIndex( citations));
    }
    public static int hIndex(int[] citations) {
        int hindex=0;
        int temp=0;
        for(int i=0;i<citations.length;i++){
            temp=Math.min(i+1,citations[citations.length-1-i]);
            hindex = Math.max(hindex, temp);
        }
        return hindex;
    }

        public int hIndex_best(int[] citations) {
        int low = 0;
        int high = citations.length-1;
        int n = citations.length;
        int max = 0;
        while(low<=high){
            //low +1
            int mid = low+(high-low)/2;
            if(citations[mid]>= (n-mid)){
                high = mid-1;
                max = Math.max(max,n-mid);
            }else{
                low = mid+1;
            }

        }
        return max;
    }
}

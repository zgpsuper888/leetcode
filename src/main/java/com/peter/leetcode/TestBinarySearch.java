package com.peter.leetcode;

/**
 * Created by peter on 2017/5/19.
 */
public class TestBinarySearch {
    public static void main(String ss[]) {
        int array[]={1,2,3,4,5,6,7,8,9,10};
        System.out.println(BinarySearch(array,2));
    }


    public static int BinarySearch(int array[], int value){
        int left=0;
        int right=array.length-1;
        int n=0;
        while (left<=right){
            int mid=left+((right-left)>>1);
            System.out.println("left="+left+"||mid="+mid+"||right="+right);

            if (array[mid]<value){
                left=mid+1;
            }else if(array[mid]>value){
                right=mid-1;
            }else{
                return mid;
            }

        }
        return -1;
    }

}

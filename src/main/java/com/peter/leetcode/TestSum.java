package com.peter.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peter on 2017/5/14.
 */
public class TestSum {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>res=new ArrayList<List<Integer>>();
        ArrayList<Integer> list = null;
        Integer[] intarr= {1,2,3,4,5,6,7,8,9};
        int all = intarr.length;
        int nbit = 1 << all;
        int tempsum=0;
        int count=0;
        for (int i = 0; i < nbit; i++) {
            list = new ArrayList<Integer>();
            tempsum=0;
            count=0;
            for (int j = 0; j < all; j++) {
                if ((i & (1 << j)) != 0) {
                    count++;
                    tempsum+=intarr[j];
                    list.add(intarr[j]);
                }
                if(tempsum>n||count>k){
                    break;
                }

            }
            if(tempsum==n&&count==k){
                res.add(list);
            }
        }
        return res;
    }
    public static void main(String ss[]){
        Integer[] str= {1,2,3,4,5,6,7,8,9};
//        List<List<Integer>>res=combinationSum3(3,9);
        List<List<Integer>>res=combinationSum3_best(3,9);
        for (List<Integer> unit:res) {
            for (Integer inunit:unit) {
            System.out.print(inunit+"+");
            }
            System.out.println();

        }
        }
        //下面是牛逼的代码
    public static List<List<Integer>> combinationSum3_best(int k, int n) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combination(result, new ArrayList<Integer>(), k, 1, n);
        return result;
    }

    private static void combination(List<List<Integer>> result, List<Integer> comb, int k,  int start, int n) {
        if (comb.size() == k && n == 0) {
            result.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            combination(result, comb, k, i+1, n-i);
            comb.remove(comb.size() - 1);
        }
    }

}


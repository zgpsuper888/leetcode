package com.peter.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peter on 2017/5/17.
 * [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
public class LeetCode118 {
public static void main(String dd[]){
    List<List<Integer>>res= generate(5);
    for (List<Integer> unit:res) {
        for (Integer inunit:unit) {
            System.out.print(inunit+"+");
        }
        System.out.println();

    }
}
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>>res=new ArrayList<List<Integer>>();
        List<Integer>temp=null;
        List<Integer>temp2=null;
        temp=new ArrayList<Integer>();
        temp2=new ArrayList<Integer>();
        temp.add(1);
        res.add(temp);
        if(numRows==1){
            return res;
        }
        temp=new ArrayList<Integer>();
        temp.add(1);
        temp.add(1);
        res.add(temp);
        if(numRows==2){
            return res;
        }
        for (int i=3;i<=numRows;i++){
            for(int j=0;j<i;j++){
                if(j==0){
                    temp2.add(1);
                }else if(j>(i/2)){
                    temp2.add(temp2.get(i-j-1));

                }else{
                        temp2.add(temp.get(j-1)+temp.get(j));
                }
            }
            res.add(temp2);
            temp=temp2;
            temp2=new ArrayList<Integer>();

        }
        return res;
    }
    public static List<List<Integer>> generate_best(int numRows) {
        int[][] pascal=new int[numRows][];
        for(int i=0;i<numRows;i++){
            pascal[i]=new int[i+1];
            if(i==0){
                pascal[i][0]=1;
            }else{
                for(int j=0;j<i+1;j++){
                    if(j==0||j==i){
                        pascal[i][j]=1;
                    }else{
                        pascal[i][j]=pascal[i-1][j-1]+pascal[i-1][j];
                    }
                }
            }

        }
        List list = java.util.Arrays.asList(pascal);
        return list;
    }
}


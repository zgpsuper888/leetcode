package com.peter.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by peter on 2017/5/19.
 */
public class LeetCode25 {
    public static void main(String ss[]) {
        int n=19;
        ListNode head=new ListNode(1) ;
        ListNode temp=head;
        ListNode temp2=head;

        for(int i=1;i<n;i++){
            head.next=new ListNode(i+1);
            head=head.next;
        }
        print( temp);
        System.out.println("ddddd");
       // List<ListNode>lst=reverseKGroup( temp2);

        //print( lst.get(lst.size()-1));

        print( reverseKGroup( temp2, 2));

    }
    public  static void print(ListNode head){
       // System.out.println("head==null"+(head==null));
        ListNode temp=head;
        System.out.println();

        while (temp!=null){
            System.out.print(temp.val+"__");
            temp=temp.next;
        }
    }
    /**
     * Definition for singly-linked list.
     *1>2>3>4>5>6git
     * }
     */
        public static ListNode reverseKGroup(ListNode head, int k) {
            ListNode res=head;
            ListNode unit_head=null;
            ListNode proc=head;
            ListNode temp=null;
            int j=1;
            while(proc!=null&&proc.next!=null){
                proc=proc.next;
                j++;
                if(j==k){
                    j=1;
                    temp=proc.next;
                    proc.next=null;
                    List<ListNode>lst=reverseKGroup( head);
                    lst.get(0).next=temp;
                    //print( lst.get(0));
                    if(null!=unit_head){
                        unit_head.next=lst.get(lst.size()-1);
                    }else{
                        res=lst.get(lst.size()-1);
                    }
                    unit_head=lst.get(0);
                    proc=temp;
                    head=temp;
                }
            }
            return res;
        }

        public static List<ListNode>  reverseKGroup(ListNode head){
            ListNode tempNode=head;
            if (head==null){
                return null;
            }
            List<ListNode>temp=new ArrayList<ListNode>();
            while (head!=null){
                    temp.add(head);
                    head=head.next;
            }
           for( int i=temp.size()-1;i>0;i--){
               temp.get(i).next=temp.get(i-1);
           }
           temp.get(0).next=null;
//            return temp.get(temp.size()-1);
           // print( temp.get(temp.size()-1));
            return temp;
        }
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup_best(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        return help(dummy,k);
    }
    public ListNode help(ListNode dummy, int k){
        ListNode start = dummy;
        while(start != null){
            start = reverse(start,k);
        }
        return dummy.next;
    }
    public ListNode reverse(ListNode head, int k){
        ListNode node = head.next;
        if(node == null){
            return node;
        }
        int a = k;
        while(a-- > 1){
            if(node.next == null){
                return null;
            }
            node = node.next;
        }
        node = head.next;
        while(k-- > 1){
            ListNode next = node.next;
            node.next = next.next;
            next.next = head.next;
            head.next = next;
        }
        return node;
    }
}

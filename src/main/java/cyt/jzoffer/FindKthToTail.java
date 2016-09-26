package cyt.jzoffer;

import cyt.study.ds.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 链表中倒数第k个结点
 * @Function List: 输入一个链表，输出该链表中倒数第k个结点。
 * @author: ytchen
 * @Date: 2016/7/23
 */
public class FindKthToTail {
    /*
    public class ListNode {
     int val;
     ListNode next = null;

     ListNode(int val) {
         this.val = val;
     }
 }*/
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode tmp=head;
        int len=0;
        while (tmp!=null){
            len++;
            tmp=tmp.next;
        }

        if(k>len){
            return null;
        }else{
            tmp=head;
            for(int i=0;i<len-k;i++){
                tmp=tmp.next;
            }
            return tmp;
        }
    }
}

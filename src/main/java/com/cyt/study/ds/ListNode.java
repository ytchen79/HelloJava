package com.cyt.study.ds;

/**
 * @Description: TODO
 * @Function List: TODO
 * @author: ytchen
 * @Date: 2016/7/19
 */
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
    public  void print(ListNode root){
        while (root!=null){
            System.out.print(root.val+" ");
            root=root.next;
        }
        System.out.println();
    }
}

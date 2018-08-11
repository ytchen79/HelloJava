package com.cyt.jzoffer;

import com.cyt.study.ds.ListNode;

/**
 * @Description: 合并两个排序的链表
 * @Function List: 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @author: ytchen
 * @Date: 2016/7/23
 */
public class Merge {
    public static void main(String[] args){
        ListNode root=new ListNode(1);
        root.next=new ListNode(3);
        root.next.next=new ListNode(5);
        root.next.next.next=new ListNode(7);
        root.next.next.next.next=new ListNode(9);
        root.next.next.next.next.next=new ListNode(12);
        root.print(root);
        ListNode root1=new ListNode(2);
        root1.next=new ListNode(4);
        root1.next.next=new ListNode(6);
        root1.next.next.next=new ListNode(11);
        root1.next.next.next.next=new ListNode(16);
        root1.next.next.next.next.next=new ListNode(19);
        root1.print(root1);
        ListNode res=Merge(root,root1);
        res.print(res);
    }

    public static ListNode Merge(ListNode list1,ListNode list2) {

        if(list1 ==null){
            return list2;
        }else if(list2==null){
            return list1;
        }else{
            ListNode listNode=new ListNode(0);
            ListNode res_point=listNode;
            while (list1 !=null && list2 !=null){

                if(list1.val<list2.val){
                    res_point.next = new ListNode(list1.val);
                    res_point=res_point.next;
                    list1=list1.next;
                }else{
                    res_point.next = new ListNode(list2.val);
                    res_point=res_point.next;
                    list2=list2.next;
                }
            }
            while(list1 !=null){
                res_point.next = new ListNode(list1.val);
                res_point=res_point.next;
                list1=list1.next;
            }
            while (list2 !=null){
                res_point.next = new ListNode(list2.val);
                res_point=res_point.next;
                list2=list2.next;
            }
            return listNode.next;

        }

    }
}

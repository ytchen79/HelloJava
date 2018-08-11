package com.cyt.jzoffer;

import com.cyt.study.ds.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Description: 题目描述
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * 输入描述:输入为链表的表头
 * 输出描述: 输出为需要打印的“新链表”的表头
 * @Function List: TODO
 * @author: ytchen
 * @Date: 2016/7/19
 */
public class PrintListFromTailToHead {
    public static void main(String[] args){
        //{67,0,24,58}
        ListNode node0=new ListNode(67);
        ListNode node1=new ListNode(0);
        ListNode node2=new ListNode(24);
        ListNode node3=new ListNode(58);
        node0.next=node1;
        node1.next=node2;
        node2.next=node3;
        ListNode p=node0;

        while(p!=null){
            System.out.print(p.val+" ");
            p=p.next;
        }
        System.out.println();
        ArrayList<Integer> res=printListFromTailToHead(node0);
        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i)+" ");
        }

    }
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode p=listNode;
        ArrayList<Integer> tmp=new ArrayList<Integer>();
        ArrayList<Integer> res=new ArrayList<Integer>();
        while(p!=null){
            tmp.add(p.val);
            p=p.next;
        }
        for(int i=tmp.size();i>0;i--){
            res.add(tmp.get(i-1));
        }
        return res;
    }

    /*public class ListNode {
        int val;
        ListNode next = null;

         ListNode(int val) {
            this.val = val;
        }
    }*/

    /**
     * 简洁版
     * @param listNode
     * @return
     */
    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead0(ListNode listNode) {
        if(listNode!=null){
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
    /**
     * 栈
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        Stack<Integer> stack=new Stack<Integer>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }

        ArrayList<Integer> list=new ArrayList<Integer>();
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

    /**
     * 递归
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<Integer>();

        ListNode pNode=listNode;
        if(pNode!=null){
            if(pNode.next!=null){
                list=printListFromTailToHead(pNode.next);
            }
            list.add(pNode.val);
        }

        return list;
    }
}


package cyt.jzoffer;

import cyt.study.ds.ListNode;

/**
 * @Description: 反转链表
 * @Function List: 输入一个链表，反转链表后，输出链表的所有元素。
 * @author: ytchen
 * @Date: 2016/7/23
 */
public class ReverseList {
    public static void main(String[] args){
        ListNode root= new ListNode(1);
        ListNode p=root;
        p.next =new ListNode(2);

 /*
        ListNode root=new ListNode(1);
        ListNode p=root;
        root.next=new ListNode(2);
        root.next.next=new ListNode(3);
        root.next.next.next=new ListNode(4);
        root.next.next.next.next=new ListNode(5);
        root.next.next.next.next.next=new ListNode(6);*/
        print(root);
      //  print(ReverseList(root));
    }
    public static void print(ListNode root){
        while (root!=null){
            System.out.print(root.val+" ");
            root=root.next;
        }
    }
    public static ListNode ReverseList(ListNode head) {
        ListNode result=null;
        while (head!=null){
            ListNode tmp=new ListNode(head.val);

            if(result==null){
                result = new ListNode(head.val);
                result=tmp;
                head=head.next;
            }else{
                tmp.next=result;
                result=tmp;
                head=head.next;
            }

        }
        return result;
    }
}

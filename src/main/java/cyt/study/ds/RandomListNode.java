package cyt.study.ds;

/**
 * @Description: TODO
 * @Function List: TODO
 * @author: ytchen
 * @Date: 2016/8/28
 */
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }

    /**
     * 复杂链表的复制
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
     * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead==null) return null;

        RandomListNode p=pHead;
        while (p!=null){
            RandomListNode copy=new RandomListNode(p.label);
            copy.next=p.next;
            p.next=copy;
            p=copy.next;
        }

        p=pHead;
        while (p!=null){
            if(p.random!=null){
                p.next.random=p.random.next;
            }
            p=p.next.next;
        }
        p=pHead;
        RandomListNode copy=p.next;
        RandomListNode copy1=copy;
        while (p !=null){
            p.next=p.next.next;
            if(copy1.next!=null)
                copy1.next=copy1.next.next;

            p=p.next;
            copy1=copy1.next;
        }

        return copy;

    }
    public static void main(String[]args) {

    }
}

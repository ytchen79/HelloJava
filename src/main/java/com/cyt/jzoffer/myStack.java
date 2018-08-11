package com.cyt.jzoffer;
import java.util.Stack;

/**
 * @Description: TODO
 * @Function List: TODO
 * @author: ytchen
 * @Date: 2016/7/27
 */
public class myStack {

    public Stack<Integer> stack=new Stack<Integer>();


    public void push(int node) {
        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        int res=Integer.MAX_VALUE;
        Stack<Integer> tmp=new Stack<Integer>();
        while (!stack.empty()){
            if(top()<res){
                res=top();
            }
            tmp.push(top());
            pop();
        }
        while (!tmp.empty()){
            push(tmp.pop());
        }
        return res;
    }
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        boolean res=false;

        return res;
    }

    public static void main(String[] args){
        myStack test=new myStack();
        test.push(3);
        System.out.println(test.min());
        test.push(2);
        System.out.println(test.min());
        test.push(3);
        System.out.println(test.min());
        test.push(4);
        System.out.println(test.min());

    }
}

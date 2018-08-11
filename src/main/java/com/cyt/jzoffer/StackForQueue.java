package com.cyt.jzoffer;

import java.util.Stack;

/**
 * @Description: 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @Function List: TODO
 * @author: ytchen
 * @Date: 2016/7/20
 */
public class StackForQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack2.push(node);
    }

    public int pop() {
        if(stack1.empty()){
            while (!stack2.empty()){
                stack1.push(stack2.pop());
            }
        }
        return stack1.pop();
    }


}

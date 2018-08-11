package com.cyt.jzoffer;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Description: 栈的压入、弹出序列
 * @Function List: 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 * @author: ytchen
 * @Date: 2016/8/28
 */
public class IsPopOrder {
    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};
        int[] popA1 = {4, 3, 5, 1, 2};
        System.out.println(IsPopOrder1(pushA, popA));
        System.out.println(IsPopOrder1(pushA, popA1));
        int[] push1 = {1}, pop1 = {2};
        System.out.println(IsPopOrder1(push1, pop1));


    }


    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length < 1) return true;
        int i = 0, j = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        while (i < pushA.length) {
            if (pushA[i] == popA[j]) {
                i++;
                j++;
            } else {
                if (hashMap.containsKey(popA[j])) {
                    if (hashMap.get(popA[j]) == hashMap.size()) {
                        hashMap.remove(popA[j]);
                        j++;
                    } else {
                        return false;
                    }
                } else {
                    hashMap.put(pushA[i], hashMap.size() + 1);
                    i++;
                }

            }
        }
        while (j < pushA.length) {
            if (hashMap.containsKey(popA[j]) && hashMap.get(popA[j]) == hashMap.size()) {
                hashMap.remove(popA[j]);
                j++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean IsPopOrder1(int[] pushA, int[] popA) {
        if (pushA.length < 1) return true;
        Stack<Integer> stack = new Stack();
        for (int i = 0, j = 0; i < pushA.length; ) {
            stack.push(pushA[i++]);
            while (j < popA.length && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}

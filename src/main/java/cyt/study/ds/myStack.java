package cyt.study.ds;

import java.util.Stack;

/**
 * @Description: 栈
 * @Function List: 括号匹配、表达式求值、递归
 * @author: ytchen
 * @Date: 2016/7/16
 */
public class myStack {

    /**
     * Strack在java.util.Stack的一些操作说明
     */
    private static void StrackOpFromJavaUtil(){
        Stack<String> stack = new Stack<String>();
        System.out.println("now the stack is " + isEmpty(stack));
        stack.push("0");//入栈
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");
        stack.push("7");
        System.out.println("now the stack is " + isEmpty(stack));
        System.out.println(stack.peek());//输出栈顶元素，不出栈
        System.out.println(stack.pop());//出栈
        System.out.println(stack.pop());
        System.out.println(stack.search("2"));//查找 输出从栈顶到元素的顺序，这里 7,6出栈，2在第四个，输出4

    }
    private static String isEmpty(Stack<String> stack) {
        return stack.empty() ? "empty" : "not empty";
    }



}

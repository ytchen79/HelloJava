package com.cyt.jzoffer;

/**
 * @Description: 二进制中1的个数
 * @Function List: 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @author: ytchen
 * @Date: 2016/7/21
 */
public class NumberOf1 {
    public static void main(String[] args) {
        System.out.println(NumberOf1(-1));
        System.out.println(NumberOf1(0));
        System.out.println(NumberOf1(1));
        System.out.println(NumberOf1(2));
        System.out.println(NumberOf1(3));
        System.out.println(NumberOf1(5));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(0));
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(5));
    }


    public static int  NumberOf1(int n) {
        int count=0;
        String tmp=Integer.toBinaryString(n);
        for(int i=0;i<tmp.length();i++){
            if(tmp.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }
}

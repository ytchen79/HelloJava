package com.cyt.stujava;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Function List: TODO
 * @author: ytchen
 * @Date: 2016/7/28
 */
public class base {
    public static void main(String[] args){
        List<String> list1=new ArrayList<String>();
        List<String> list2=new ArrayList<String>();
        List<String> list3=new ArrayList<String>();
        list1.add("chen1");
        list1.add("chen2");
        list3.addAll(list1);
        list2.add("chen3");
        list2.add("chen4");
        list3.addAll(list2);
        System.out.println(list3.toString());

    }
}
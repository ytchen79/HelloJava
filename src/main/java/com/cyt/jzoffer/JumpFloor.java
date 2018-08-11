package com.cyt.jzoffer;

/**
 * @Description:
 * @Function List: TODO
 * @author: ytchen
 * @Date: 2016/7/20
 */
public class JumpFloor {
    public static void main(String[] args){
        System.out.println(JumpFloor3(15));
       /* System.out.println(JumpFloorII(1));
        System.out.println(JumpFloorII(2));
        System.out.println(JumpFloorII(3));
        System.out.println(JumpFloorII(4));*/
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * @param target
     * @return
     */
    public static int JumpFloor2(int target) {
        if(target<1)
            return 0;
        else if(target==1){
            return 1;
        }else if(target==2){
            return 2;
        }else {
            return JumpFloor2(target-1)+JumpFloor2(target-2);
        }
    }
    public static int JumpFloor3(int target) {
        if(target<1)
            return 0;
        else if(target==1){
            return 1;
        }else if(target==2){
            return 2;
        }else if(target == 3){
            return 4;
        }else {
            return JumpFloor3(target - 1)+JumpFloor3(target - 2)+JumpFloor3(target - 3);
        }
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * @param target
     * @return
     */
    public static int JumpFloorII(int target) {
        if(target<1)
            return 0;
        else if(target==1){
            return 1;
        }else {
            int count=0;
            for(int i=1;i<=target;i++){
                count+=JumpFloorII(target -i);
            }
            return count+1;
        }
    }
}

package cyt.jzoffer;

/**
 * @Description: 调整数组顺序使奇数位于偶数前面
 * @Function List: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author: ytchen
 * @Date: 2016/7/22
 */
public class reOrderArray {
    public static void main(String[] args) {
        int[] test0=new int[]{1,2,3,4,5,6,7};
        //print(test0);
        reOrderArray(test0);
       print(test0);

    }
    private static void print(int[] input){
        for(int i=0;i<input.length;i++){
            System.out.print(input[i]);
        }
        System.out.println();
    }
    public static void reOrderArray(int [] array) {
        int[] tmp=new int[array.length];
        int odd=0,even=array.length-1;
         for( int i=0;i<array.length;i++){
            if(array[i]%2 == 0){
                tmp[even--]=array[i];
            }else {
                tmp[odd++]=array[i];
            }
        }
        int i=0;
        for(;i<odd;i++)
            array[i]=tmp[i];
        for(int j=1;j<even+1;j++)
            array[i++]=tmp[tmp.length-j];
    }
}

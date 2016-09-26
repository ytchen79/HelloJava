package cyt.utils;

/**
 * @Description: 插入排序算法
 * @Function List: 直接插入、折半插入、希尔排序
 * @author: ytchen
 * @Date: 2016/7/15
 */
public class InsertionSort {
    /**
     * 冒泡排序
     * @param input
     */
    public static void BubbleSort(int[] input){
        int len=input.length;
        int tmp;
        boolean swapped=true;
        for(int i=1;i<len && swapped;i++){
            swapped=false;
            for(int j=0;j<len-i;j++){
                if(input[j]>input[j+1]){
                    tmp=input[j];
                    input[j]=input[j+1];
                    input[j+1]=tmp;
                    swapped=true;
                }
            }
        }

    }
    public static void main(String args[]){
        int[] test=new int[]{2,3,4,1,66,11,23,45,2,3,78};
        BubbleSort(test);
        for(int i=0;i<test.length;i++){
            System.out.print(test[i]+" ");
        }
    }


}

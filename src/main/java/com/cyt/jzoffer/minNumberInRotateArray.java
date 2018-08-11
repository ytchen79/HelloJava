package com.cyt.jzoffer;

/**
 * @Description: 旋转数组的最小数字
 *  把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *  输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 *  例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *  NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @Function List: TODO
 * @author: ytchen
 * @Date: 2016/7/20
 */
public class minNumberInRotateArray {
    public static  void main(String[] args){
        int[] in=new int[]{4,5,6,7,8,3};
        System.out.println(minNumberInRotateArray0(in));
        System.out.println(minNumberInRotateArray(in));

    }



    public static int minNumberInRotateArray0(int [] array) {
        int min=Integer.MAX_VALUE;
        if(array.length>0){
            for(int i=0;i<array.length;i++){
                if(array[i]<min)
                    min=array[i];
            }
            return min;
        }else
            return 0;
    }
    public static int minNumberInRotateArray(int [] array) {
        int low=0,high=array.length-1;
        int mid;
        while (low<=high){
            mid=(low+high)>>>1;
            if(array[low]<array[mid]){
                low=mid;
            }else if(array[low]>array[mid]){
                high=mid;
            }else{
                return array[high];

            }
        }

        return 0;
    }
}

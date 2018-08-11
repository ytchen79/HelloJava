package com.cyt.work.huawei;

import com.cyt.utils.InsertionSort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Description: ��������
 *  ���밴�տո����������λ��С��������ż��λ�Ӵ�С�������
 * @author: ytchen
 * @Date: 2016/7/15
 */
public class CrossoverSort {

    public static void main(String args[]){
        orderProcess();
    }
    public static void orderProcess(){
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        try{
            String[] str=bufferedReader.readLine().split(" ");
            int number=str.length;
            int[] odd=new int[(number+1)/2];
            int[] even=new int[number/2];
            for(int i=0;2*i<number;i++){
                odd[i]=Integer.parseInt(str[2*i]);
            }
            for(int i=0;(2*i+1)<number;i++){
                even[i]=Integer.parseInt(str[2*i+1]);
            }
            InsertionSort.BubbleSort(odd);
            InsertionSort.BubbleSort(even);
            for(int i=0;i<even.length;i++){
                System.out.print(odd[i]+" "+even[even.length-i-1]+" ");
            }
            if(number%2==1)
                System.out.print(odd[odd.length-1]);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

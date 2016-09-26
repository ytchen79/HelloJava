package cyt.jzoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:
 * @Description: TODO
 * @Function List: TODO
 * @author: ytchen
 * @version:
 * @Date: 2016/9/27
 * @History: //历史修改记录
 * <author>  // 修改人
 * <time> //修改时间
 * <version> //版本
 * <desc> // 描述修改内容
 */
public class MoreThanHalfNum_Solution {
    public static void  main(String[] args){
        int[] arr={1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution_1(arr));

    }

    /**
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     * @param input
     * @param k
     * @return
     */
   /* public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

    }*/
    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
     * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     * @param array
     * @return
     */
    /**
     * 采用阵地攻守的思想：
     第一个数字作为第一个士兵，守阵地；count = 1；
     遇到相同元素，count++;
     遇到不相同元素，即为敌人，同归于尽,count--；当遇到count为0的情况，又以新的i值作为守阵地的士兵，继续下去，到最后还留在阵地上的士兵，有可能是主元素。
     再加一次循环，记录这个士兵的个数看是否大于数组一般即可。
     * @param array
     * @return
     */
    public static int MoreThanHalfNum_Solution_1(int [] array) {
        int n = array.length;
        if (n == 0) return 0;

        int num = array[0], count = 1;
        for (int i = 1; i < n; i++) {
            if (array[i] == num) count++;
            else count--;
            if (count == 0) {
                num = array[i];
                count = 1;
            }
        }
        // Verifying
        count = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] == num) count++;
        }
        if (count * 2 > n) return num;
        return 0;
    }

    /**
     * 最普通的做法
     * @param array
     * @return
     */
    public static int MoreThanHalfNum_Solution_0(int [] array) {
        int hit=0;
        int len=array.length/2;
        Map<Integer ,Integer> map=new HashMap<Integer, Integer>();
        for(int i:array){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        for(int i:map.keySet()){
            if(map.get(i)>len){
                hit=i;
            }
        }
        return hit;

    }


}

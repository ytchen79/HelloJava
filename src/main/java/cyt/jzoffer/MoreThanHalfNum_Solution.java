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
 */
public class MoreThanHalfNum_Solution {
    public static void  main(String[] args){
        int[] arr={1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution_1(arr));

    }

    /**
     * @param input
     * @param k
     * @return
     */
   /* public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

    }*/
    /**
     * @param array
     * @return
     */
    /**
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

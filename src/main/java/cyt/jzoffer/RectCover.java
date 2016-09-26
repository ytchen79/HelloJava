package cyt.jzoffer;

/**
 * @Description: 矩形覆盖
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @Function List: TODO
 * @author: ytchen
 * @Date: 2016/7/21
 */
public class RectCover {
    public static void main(String[] args){
        System.out.println(RectCover(-1));
        System.out.println(RectCover(1));
        System.out.println(RectCover(2));
        System.out.println(RectCover(3));
        System.out.println(RectCover(4));
        System.out.println(RectCover(5));

    }


    public static int RectCover(int target) {
        if(target<1)
            return 0;
        else if(target==1){
            return 1;
        }if(target==2){
            return 2;
        }else {

            return RectCover(target-1)+RectCover(target-2);
        }
    }
}

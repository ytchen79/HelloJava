package cyt.jzoffer;

import java.util.ArrayList;

/**
 * @Description: 顺时针打印矩阵
 * @Function List: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @author: ytchen
 * @Date: 2016/7/26
 */
public class printMatrix {
    public static void main(String[] args) {
       // int[][] matrix = new int[][]{{1, 2, 3, 4}, { 5, 6,7, 8},{9,10,11,12},{13,14,15,16}};
    /*    测试用例:
        [[1,2,3,4,5],[6,7,8,9,10],[11,12,13,14,15],[16,17,18,19,20],[21,22,23,24,25]]

        对应输出应该为:

        [1,2,3,4,5,10,15,20,25,24,23,22,21,16,11,6,7,8,9,14,19,18,17,12,13]

        你的输出为:

        [1,2,3,4,5,10,15,20,25,24,23,22,21,16,11,6,7,8,9,14,19,18,17,12]

        */
       /* 测试用例:
        [[1],[2],[3],[4],[5]]

        对应输出应该为:

        [1,2,3,4,5]

        你的输出为:

        java.lang.ArrayIndexOutOfBoundsException: 4*/
      //  int[][] matrix = new int[][]{{1}};
       // int[][] matrix = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
      //  int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = new int[][]{{1},{2},{3},{4},{5}};
        ArrayList<Integer> list=printMatrix(matrix);
        print(list);

    }
    public static void print(ArrayList<Integer> list){
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        /*int wid=matrix[0].length,high=matrix.length;
        int row=0,col=0;
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(matrix.length<1)
            return list;
        else{
            while (wid>0 || high>0){
                System.out.println(wid + " " + high + " " + row + " " + col);
                for(int i=0;i<wid;i++){
                    list.add(matrix[row][col+i]);
                }
                for(int i=1;i<high-1 && wid>0;i++){
                    list.add(matrix[row+i][col+wid-1]);
                }
                for(int i=0;i<wid && high>0;i++){
                    list.add(matrix[row+high-1][col+wid-1-i]);
                }
                for(int i=1;i<high-1 && col<wid;i++){
                    list.add(matrix[row+high-1-i][col]);
                }
                wid-=2;
                high-=2;
                row++;col++;


            }
        }



        return list;*/
        ArrayList<Integer> result = new ArrayList<Integer> ();
        if(matrix.length==0) return result;
        int high = matrix.length,width = matrix[0].length;
        if(width==0) return result;
        int layers = (Math.min(high,width)-1)/2+1;//这个是层数
        for(int i=0;i<layers;i++){
            for(int k = i;k<width-i;k++) result.add(matrix[i][k]);//左至右
            for(int j=i+1;j<high-i;j++) result.add(matrix[j][width-i-1]);//右上至右下
            for(int k=width-i-2;(k>=i)&&(high-i-1!=i);k--) result.add(matrix[high-i-1][k]);//右至左
            for(int j=high-i-2;(j>i)&&(width-i-1!=i);j--) result.add(matrix[j][i]);//左下至左上
        }
        return result;
    }

}

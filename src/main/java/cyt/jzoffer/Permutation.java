package cyt.jzoffer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description: 字符串的排列
 * @Function List: TODO
 * @author: ytchen
 * @Date: 2016/8/29
 */
public class Permutation {
    /**
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
     * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     * 结果请按字母顺序输出。
     * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if(str!=null && str.length()>0){
            char[] arr= str.toCharArray();
            Arrays.sort(arr);
            res.add(String.valueOf(arr));
            int len=str.length();
            while (true){
                int p=len-1,q;
                //从后向前找一个arr[p - 1] < arr[p]
                while (p>0 && arr[p-1]>=arr[p] ) --p;
                if(p==0) break;//已经是“最小”的排列，退出
                //从p向后找最后一个比arr[p]大的数
                q = p; --p;
                while (q < len && arr[q] > arr[p]) q++;
                --q;
                //交换这两个位置上的值
                swap(arr, q, p);
                //将p之后的序列倒序排列
                reverse(arr, p + 1);
                res.add(String.valueOf(arr));

            }
        }
        return res;
    }
    public static void reverse(char[] seq, int start) {
        int len;
        if(seq == null || (len = seq.length) <= start)
            return;
        for (int i = 0; i < ((len - start) >> 1); i++) {
            int p = start + i, q = len - 1 - i;
            if (p != q)
                swap(seq, p, q);
        }
    }
    public static void swap(char[] arr,int i,int j){
        char tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}

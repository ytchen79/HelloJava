package cyt.jzoffer;

/**
 * @Description: 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 * @Function List: TODO
 * @author: ytchen
 * @Date: 2016/7/20
 */
public class Fibonacci {
    public static void main(String[] args){
       // System.out.println(Fibonacci(31));
      //  System.out.println((3+2)>>>1);
//        System.out.println(Fibonacci(3));
//        System.out.println(Fibonacci(4));
//        System.out.println(Fibonacci(5));
//        System.out.println(Fibonacci(6));
        int[] fib=new int[32];
        for(int i=0;i<32;i++){
            fib[i]=Fibonacci(i);
        }
        for(int i=0;i<32;i++){
            System.out.print(fib[i]+",");
        }
    }
    public static int Fibonacci0(int n) {
        if(n<=0)
            return 0;
        else if(n==1 )
            return 1;
        else if(n==2)
            return 1;
        else
            return Fibonacci(n-1)+Fibonacci(n-2);
    }
    public static int Fibonacci(int n) {
        if(n<=0)
            return 0;
        else if(n==1 )
            return 1;
        else if(n==2)
            return 1;
        else{
            int[] tmp=new int[n];
            tmp[0]=1;tmp[1]=1;
            for(int i=2;i<n;i++){
                tmp[i]=tmp[i-1]+tmp[i-2];
            }
            return tmp[n-1];
        }

    }
}

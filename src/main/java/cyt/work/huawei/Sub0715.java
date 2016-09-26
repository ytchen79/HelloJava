package cyt.work.huawei;

import java.util.Random;

/**
 * @Description: TODO
 * @author: ytchen
 * @Date: 2016/7/16
 */
public class Sub0715 {
    //判别大小
    public Boolean compare(int[] a,int[] b){
        Boolean bool=true;//大于
        for(int i=0;i<a.length;i++){
            //从高位开始遍历
            if(a[i]<b[i]){
                bool=false;
                break;
            }
            else if(a[i]>b[i]){
                bool=true;
                break;
            }
        }
        return bool;
    }



    public int[] subtraction(int[] a,int[] b){
        int[] c=new int[a.length];
        //a[0]...a[n]代表高位到低位
        for(int i=c.length-1;i>=0;i--){
            //最高位不借位
            if(i!=0){
                if(a[i]<b[i]){
                    a[i-1]-=1;//向高位借位
                    a[i]+=10;
                }
            }
            c[i]=a[i]-b[i];//存储对应位的差值
        }
        return c;
    }
    //输出
    public void print(int[] bt){
        for(int b : bt){
            System.out.print(b+" ");
        }


    }

    public static void main(String[] args){

        Random rand=new Random();
        for(int i=0;i<5;i++){
            Sub0715 sub=new Sub0715();
            int[] a=new int[20];
            int[] b=new int[20];
            for (int n=0; n<a.length; n++) {
                a[n]=rand.nextInt(10);//随机0--9
                b[n]=rand.nextInt(10);
            }

            //字符串反转且字符串变数字
            //m[i]=a[lenA-i-1]-'0';
            System.out.print("    ");
            sub.print(a);
            System.out.println("");
            System.out.print("-   ");
            sub.print(b);
            System.out.println("");
            System.out.println("------------------------------------------------");
            if(sub.compare(a,b)){//保证被减数大于减数
                System.out.print("    ");
                sub.print(sub.subtraction(a,b));
                System.out.println("");
            }
            else{
                System.out.print("   -");
                sub.print(sub.subtraction(b,a));
                System.out.println("");
            }
            System.out.println("");
            System.out.println("");
        }



    }
}

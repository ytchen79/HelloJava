package cyt.jzoffer;

/**
 * @Description: 数值的整数次方
 * @Function List: 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @author: ytchen
 * @Date: 2016/7/22
 */
public class Power {
    public static void main(String[] args) {
        System.out.println(Power(1, 2));
        System.out.println(Power(2, 0));
        System.out.println(Power(3, 2));
        System.out.println(Power(2, -1));

    }


    public static double Power(double base, int exponent) {
        double result=1.0;
        if(exponent==0){
            return 1;
        }else if(exponent<0){
            for(int i=0;i<-exponent;i++){
                result /=base;
            }
        }else{
            for(int i=0;i<exponent;i++){
                result *=base;
            }
        }
        return result;
    }
}

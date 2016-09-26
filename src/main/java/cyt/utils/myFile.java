package cyt.utils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Function List: TODO
 * @author: ytchen
 * @Date: 2016/7/30
 */
public class myFile {
    public static void AppendToFileA(String fileName, String content) {

        try {
            RandomAccessFile rf = new RandomAccessFile(fileName, "rw");
            rf.seek(rf.length()); // 将指针移动到文件末尾
            rf.writeBytes("\r\n" + content); // 字符串末尾需要换行符hhh

            rf.close();// 关闭文件流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void ReadFile(String filePath){
        try{
            File file = new File("H:\\项目\\车联网\\CLY\\数据-处理后\\v03010315.txt");

            if (file.isFile() && file.exists()) { // 判断文件是否存在
                BufferedReader bufferedReader = new BufferedReader(
                        new FileReader(file));
                String lineTxt="";
                while ((lineTxt = bufferedReader.readLine()) != null && lineTxt != "") {

                }
            }
        }catch (Exception e){

        }
    }
    public static void main(String[] args){
        File file = new File("E:\\学习\\Java\\Test.txt");
        try{
            Scanner input=new Scanner(file);
            System.out.println(input.nextLine());
        }catch (Exception e){

        }



    }
}

package cyt.utils;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.fastjson.JSONObject;

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
    public static Map<String,JSONObject> map =new HashMap<String, JSONObject>();
    public static void ReadFile(String filePath){
        try{
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { // 判断文件是否存在
                BufferedReader bufferedReader = new BufferedReader(
                        new FileReader(file));
                String lineTxt="",sim="";
                int i=0;
                System.out.println(filePath);
                while ((lineTxt = bufferedReader.readLine()) != null && lineTxt != "") {//
                   try{
                       i++;
                       JSONObject jsonObject=JSONObject.parseObject(lineTxt);
                       sim=jsonObject.getString("terminalPhoneNumber");
                       System.out.println(lineTxt);
                       if(map.containsKey(sim)){

                           if(map.get(sim).getString(("LAT")).equals(jsonObject.getString("LAT") )
                                   && map.get(sim).getString(("LON")).equals(jsonObject.getString("LON"))){

                           }else{
                               map.put(sim,jsonObject);
                               AppendToFileA("I:\\项目\\车联网\\CLY\\数据-处理后\\div\\" + sim + ".txt", lineTxt);
                           }
                       }else{
                           map.put(sim, jsonObject);
                           AppendToFileA("I:\\项目\\车联网\\CLY\\数据-处理后\\div\\" + sim + ".txt", lineTxt);
                       }

                      // set.add(jsonObject.getString("terminalPhoneNumber"));
                   }catch (Exception e){
                       e.printStackTrace();
                   }

                }
                System.out.println(filePath+":"+i);
            }
        }catch (Exception e){

        }
    }
    public static void main(String[] args){
        try{
            ReadFile("I:\\项目\\车联网\\CLY\\数据-处理后\\v03010315.txt");
//            ReadFile("I:\\项目\\车联网\\CLY\\数据-处理后\\v03150324.txt");
//            ReadFile("I:\\项目\\车联网\\CLY\\数据-处理后\\v03240401.txt");

            /*for(String str:set){
                AppendToFileA("d:\\newSim.txt",str);
            }*/
        }catch (Exception e){

        }



    }
}

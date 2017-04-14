package paper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * @Description: TODO
 * @Function List: TODO
 * @author: ytchen
 * @Date: 2017/3/30
 */
public class normal {
    double[][] station;
    public static void main(String[] args){
        System.out.println("free:" + Runtime.getRuntime().freeMemory() / 1024 / 1024);
        System.out.println("total:" + Runtime.getRuntime().totalMemory() / 1024 / 1024);
        Map station =ReadFile("d:\\stationGPS5");
        point p0=new point(36.947069,116.656046);point p1=new point(37.208946,116.895226);point p2=new point(37.748958,117.218557);
        point p3=new point(37.689382,117.250931);point p4=new point(40.297982,122.136392);point p5=new point(40.275208,122.194882);
        point p6=new point(37.734618,116.84403);point p7=new point(40.842496,111.802565);point p8=new point(40.880212,111.705077);
        point p9=new point(40.778604,111.659225);
        List<point> pointList=new ArrayList<point>();
        pointList.add(p0);pointList.add(p1);pointList.add(p2);pointList.add(p3);pointList.add(p4);pointList.add(p5);
        pointList.add(p6);pointList.add(p7);pointList.add(p8);pointList.add(p9);
        System.out.println(station.size());
        long start=System.currentTimeMillis();
        for(int i=0;i<pointList.size();i++){
            point pt=pointList.get(i);
           // System.out.println(pt.toString() );
            double dis_min=Double.MAX_VALUE;
            Iterator it=station.keySet().iterator();
            String result="";
            while(it.hasNext()){
                String sim=(String)it.next();
          //      System.out.println(sim );
                point pq=(point)station.get(sim);//??
                double dis=Math.sqrt((pq.x-pt.x)*(pq.x-pt.x)+(pq.y-pt.y)*(pq.y-pt.y));
             //  double dis=pq.x-pt.x;
                if(dis_min>dis){
                    dis_min=dis;
                    result=pt.toString()+",match "+pq.toString();
                }
            }
            System.out.println("result:"+result );
        }
        System.out.println("free:" + Runtime.getRuntime().freeMemory() / 1024 / 1024);
        System.out.println("total:" + Runtime.getRuntime().totalMemory() / 1024 / 1024);
        System.out.println("end:"+(System.currentTimeMillis()-start));

        System.out.println("free:" + Runtime.getRuntime().freeMemory() / 1024 / 1024);

    }

    public static Map<String,point> ReadFile(String filePath){
        try{
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { // 判断文件是否存在
                BufferedReader bufferedReader = new BufferedReader(
                        new FileReader(file));
                String lineTxt="",location="";
                int i=0;
                System.out.println(filePath);
                Map<String,point> res=new HashMap<String, point>();
                while ((lineTxt = bufferedReader.readLine()) != null && lineTxt != "") {//
                    try{
                        JSONObject jsonObject=JSONObject.parseObject(lineTxt);
                       if(jsonObject!=null &&jsonObject.containsKey("location")){
                           location=jsonObject.getString("location");
                           JSONObject locationJson= JSON.parseObject(location);
                           if(location!=null && !location.matches("null")){
                               point p=new point(locationJson.getDouble("lat"),locationJson.getDouble("lng"));
                               res.put("v" + i++,p);
                           }
                       }

                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
                return res;
            }
        }catch (Exception e){

        }
        return null;
    }

}
class point{
    double x;
    double y;
    public point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public point() {
        this.x = 0;
        this.y = 0;
    }
    @Override
    public String  toString(){
        return  String.format(Locale.ENGLISH,"Point[x=%f, y=%f]", x, y);
    }
}
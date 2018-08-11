package com.cyt.baidu.map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Vector;

/**
 * @ClassName:
 * @Description: 搜素服务站的个数
 * @Function List: TODO
 * @author: ytchen
 * @version:
 * @Date: 2016/11/16
 * @History: //历史修改记录
 * <author>  // 修改人
 * <time> //修改时间
 * <version> //版本
 * <desc> // 描述修改内容
 */
public class GetSuggestionPlace {
    private static final String BAIDU_APP_KEY = "w5NKFtGHrLH9XSR3r7WsDzwGlERDOQ8D";
    private static final String BAIDU_SK = "AI6YTreVkcX3H4rQ2WUzycD8paf1YLRN";
   // private static final String BAIDU_APP_KEY = "9b994c53729107462ffd55c2ff4c2db6";
    private static int page_size=20;
    public String getSuggestion(String query, String region) {
        try{
            query = URLEncoder.encode(query, "UTF-8");
            region = URLEncoder.encode(region, "UTF-8");
            URL resjson = new URL("http://api.map.baidu.com/place/v2/search?ak=" + BAIDU_APP_KEY +
                    "&output=json" +
                    "&query=" + query +
                    "&page_size=" +page_size+
                    "&page_num=0" +
                    "&scope=1" +
                    "&region=" + region);
            BufferedReader in = new BufferedReader(new InputStreamReader(resjson.openStream()));
            String res;
            StringBuilder sb = new StringBuilder("");
            while ((res = in.readLine()) != null) {
                sb.append(res.trim());
            }
            in.close();
            String str = sb.toString();
            if (str != null && !str.equals("")) {
                String retStr=null;
                int resStart = str.indexOf("results\":");
                int resEnd = str.indexOf("}]}");
                if (resStart > 0 && resEnd > 0) {
                    String results = str.substring(resStart + 10, resEnd + 1);
                    String[] resultArray = results.split("\"name\":\"");
                    retStr="[";
                    for (String result : resultArray) {
                        int nameStart = 0;
                        int nameEnd = result.indexOf("\",\"location");
                        int addressStart = result.indexOf("address");
                        int addressEnd = result.indexOf("\",\"street_id");
                        if (nameEnd > 0 && addressStart > 0 && addressEnd > 0) {
                            String name = result.substring(nameStart, nameEnd);
                            String address = result.substring(addressStart + 10, addressEnd);
                            retStr+="{\"name\":\""+name+"\",\"address\":\""+address+"\"},";
                        }
                    }
                    retStr=retStr.substring(0,retStr.length()-1);
                    retStr+="]";
                }
                return retStr;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Vector getRegionAll(String query, String region) {
        Vector res= new Vector();
        try{
            int totalPage=getTotalNumber(query, region);
            for(int i=0;i<totalPage;i++){
                res.addAll(getOnePage(query,region,i));
            }
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public int getTotalNumber(String query, String region) {
        int total=-1;
        try{
            query = URLEncoder.encode(query, "UTF-8");
            region = URLEncoder.encode(region, "UTF-8");
            String searchURL="http://api.map.baidu.com/place/v2/search?ak=" + BAIDU_APP_KEY +
                    "&output=json" +
                    "&query=" + query +
                    "&page_size=" +page_size+
                    //  "&page_num=0" +
                    "&scope=1" +
                    //      "&city_limit=true" +
                    "&region=" + region;
            System.out.println("searchURL:"+searchURL);
            URL resjson = new URL(searchURL);
            BufferedReader in = new BufferedReader(new InputStreamReader(resjson.openStream()));
            String res;
            StringBuilder all = new StringBuilder("");
            while ((res = in.readLine()) != null) {
                all.append(res.trim());
            }
            in.close();
            JSONObject jsonObject= JSON.parseObject(all.toString());

            if(jsonObject.containsKey("total")){
                total=jsonObject.getIntValue("total");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
    public int getTotalNumberbyGPS(String query, String regionGPS) {
        int total=-1;
        try{
            query = URLEncoder.encode(query, "UTF-8");
            regionGPS = URLEncoder.encode(regionGPS, "UTF-8");
            String searchURL="http://api.map.baidu.com/place/v2/search?ak=" + BAIDU_APP_KEY +
                    "&output=json" +
                    "&query=" + query +
                    "&page_size=" +page_size+
                    //  "&page_num=0" +
                    "&scope=1" +
                    //      "&city_limit=true" +
                    "&location=" + regionGPS;
            System.out.println("searchURL:"+searchURL);
            URL resjson = new URL(searchURL);
            BufferedReader in = new BufferedReader(new InputStreamReader(resjson.openStream()));
            String res;
            StringBuilder all = new StringBuilder("");
            while ((res = in.readLine()) != null) {
                all.append(res.trim());
            }
            in.close();
            JSONObject jsonObject= JSON.parseObject(all.toString());

            if(jsonObject.containsKey("total")){
                total=jsonObject.getIntValue("total");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
    public Vector getOnePage(String query, String region,int page_num) {
        Vector res= new Vector();
        try{
            query = URLEncoder.encode(query, "UTF-8");
            region = URLEncoder.encode(region, "UTF-8");
            String searchURL="http://api.map.baidu.com/place/v2/search?ak=" + BAIDU_APP_KEY +
                    "&output=json" +
                    "&query=" + query +
                    "&page_size=" +page_size+
                    "&page_num=" +page_num+
                    "&scope=1" +
                    "&region=" + region;
            URL resjson = new URL(searchURL);
            BufferedReader in = new BufferedReader(new InputStreamReader(resjson.openStream()));
            String line;
            StringBuilder all = new StringBuilder("");
            while ((line = in.readLine()) != null) {
                all.append(line.trim());
            }
            in.close();
            JSONObject jsonObject= JSON.parseObject(all.toString());
            JSONObject jsonTmp;
            JSONArray jsonArray;
            if(jsonObject.containsKey("status")){
                int status=jsonObject.getIntValue("status");
                if(status==0){
                    if(!jsonObject.getString("results").equals("")){
                        jsonArray=JSON.parseArray(jsonObject.getString("results"));
                        for(int i=0;i<jsonArray.size();i++){
                            jsonTmp=jsonArray.getJSONObject(i);
                            //  System.out.println(jsonTmp.toJSONString());
                           // res.add(jsonTmp.getString("location"));
                             res.add(jsonTmp);
                        }
                    }
                }else{
                    return null;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        System.out.println("<--start-->");
        GetSuggestionPlace g=new GetSuggestionPlace();
//        FileUtils.AppendToFileA("f:\\getSuggestion.txt", start+":"+g.getSuggestion("西湖镇","湖南省"));
//
//        System.out.println(g.getTotalNumber("汽车,维修","厦门"));
//        System.out.println(g.getTotalNumber("汽车,修理","厦门"));
//        System.out.println(g.getTotalNumber("服务站","厦门"));
//        System.out.println(g.getTotalNumber("汽车,服务站","厦门"));
//        System.out.println(g.getTotalNumber("汽车,服务","厦门"));
//        System.out.println(g.getTotalNumber("汽车,修理厂", "厦门"));
        System.out.println(g.getTotalNumberbyGPS("服务站", "24.490474,118.11022"));
        System.out.println(g.getTotalNumberbyGPS("服务站", "24.44543,118.08233"));
        System.out.println(g.getTotalNumberbyGPS("服务站", "24.48461,118.03289"));
        System.out.println(g.getTotalNumberbyGPS("服务站", "24.51253,118.14621"));
        System.out.println(g.getTotalNumberbyGPS("服务站", "24.57584,118.09719"));
        System.out.println(g.getTotalNumberbyGPS("服务站", "24.72308,118.15197"));
        System.out.println(g.getTotalNumberbyGPS("服务站", "24.61863,118.24783"));
        //System.out.println(g.getRegionAll("服务站", "北京"));
      //  System.out.println(g.getSuggestion("内蒙古万佳小学","鄂尔多斯市"));
//        String str="{\"address\":\"山东庄镇桥头营大街29\",\"detail\":1,\"location\":{\"lat\":40.167763,\"lng\":117.154371},\"name\":\"福山汽车修理厂\",\"street_id\":\"2c0bd6c57b47d5b343ab9a26\",\"telephone\":\"(010)60938088\",\"uid\":\"2c0bd6c57b47d5b343ab9a26\"}";
//        myFile.AppendToFileA("D:\\stationGPS3-13.txt", str);
        System.out.println("--end-->"+(System.currentTimeMillis()-start));
    }
}

package com.zoo.controller;

import org.json.JSONArray;
import org.json.JSONObject;

import com.zoo.model.FeedLog;
import com.zoo.service.RESTfulService;

public class FeedLogController {
    
    static String url = "http://127.0.0.1:8080";

    public static String fedbyani(int id){
        try {
            JSONObject json = new JSONObject(RESTfulService.doGet(url+"/feedLog/animal/"+id));
            JSONArray data = new JSONArray(json.optJSONArray("data"));

            String result = "find "+ data.length() +" rows";

            FeedLog feed_log = new FeedLog();

            for (int i = 0; i < data.length(); i++) {
                // 取得陣列中的每個 JSON 物件
                JSONObject jsonObject = data.getJSONObject(i);
    
                // 取得 JSON 物件中的值
                feed_log.id_feed_log = jsonObject.getInt("id_feed_log");
                feed_log.id_food = jsonObject.getInt("id_food");
                feed_log.idAnimal = jsonObject.getInt("idAnimal");
                feed_log.time = jsonObject.getString("time");
                
                result += "\n";
                result += "\n" + "FeedLog ID: " + feed_log.id_feed_log;
                result += "\n" + "Food ID: " + feed_log.id_food;
                result += "\n" + "Animal ID: " + feed_log.idAnimal;
                result += "\n" + "Time: " + feed_log.time;
            }

            return result;
        } catch (Exception e) {
            return e.toString();
        }
    }

    public static String fedadd(FeedLog feed_log){
        try {
            JSONObject json = new JSONObject();
            json.put("id_food", feed_log.id_food);
            json.put("idAnimal", feed_log.idAnimal);
            json.put("time", feed_log.time);

            RESTfulService.doPost(url+"/feedLog/add",json.toString());
            return "Successful Add FeedLog";
        } catch (Exception e) {
            return e.toString();
        }
    }
}

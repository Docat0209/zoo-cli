package com.zoo.controller;

import org.json.JSONArray;
import org.json.JSONObject;

import com.zoo.model.FeedLog;
import com.zoo.service.RESTfulService;

public class FeedLogController {
    
    static String url = "http://127.0.0.1:8080";

    // get feed log by animal id
    public static String fedbyani(int id){
        try {
            JSONObject json = new JSONObject(RESTfulService.doGet(url+"/feedLog/animal/"+id));
            JSONArray data = new JSONArray(json.optJSONArray("data"));

            String result = "find "+ data.length() +" rows";

            FeedLog feed_log = new FeedLog();

            for (int i = 0; i < data.length(); i++) {
                // get json object
                JSONObject jsonObject = data.getJSONObject(i);
    
                // get json value
                feed_log.id_feed_log = jsonObject.getInt("id_feed_log");
                feed_log.id_food = jsonObject.getInt("id_food");
                feed_log.idAnimal = jsonObject.getInt("idAnimal");
                feed_log.time = jsonObject.getString("time");
                
                // result
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

    // add feed log
    public static String fedadd(FeedLog feed_log){
        try {
            // json data
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

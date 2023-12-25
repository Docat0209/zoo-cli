package com.zoo.controller;

import org.json.JSONArray;
import org.json.JSONObject;

import com.zoo.model.Enclosure;
import com.zoo.service.RESTfulService;

public class EnclosureController {
    static String url = "http://127.0.0.1:8080";

    // get all enclosure
    public static String encs(){
        try {
            JSONObject json = new JSONObject(RESTfulService.doGet(url+"/enclosure"));
            JSONArray data = new JSONArray(json.optJSONArray("data"));

            String result = "find "+ data.length() +" rows";

            Enclosure enclosure = new Enclosure();

            for (int i = 0; i < data.length(); i++) {
                // get json object
                JSONObject jsonObject = data.getJSONObject(i);
    
                // get json value
                enclosure.id_enclosure = jsonObject.getInt("id_enclosure");
                enclosure.id_zoo = jsonObject.getInt("id_zoo");
                enclosure.name = jsonObject.getString("name");
                enclosure.introduce = jsonObject.getString("introduce");
                
                // result
                result += "\n";
                result += "\n" + "Enclosure ID: " + enclosure.id_enclosure;
                result += "\n" + "Zoo ID: " + enclosure.id_zoo;
                result += "\n" + "Name: " + enclosure.name;
                result += "\n" + "introduce: " + enclosure.introduce;
            }

            return result;
        } catch (Exception e) {
            return e.toString();
        }
    }

    // add enclosure
    public static String encadd(Enclosure enclosure){
        try {
            // json data
            JSONObject json = new JSONObject();
            json.put("id_zoo", enclosure.id_zoo);
            json.put("name", enclosure.name);
            json.put("introduce", enclosure.introduce);

            RESTfulService.doPost(url+"/enclosure/add",json.toString());
            return "Successful Add Enclosure";
        } catch (Exception e) {
            return e.toString();
        }
    }

    // upgrade enclosure
    public static String encupg(Enclosure enclosure){
        try {
            // json data
            JSONObject json = new JSONObject();
            json.put("id_enclosure", enclosure.id_enclosure);
            json.put("id_zoo", enclosure.id_zoo);
            json.put("name", enclosure.name);
            json.put("introduce", enclosure.introduce);

            RESTfulService.doPut(url+"/enclosure/update",json.toString());
            return "Successful Update Enclosure";
        } catch (Exception e) {
            return e.toString();
        }
    }

    // delete enclosure
    public static String encdel(int id){
        try {
            RESTfulService.doDelete(url+"/enclosure/delete/"+id);
            return "Successful Delete Enclosure";
        } catch (Exception e) {
            return e.toString();
        }
    }
}

package com.zoo.controller;

import org.json.JSONArray;
import org.json.JSONObject;

import com.zoo.model.Animal;
import com.zoo.service.RESTfulService;

public class AnimalController {

    static String url = "http://127.0.0.1:8080";

    // get all animal
    public static String anis(){
        try {
            JSONObject json = new JSONObject(RESTfulService.doGet(url+"/animal"));
            JSONArray data = new JSONArray(json.optJSONArray("data"));

            String result = "find "+ data.length() +" rows";

            Animal animal = new Animal();

            for (int i = 0; i < data.length(); i++) {
                // get json object
                JSONObject jsonObject = data.getJSONObject(i);
    
                // get json value
                animal.id_animal = jsonObject.getInt("id_animal");
                animal.id_animal_type = jsonObject.getInt("id_animal_type");
                animal.id_zoo = jsonObject.getInt("id_zoo");
                animal.idEnclosure = jsonObject.getInt("idEnclosure");
                animal.id_status = jsonObject.getInt("id_status");
                animal.name = jsonObject.getString("name");
                animal.introduction = jsonObject.getString("introduction");
                animal.nofication = jsonObject.getString("nofication");
                animal.img_url = jsonObject.getString("img_url");
                
                // result
                result += "\n";
                result += "\n" + "Animal ID: " + animal.id_animal;
                result += "\n" + "Animal Type ID: " + animal.id_animal_type;
                result += "\n" + "Zoo ID: " + animal.id_zoo;
                result += "\n" + "Enclosure ID: " + animal.idEnclosure;
                result += "\n" + "Status ID: " + animal.id_status;
                result += "\n" + "Name: " + animal.name;
                result += "\n" + "Introduction: " + animal.introduction;
                result += "\n" + "Nofication: " + animal.nofication;
                result += "\n" + "Img url: " + animal.img_url;
            }

            return result;
        } catch (Exception e) {
            return e.toString();
        }
    }

    // get animal by enclosure id
    public static String anibyenc(int id){
        try {
            JSONObject json = new JSONObject(RESTfulService.doGet(url+"/animal/enclosure/"+id));
            JSONArray data = new JSONArray(json.optJSONArray("data"));

            String result = "find "+ data.length() +" rows";

            Animal animal = new Animal();

            for (int i = 0; i < data.length(); i++) {
                // get json object
                JSONObject jsonObject = data.getJSONObject(i);
    
                // get json value
                animal.id_animal = jsonObject.getInt("id_animal");
                animal.id_animal_type = jsonObject.getInt("id_animal_type");
                animal.id_zoo = jsonObject.getInt("id_zoo");
                animal.idEnclosure = jsonObject.getInt("idEnclosure");
                animal.id_status = jsonObject.getInt("id_status");
                animal.name = jsonObject.getString("name");
                animal.introduction = jsonObject.getString("introduction");
                animal.nofication = jsonObject.getString("nofication");
                animal.img_url = jsonObject.getString("img_url");
                
                // result
                result += "\n";
                result += "\n" + "Animal ID: " + animal.id_animal;
                result += "\n" + "Animal Type ID: " + animal.id_animal_type;
                result += "\n" + "Zoo ID: " + animal.id_zoo;
                result += "\n" + "Enclosure ID: " + animal.idEnclosure;
                result += "\n" + "Status ID: " + animal.id_status;
                result += "\n" + "Name: " + animal.name;
                result += "\n" + "Introduction: " + animal.introduction;
                result += "\n" + "Nofication: " + animal.nofication;
                result += "\n" + "Img url: " + animal.img_url;
            }

            return result;
        } catch (Exception e) {
            return e.toString();
        }
    }

    // add animal
    public static String aniadd(Animal animal){
        try {
            // json data
            JSONObject json = new JSONObject();
            json.put("id_animal_type", animal.id_animal_type);
            json.put("id_zoo", animal.id_zoo);
            json.put("idEnclosure", animal.idEnclosure);
            json.put("id_status", animal.id_status);
            json.put("name", animal.name);
            json.put("introduction", animal.introduction);
            json.put("nofication", animal.nofication);
            json.put("img_url", animal.img_url);

            RESTfulService.doPost(url+"/animal/add",json.toString());
            return "Successful Add Animal";
        } catch (Exception e) {
            return e.toString();
        }
    }

    // upgrade animal by id
    public static String aniupg(Animal animal){
        try {
            // json data
            JSONObject json = new JSONObject();
            json.put("id_animal", animal.id_animal);
            json.put("id_animal_type", animal.id_animal_type);
            json.put("id_zoo", animal.id_zoo);
            json.put("idEnclosure", animal.idEnclosure);
            json.put("id_status", animal.id_status);
            json.put("name", animal.name);
            json.put("introduction", animal.introduction);
            json.put("nofication", animal.nofication);
            json.put("img_url", animal.img_url);

            RESTfulService.doPut(url+"/animal/update",json.toString());
            return "Successful Update Animal";
        } catch (Exception e) {
            return e.toString();
        }
    }

    // delete animal by id
    public static String anidel(int id){
        try {
            RESTfulService.doDelete(url+"/animal/delete/"+id);
            return "Successful Delete Animal";
        } catch (Exception e) {
            return e.toString();
        }
    }
}
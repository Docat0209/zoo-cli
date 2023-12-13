package com.zoo.controller;

import org.json.JSONArray;
import org.json.JSONObject;

import com.zoo.model.Staff;
import com.zoo.service.RESTfulService;

public class StaffController {
    static String url = "http://127.0.0.1:8080";

    public static String staffs(){
        try {
            JSONObject json = new JSONObject(RESTfulService.doGet(url+"/staff"));
            JSONArray data = new JSONArray(json.optJSONArray("data"));

            String result = "find "+ data.length() +" rows";

            Staff staff = new Staff();

            for (int i = 0; i < data.length(); i++) {
                // 取得陣列中的每個 JSON 物件
                JSONObject jsonObject = data.getJSONObject(i);
    
                // 取得 JSON 物件中的值
                staff.id_staff = jsonObject.getInt("id_staff");
                staff.id_zoo = jsonObject.getInt("id_zoo");
                staff.id_staff_type = jsonObject.getInt("id_staff_type");
                staff.name = jsonObject.getString("name");
                staff.salary = jsonObject.getInt("salary");
                
                result += "\n";
                result += "\n" + "Staff ID: " + staff.id_staff;
                result += "\n" + "Zoo ID: " + staff.id_zoo;
                result += "\n" + "Staff type ID: " + staff.id_staff_type;
                result += "\n" + "Name: " + staff.name;
                result += "\n" + "Salary: " + staff.salary;
            }

            return result;
        } catch (Exception e) {
            return e.toString();
        }
    }

    public static String staffadd(Staff staff){
        try {
            JSONObject json = new JSONObject();
            json.put("id_zoo", staff.id_zoo);
            json.put("name", staff.name);
            json.put("id_staff_type", staff.id_staff_type);
            json.put("salary", staff.salary);

            RESTfulService.doPost(url+"/staff/add",json.toString());
            return "Successful Add Staff";
        } catch (Exception e) {
            return e.toString();
        }
    }

    public static String staffupg(Staff staff){
        try {
            JSONObject json = new JSONObject();
            json.put("id_staff", staff.id_staff);
            json.put("id_zoo", staff.id_zoo);
            json.put("name", staff.name);
            json.put("id_staff_type", staff.id_staff_type);
            json.put("salary", staff.salary);

            RESTfulService.doPut(url+"/staff/update",json.toString());
            return "Successful Update Staff";
        } catch (Exception e) {
            return e.toString();
        }
    }

    public static String staffdel(int id){
        try {
            RESTfulService.doDelete(url+"/staff/delete/"+id);
            return "Successful Delete Staff";
        } catch (Exception e) {
            return e.toString();
        }
    }
}

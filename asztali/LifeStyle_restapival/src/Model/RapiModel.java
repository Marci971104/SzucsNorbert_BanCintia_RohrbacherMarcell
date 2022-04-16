package Model;




import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Vector;


public class RapiModel {
	
	private String DeleteMealMsg;
	private String DeleteUserMsg;
	 private ResponseModel responseMdl;


	
	
public String tryLogin() {
	        String result = "";
	        try {
	            result = Login();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return result;
	    }
	
private String Login() throws Exception{
        
        URL url = new URL("http://localhost:8000/api/login");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");
        

        String data= "{\"email\":\"admin@email.hu\",\"password\":\"admin\"}";
        byte[] out = data.getBytes(StandardCharsets.UTF_8);
        
        OutputStream stream = conn.getOutputStream();
        stream.write(out);
        
        conn.connect();
        String text = "";
        int responseCode = conn.getResponseCode();
        if(responseCode == 200) {
            text = new String(
                conn.getInputStream().readAllBytes(), 
                StandardCharsets.UTF_8);
        }else {
            throw new RuntimeException("Http válasz: " + responseCode);
        }
        JsonObject jsonObject = new JsonParser().parse(text).getAsJsonObject();
        JsonObject tokenObject = jsonObject.getAsJsonObject("data");
        
        String token_raw = tokenObject.get("token").toString();
        String token = token_raw.substring(1, token_raw.length() - 1);
        return token;
        }



 

    public Vector<Vector<Object>> tryUsers(String token ) {
        Vector<Vector<Object>> users = new Vector<>();
        try {
            users = Users(token );
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return users;
    }
    public Vector<Vector<Object>> Users(String token ) throws Exception{
    
       URL url = new URL("http://localhost:8000/api/show-all-user/" );
       //URL url = new URL("http://localhost:8000/api/show-all-users/" + search_text); 
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        
        conn.setRequestProperty("Authorization", "Bearer " +token);
        
        conn.setDoOutput(true);

        conn.connect();
        
        String text = "";
        int responseCode = conn.getResponseCode();
        if(responseCode == 200) {
            text = new String(
                conn.getInputStream().readAllBytes(), 
                StandardCharsets.UTF_8);
        }else {
            throw new RuntimeException("Http válasz: " + responseCode);
        }
        JsonObject jsonObject = new JsonParser().parse(text).getAsJsonObject();
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        JsonArray arr = jsonObject.getAsJsonArray("data");
        
        UserModel[] userArray = gson.fromJson(arr, UserModel[].class);
        ArrayList<UserModel> lista = new ArrayList<>(Arrays.asList(userArray));
        
        Vector<Vector<Object>> users = new Vector<>();
        for(UserModel usermodel: lista) {
            
            Vector<Object> user = new Vector<>();

            user.add(usermodel.id);
            user.add(usermodel.name);
            user.add(usermodel.email);
            user.add(usermodel.password);
            
            users.add(user);
            
        }
        return users;
        
    }
    public Vector<Vector<Object>> tryMeals(String token,  String method) {
        Vector<Vector<Object>> meals = new Vector<>();
        try {
            meals = Meals(token, method);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return meals;
    }
    
	private Vector<Vector<Object>> Meals(String token,  String method) throws Exception{
        
        URL url = new URL("http://localhost:8000/api/show-all-meal/" );
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        
        conn.setRequestProperty("Authorization", "Bearer " +token);
        conn.setRequestMethod(method);
        conn.setDoOutput(true);

        conn.connect();
        
        String text = "";
        int responseCode = conn.getResponseCode();
        if(responseCode == 200) {
            text = new String(
                conn.getInputStream().readAllBytes(), 
                StandardCharsets.UTF_8);
        }else {
            throw new RuntimeException("Http válasz: " + responseCode);
        }
        JsonObject jsonObject = new JsonParser().parse(text).getAsJsonObject();
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        JsonArray arr = jsonObject.getAsJsonArray("data");
        
        MealModel[] mealArray = gson.fromJson(arr, MealModel[].class);
        ArrayList<MealModel> lista = new ArrayList<>(Arrays.asList(mealArray));
        
        Vector<Vector<Object>> meals = new Vector<>();
        for(MealModel mealmodel: lista) {
            
            Vector<Object> meal = new Vector<>();

            meal.add(mealmodel.id);
            meal.add(mealmodel.name);
            meal.add(mealmodel.calorievalue);
            meal.add(mealmodel.fat);
            meal.add(mealmodel.protein);
           meal.add(mealmodel.carbohydrate);
            meal.add(mealmodel.salt);
            
            meals.add(meal);
            
        }
        return meals;
        
    }
    
    public Vector<Vector<Object>> tryDatas(String token,  String method) {
        Vector<Vector<Object>> datas = new Vector<>();
        try {
            datas = Datas(token, method);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return datas;
    }
    
	private Vector<Vector<Object>> Datas(String token,  String method) throws Exception{
        
        URL url = new URL("http://localhost:8000/api/show-all-data/" );
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        
        conn.setRequestProperty("Authorization", "Bearer " +token);
        conn.setRequestMethod(method);
        conn.setDoOutput(true);

        conn.connect();
        
        String text = "";
        int responseCode = conn.getResponseCode();
        if(responseCode == 200) {
            text = new String(
                conn.getInputStream().readAllBytes(), 
                StandardCharsets.UTF_8);
        }else {
            throw new RuntimeException("Http válasz: " + responseCode);
        }
        JsonObject jsonObject = new JsonParser().parse(text).getAsJsonObject();
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        JsonArray arr = jsonObject.getAsJsonArray("data");
        
        DataModel[] dataArray = gson.fromJson(arr, DataModel[].class);
        ArrayList<DataModel> lista = new ArrayList<>(Arrays.asList(dataArray));
        
        Vector<Vector<Object>> datas = new Vector<>();
        for(DataModel datamodel: lista) {
            
            Vector<Object> data = new Vector<>();

            data.add(datamodel.id);
            data.add(datamodel.height);
            data.add(datamodel.weight);
            data.add(datamodel.age);
            data.add(datamodel.gender);
           data.add(datamodel.allcalories);
            data.add(datamodel.waterintake);
            
            datas.add(data);
            
        }
        return datas;
        
    }

	  public void tryLogout(String token) {
	        try {
	            
	            Logout(token);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	  
	  public Boolean tryDeleteMeal(String token, String id) {
	        boolean success = false;
	        try {
	            success = DeleteMeal(token, id);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return success;
	    }
	    private Boolean DeleteMeal(String token, String id) throws Exception{
	        URL url = new URL("http://localhost:8000/api/delete-meal/" + id);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        
	        conn.setRequestProperty("Authorization", "Bearer " +token);
	        conn.setRequestMethod("DELETE");
	        conn.setDoOutput(true);

	        conn.connect();
	        
	        int responseCode = conn.getResponseCode();
	        String text = "";
	        boolean success = false;
	        
	        if(responseCode == 200) {
	            success = true;
	            text = new String(
	                conn.getInputStream().readAllBytes(), 
	                StandardCharsets.UTF_8);
	        }else {
	            throw new RuntimeException("Http válasz: " + responseCode);
	        }
	        
	        JsonObject jsonObject = new JsonParser().parse(text).getAsJsonObject();
	        
	        String message_raw = jsonObject.get("message").toString();
	        DeleteMealMsg = message_raw.substring(1, message_raw.length() - 1);
	        
	        return success;
	    }
	    
	    public Boolean tryDeleteUser(String token, String id) {
	        boolean success = false;
	        try {
	            success = DeleteUser(token, id);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return success;
	    }
	    private Boolean DeleteUser (String token, String id) throws Exception{
	        URL url = new URL("http://localhost:8000/api/delete-user/" + id);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        
	        conn.setRequestProperty("Authorization", "Bearer " +token);
	        conn.setRequestMethod("DELETE");
	        conn.setDoOutput(true);

	        conn.connect();
	        
	        int responseCode = conn.getResponseCode();
	        String text = "";
	        boolean success = false;
	        
	        if(responseCode == 200) {
	            success = true;
	            text = new String(
	                conn.getInputStream().readAllBytes(), 
	                StandardCharsets.UTF_8);
	        }else {
	            throw new RuntimeException("Http válasz: " + responseCode);
	        }
	        
	        JsonObject jsonObject = new JsonParser().parse(text).getAsJsonObject();
	        
	        String message_raw = jsonObject.get("message").toString();
	        DeleteMealMsg = message_raw.substring(1, message_raw.length() - 1);
	        
	        return success;
	    }
	    
	    
	    
	    public Boolean tryUpdateUser (String token,String id){
            boolean success =false;
            try{
                success = UpdateUser(token,id);

            }catch(Exception ex){
                ex.printStackTrace();
            }
            return success;
       }
       private Boolean UpdateUser (String token, String id) throws Exception{
           URL url = new URL("http://localhost:8000/api/update-user" + id);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        
        http.setRequestProperty("Authorization", "Bearer " +token);
        http.setRequestMethod("PUT");
        http.setDoOutput(true);

        http.connect();
        
        boolean success = false;
        String text = "";
        int responseCode = http.getResponseCode();
        
        if(responseCode == 200) {
            success = true;
            text = new String(
                http.getInputStream().readAllBytes(), 
                StandardCharsets.UTF_8);
        }else {
            throw new RuntimeException("Http válasz: " + responseCode);
        }
        return success;
       }
	    
	    
	    //Update-meal//
	    
	    
	    public Boolean tryUpdateMeal(String token, String id) {
	        boolean success = false;
	        try {
	            success = UpdateMeal(token, id);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return success;
	    }
	    private Boolean UpdateMeal(String token, String id) throws Exception{
	    
	        URL url = new URL("http://localhost:8000/api/update-meal/" + id);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        
	        conn.setRequestProperty("Authorization", "Bearer " +token);
	        conn.setRequestMethod("PUT");
	        conn.setDoOutput(true);

	        conn.connect();
	        
	        boolean success = false;
	        String text = "";
	        int responseCode = conn.getResponseCode();
	        
	        if(responseCode == 200) {
	            success = true;
	            text = new String(
	                conn.getInputStream().readAllBytes(), 
	                StandardCharsets.UTF_8);
	        }else {
	            throw new RuntimeException("Http válasz: " + responseCode);
	        }
	        

	        return success;
	    }

	  
	    private void Logout(String token) throws Exception{
	    
	        URL url = new URL("http://localhost:8000/api/logout");
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        
	        conn.setRequestProperty("Authorization", "Bearer " +token);
	        conn.setRequestMethod("POST");
	        conn.setDoOutput(true);
	        
	        String data = token;
	        byte[] out = data.getBytes(StandardCharsets.UTF_8);
	        
	        OutputStream stream = conn.getOutputStream();
	        stream.write(out);
	        
	        String text = "";
	        text = new String(
	                conn.getInputStream().readAllBytes(), 
	                StandardCharsets.UTF_8);
	        
	        System.out.println("Sikeres kijelentkezes");
	    }
	
	    
	    public String getDeleteMealMsg() {
	        return DeleteMealMsg;
	    }
	    public String getDeleteUserMsg() {
	        return DeleteUserMsg;
	    }
		public void setDeleteMealMsg(String deleteMealMsg) {
			DeleteMealMsg = deleteMealMsg;
		}

		public void setDeleteUserMsg(String deleteUserMsg) {
			DeleteUserMsg = deleteUserMsg;
		}

		
	
		
		
		

	
		
		
	    

}
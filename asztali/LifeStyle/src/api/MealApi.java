
package api;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.net.HttpURLConnection;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

 
public class MealApi{
 
    public static void main(String[] args) throws Exception {
 
        URL url = new URL("http://127.0.0.1:8000/api/meal");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        String text = "";
        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("Http válasz: " + responseCode);
        }else {
            Scanner sc = new Scanner(url.openStream(), "UTF-8");
            while(sc.hasNext()) {
                text += sc.nextLine();
            }
        }
        JsonObject jsonObject = new JsonParser().parse(text).getAsJsonObject();
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        
        JsonArray arr = jsonObject.getAsJsonArray("data");
        
        Meal[] mealArray = gson.fromJson(arr, Meal[].class);
        ArrayList<Meal> list = new ArrayList<>(Arrays.asList(mealArray));
 
        for(Meal meal: list) {
            System.out.println(meal.salt);
        }
 
    }
}
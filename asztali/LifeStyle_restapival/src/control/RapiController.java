package control;

import java.util.Vector;

import Model.RapiModel;

public class RapiController {

	private String id;
    private RapiModel rapiMdl;
    private String token;
    private String search_text;
    private String method;
    
    public RapiController() {
        rapiMdl = new RapiModel();
        token = getToken();
        search_text = "";
        method = "GET";
    }
    private String getToken() {
        String token = rapiMdl.tryLogin();
        System.out.println(token);
        return token;
    }
    public void Logout() {
        rapiMdl.tryLogout(token);
    }
    public Vector<Vector<Object>> getUsers() {
        Vector<Vector<Object>> users = new Vector<>();
        
        users = rapiMdl.tryUsers(token, search_text, method);
        
        return users;
    }
    public Vector<Vector<Object>> getData() {
        Vector<Vector<Object>> datas = new Vector<>();
        
        datas = rapiMdl.tryDatas(token, search_text, method);
        
        return datas;
    }
    public void setData(String search_text, String method) {
        
        this.search_text = search_text;
        this.method = method;
    }
    
    
    public Vector<Vector<Object>> getMeal() {
        Vector<Vector<Object>> meals = new Vector<>();
        
        meals = rapiMdl.tryMeals(token, search_text, method);
        
        return meals;
    }
    public void setMeal(String search_text, String method) {
        
        this.search_text = search_text;
        this.method = method;
    }
    
    public void setSearchData(String search_text) {
        this.search_text = search_text;
    }
    
    
    public Boolean DeleteMeal() {
        boolean success = rapiMdl.tryDeleteMeal(token, id);
        return success;
    }
    public String getDeleteMealMsg() {
        String message = rapiMdl.getDeleteMealMsg();
        return message;
    }
    
    public Boolean DeleteUser() {
        boolean success = rapiMdl.tryDeleteUser(token, id);
        return success;
    }
    public String getDeleteUser() {
        String message = rapiMdl.getDeleteUserMsg();
        return message;
    }
    
    
    public String getDeleteUserMsg() {
        String message = rapiMdl.getDeleteUserMsg();
        return message;
    }
    
    public void setId(String id) {
        this.id = id;
    }

	
}

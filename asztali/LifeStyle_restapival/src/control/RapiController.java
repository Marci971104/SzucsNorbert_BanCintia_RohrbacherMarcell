package control;

import java.util.Vector;

import Model.RapiModel;

public class RapiController {

	private String id;

    private RapiModel rapiMdl;
    private String token;
    private String method;
    
    public RapiController() {
        rapiMdl = new RapiModel();
        token = getToken();
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
        
        users = rapiMdl.tryUsers(token);
        
        return users;
    }
    
    
    
    
    public Vector<Vector<Object>> getData() {
        Vector<Vector<Object>> datas = new Vector<>();
        
        datas = rapiMdl.tryDatas(token, method);
        
        return datas;
    }
    
    
    
    public void setData( String method) {
        
        
        this.method = method;
    }
    
    
    public Vector<Vector<Object>> getMeal() {
        Vector<Vector<Object>> meals = new Vector<>();
        
        meals = rapiMdl.tryMeals(token,  method);
        
        return meals;
    }
    public void setMeal( String method) {
        
        
        this.method = method;
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

package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Model.RapiModel;




public class LifeStyleTest {
	
	
private RapiModel rapiMdl;

@Test //Sikeres bejelentkez�s!
public void testLogin() {
    rapiMdl = new RapiModel();
    rapiMdl.tryLogin();
    
    Integer expected = 200;
    Integer actual = rapiMdl.loginResponseCode;
    
    assertEquals(expected, actual);
	
}
@Test //Sikertelen teszt
public void UserTest() {
	rapiMdl = new RapiModel();
	
	String token = "";
	rapiMdl.tryUsers(token);
	
	Integer expected = 500;
	Integer actual = rapiMdl.UserResponseCode;
	
	assertEquals(expected, actual);
}
@Test //Sikeres teszt
public void UserTest2() {
	rapiMdl = new RapiModel();
    
    String token = rapiMdl.tryLogin();
    rapiMdl.tryUsers(token);
    Integer expected = 200;
    Integer actual = rapiMdl.UserResponseCode;

    assertEquals(expected, actual);
}

@Test //Sikeres teszt
public void MealTest1() {
	rapiMdl = new RapiModel();
    
    String token = rapiMdl.tryLogin();
    rapiMdl.tryMeals(token);
    Integer expected = 200;
    Integer actual = rapiMdl.MealResponseCode;

    assertEquals(expected, actual);
}
@Test //Sikertelen teszt
public void MealTest2() {
	rapiMdl = new RapiModel();
	
	String token = "";
	rapiMdl.tryMeals(token);
	
	Integer expected = 500;
	Integer actual = rapiMdl.MealResponseCode;
	
	assertEquals(expected, actual);
}
@Test //Sikertelen teszt
public void DataTest1() {
	rapiMdl = new RapiModel();
	
	String token = "";
	rapiMdl.tryData(token);
	
	Integer expected = 500;
	Integer actual = rapiMdl.DataResponseCode;
	
	assertEquals(expected, actual);
}
@Test //Sikeres teszt
public void DataTest2() {
	rapiMdl = new RapiModel();
    
    String token = rapiMdl.tryLogin();
    rapiMdl.tryData(token);
    Integer expected = 200;
    Integer actual = rapiMdl.DataResponseCode;

    assertEquals(expected, actual);
}
@Test //Sikeres teszt
public void DeleteMealTest1() {
	rapiMdl = new RapiModel();
    
    String token = rapiMdl.tryLogin();
    rapiMdl.tryDeleteMeal(token, id);
    Integer expected = 200;
    Integer actual = rapiMdl.DeleteMealResponseCode;

    assertEquals(expected, actual);
}
@Test //Sikertelen teszt
public void DeleteMealTest2() {
	rapiMdl = new RapiModel();
	
	String token = "";
	rapiMdl.tryDeleteMeal(token,id);
	
	Integer expected = 500;
	Integer actual = rapiMdl.DeleteMealResponseCode;
	
	assertEquals(expected, actual);
}
@Test //Sikertelen teszt
public void DeleteUserTest1() {
	rapiMdl = new RapiModel();
	
	String token = "";
	rapiMdl.tryDeleteUser(token,id);
	
	Integer expected = 500;
	Integer actual = rapiMdl.DeleteUserResponseCode;
	
	assertEquals(expected, actual);
}
@Test //Sikeres teszt
public void DeleteUserTest2() {
	rapiMdl = new RapiModel();
    
    String token = rapiMdl.tryLogin();
    rapiMdl.tryDeleteUser(token, id);
    Integer expected = 200;
    Integer actual = rapiMdl.DeleteUserResponseCode;

    assertEquals(expected, actual);
}

@Test //Sikeres teszt 
public void LogoutTest1() {
	rapiMdl = new RapiModel();
    String token = "";
    rapiMdl.tryLogout(token);
    
    Integer expected = 500;
    Integer actual = rapiMdl.logoutResponseCode;
    
    assertEquals(expected, actual);
}

@Test //Sikertelen teszt! 
public void LogoutTest2() {
	rapiMdl = new RapiModel();
    String token = "";
    rapiMdl.tryLogout(token);
    
    Integer expected = 200;
    Integer actual = rapiMdl.logoutResponseCode;
    
    assertEquals(expected, actual);
}

@Test //Sikeres TEszt
public void LogoutTest3() {
	rapiMdl = new RapiModel();
    String token = rapiMdl.tryLogin();
    rapiMdl.tryLogout(token);
    
    Integer expected = 200;
    Integer actual = rapiMdl.logoutResponseCode;
    
    assertEquals(expected, actual);
}





}

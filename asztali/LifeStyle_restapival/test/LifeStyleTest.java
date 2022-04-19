package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Model.RapiModel;




public class LifeStyleTest {
	
	
private RapiModel rapiMdl;

@Test //Sikeres bejelentkezés!
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

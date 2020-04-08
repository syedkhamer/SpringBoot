package syed.khamer.myfirstwebappde.service;

//import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Loginservice {

	
	public boolean validateUser(String userid, String password) {
		return userid.equalsIgnoreCase("syed khamer")&&password.equalsIgnoreCase("12345");
	}
}

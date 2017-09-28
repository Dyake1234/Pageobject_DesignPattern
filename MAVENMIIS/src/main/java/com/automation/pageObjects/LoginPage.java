package com.automation.pageObjects;



import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.automation.base.BasepageClass;
import com.automation.pageRepository.LoginPageObjectRepository;

public class LoginPage extends BasepageClass<LoginPageObjectRepository>{
	
	
		public LoginPage(WebDriver driver) throws FileNotFoundException, IOException{
			
			super(driver, new LoginPageObjectRepository(driver));
		}


		public void LoginwithCredentials(String username, String Password){
		
			objectrepository.usertextbox.sendKeys(username);
			objectrepository.passtextfield.sendKeys(Password);
			objectrepository.Signbutton.click();

		}
		public void ClickForgotPasswordLink(){
			objectrepository.ForgotPassword.click();
			
		}
		
		
		public boolean verifyLogin(){
			
				/*	if(objectrepository.valuerequired.size()>0 || objectrepository.Prompt.size()>0){
				return false;
			}
			else*/
				return new DashboardPage(driver).isAt();

		}

}

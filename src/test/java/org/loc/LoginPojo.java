package org.loc;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPojo extends BaseClass{
	
	public LoginPojo() {		
		PageFactory.initElements(driver,this);	
	}
	
	@CacheLookup
	@FindBy(id="email")
	private WebElement txtEmail;
	
	@CacheLookup		
	@FindBys({		
		@FindBy(xpath="//input[@type='password']"),
		@FindBy(xpath="//input[@id='pass']")	    		
	})
	private WebElement txtPass;
	
	@CacheLookup
	@FindAll({		
		@FindBy(xpath="//button[@value='1']"),
		@FindBy(xpath="//button[@name='lin']")	    		
	})
	private WebElement loginBtn;
	

	
	public WebElement getTxtPass() {
		return txtPass;
	}


	public WebElement getLoginBtn() {
		return loginBtn;
	}


	public WebElement getTxtEmail() {
		return txtEmail;
	}
}
 



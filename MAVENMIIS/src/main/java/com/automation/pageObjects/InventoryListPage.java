package com.automation.pageObjects;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.base.BasepageClass;
import com.automation.pageRepository.InventoryListObjectRepository;

public class InventoryListPage extends BasepageClass<InventoryListObjectRepository>{
	
	public final String PAGEURL = "http://qa2-customer.igentechnologies.net/public/4220/3812/srn-admin/v/inventory/inventory-list";
	
	private static Logger Log = LogManager.getLogger(InventoryListPage.class.getName());
	
	public InventoryListPage(WebDriver driver){
		
		super(driver, new InventoryListObjectRepository(driver));
	}

	public void GotoPage(){
		
		driver.navigate().to(PAGEURL);
		Log.info("Navigated to InventoryListPage");
	
	}
	public void clickAddProductButton(String prodname) throws InterruptedException
	{
				objectrepository.AddButton.click();
				objectrepository.addsearchtextbox.sendKeys(prodname);
				IsElementPresent(objectrepository.timeout).until(ExpectedConditions.elementToBeClickable(objectrepository.searchedelement));
				click(objectrepository.selectbutton);
				Log.info("Add Product Successful");
	
	}
	public InventoryDetailsPage selectProduct(String prodname) throws InterruptedException{

		checkPageIsReady();
		IsElementPresent(objectrepository.timeout)
		.until(ExpectedConditions.invisibilityOf(objectrepository.loading));
		int number = objectrepository.paginate_button.size();
		String come = objectrepository.paginate_button.get(number-1).getText();
		int  wooh = Integer.parseInt(come);
		System.out.println(wooh);
		

		outerloop:
for(int q=0; q<=3;q++)
 
{
 
  try{
	  
 		for(int d = 0 ; d<wooh-1 ;d++)
			{
 			IsElementPresent(objectrepository.timeout)
 			.until(ExpectedConditions.invisibilityOf(objectrepository.loading));
				for(WebElement link :objectrepository.tablelinks)
				{	
					IsElementPresent(objectrepository.timeout).until(ExpectedConditions.visibilityOf(link));
		
					if(link.getText().contains(prodname)){
						link.click();
						Log.info("successfully selected product");
						break outerloop;	
					}
				}
				
				javascriptclick(objectrepository.NextButton);
			}
 	}
 
catch(StaleElementReferenceException e){}
}
				return new InventoryDetailsPage(driver);
	}
	
	public void addQuantity(String quantity)
	{
			objectrepository.restockquantityfield.sendKeys(quantity);
	}
	
	public void selectLocation(String location)
	{
		selectDropDown(location, objectrepository.restocklocationdropdown);
		Log.debug("Selected "+location+" as location");
		
	}


	
		
}
	


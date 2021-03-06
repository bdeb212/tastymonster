package com.tastymonster.automation.base;

/**
 * This class will encapsulate all the information WebDriver will need to know about the current test being run
 * @author mmerrell
 *
 */
public class WebDriverContext {
	
	private static IAutomationFacade driver;
	
	/**
	 * Returns the current instance of the WebDriver
	 * @return
	 */
	public static IAutomationFacade getDriver() {
		if ( driver == null ) {
			try {
				driver = new WebDriverFacade( DriverType.Firefox.driverClass.newInstance() );
				
				//TODO - This does not belong here--make it go away
				driver.setSiteRoot( "http://localhost:8080/patentmojo/" );
			} catch ( Exception e ) {
				throw new RuntimeException( "Error instantiating driver " + DriverType.Firefox.toString() );
			}
		}
		return driver;
	}
}

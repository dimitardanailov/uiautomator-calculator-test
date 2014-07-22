package testcases;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

/**
 * Create this automation test follow these tutorials:
 * - http://university.utest.com/android-ui-testing-uiautomatorviewer-and-uiautomator/
 * - http://www.tutorialspoint.com/android/android_ui_testing.htm
 * - https://www.youtube.com/watch?v=O1u8iBLUFL0
 * @author Dimitar Danailov
 */
public class CalculatorTest extends UiAutomatorTestCase {

	public void testingCalculator() throws UiObjectNotFoundException {
		// First we testing the press of the Home Button
		getUiDevice().pressHome();
		
		/*
		 * using the uiautomatorviewer tool we found that the button for the "applications" has
		 * the value "Apps"
		 * so we use this property to create a UiSelector to find the button.
		 */
		UiSelector applicationSelector = new UiSelector().description("Apps");
		UiObject applications = new UiObject(applicationSelector);
		
		// testing the click to bring up the All Apps screen.
		applications.clickAndWaitForNewWindow();
		
		/*
		 * In the Apps screen, the "Calculator" application is 
		 * located in Apps tab. So, we create a UiSelector to find a tab 
		 * with the text label "Apps".
		 */
		//UiSelector appsTextSelector = new UiSelector().text("Apps");
		//UiObject apps = new UiObject(appsTextSelector);
		
		/* 
		 * and the testing the click to this tab in
		 * order to enter the Apps tab.
		 */
		//apps.click();
		
		/*
		 * All the applications are in a scrollable list
		 * so first we need to get a reference to that list
		 */
		UiSelector uiSelector = new UiSelector().scrollable(true);
		UiScrollable ListOfApplications = new UiScrollable(uiSelector);
		
		/*
		 * and the trying to find the application
		 * with the name Calculator
		 */
		UiSelector childPattern = new UiSelector().className(android.widget.TextView.class.getName());
		UiObject calculator = ListOfApplications.getChildByText(childPattern , "Calculator");
		calculator.clickAndWaitForNewWindow();
		
		/* 
		 * now calculator application is open
		 * so we can test the press of button "7" using the ID "com.android.calculator2:id/digit7"
		 * we found by using uiautomatorviewer
		 */
		UiObject seven = new UiObject(new UiSelector().resourceId("com.android.calculator2:id/digit7"));
		seven.click();
		
		// now let's test "plus" button
		UiObject plus = new UiObject(new UiSelector().resourceId("com.android.calculator2:id/plus"));
		plus.click();
		
		// now let's test "1" button
		UiObject one = new UiObject(new UiSelector().resourceId("com.android.calculator2:id/digit1"));
		one.click();
		
		// now let's test "equal" button
		UiObject equalSign = new UiObject(new UiSelector().resourceId("com.android.calculator2:id/equal"));
		equalSign.click();
		
		//and finally we test the press of "Back" button
		//getUiDevice().pressBack();
	}
}

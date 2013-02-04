package com.vaadin.testbenchexample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vaadin.testbench.TestBench;
import com.vaadin.testbench.TestBenchTestCase;

/**
 * This case demonstrates usage of execution time reporting.
 */
public class VerifyExecutionTimeITCase extends TestBenchTestCase {

	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		setDriver(TestBench.createDriver(new FirefoxDriver()));
		baseUrl = "http://localhost:8080";
	}

	private void open() {
		getDriver().get(baseUrl + "/?restartApplication");
	}

	@Test
	public void verifyServerExecutionTime() throws Exception {
		open();
		long currentSessionTime = testBench(getDriver())
				.totalTimeSpentServicingRequests();
		
		for(int i =0 ; i < 1; i++) {
			getDriver().findElement(By.id("getmore")).click();
		}

		long timeSpentByServerForSimpleCalculation = testBench()
				.totalTimeSpentServicingRequests() - currentSessionTime;

		System.out.println();
		System.out.println("*** SIMPLE PERFORMANCE METRICS FOR V6 APP ***");
		System.out.println("Server:  " + timeSpentByServerForSimpleCalculation
				+ "ms in servlets service method.");
		long totalTimeSpentRendering = testBench().totalTimeSpentRendering();
		System.out.println("Client:  " + totalTimeSpentRendering
				+ "ms spent by browser to handle responses on client side.");

	}

	@After
	public void tearDown() throws Exception {
		getDriver().quit();
	}

}

package com.vaadin.testbenchexample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
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

	private void openCalculator() {
		getDriver().get(baseUrl + "/?restartApplication");
	}

	private void calculateOnePlusTwo() {
		getDriver().findElement(By.id("button_1")).click();
		getDriver().findElement(By.id("button_+")).click();
		getDriver().findElement(By.id("button_2")).click();
		getDriver().findElement(By.id("button_=")).click();
	}

	/**
	 * Makes the same thing as in {@link #testOnePlusTwoWithIdentifiers()} and
	 * verifies server don't spend too much time during the process. Also the
	 * test makes sure the time spent by browser to render the UI within sane
	 * limits.
	 * 
	 * @throws Exception
	 */
	@Test
	public void verifyServerExecutionTime() throws Exception {
		System.out.println("Calculating 10 times 100 times 1+2...");
		
		for (int j = 0; j < 10; j++) {

			openCalculator();
			long currentSessionTime = testBench(getDriver())
					.totalTimeSpentServicingRequests();
			for (int i = 0; i < 100; i++) {
				calculateOnePlusTwo();
			}

			long timeSpentByServerForSimpleCalculation = testBench()
					.totalTimeSpentServicingRequests() - currentSessionTime;

			System.out.println();
			System.out.println("*** SIMPLE PERFORMANCE METRICS FOR V7 APP ***");
			System.out.println("Round " + j + " of 10");
			System.out.println("Server:  "
					+ timeSpentByServerForSimpleCalculation
					+ "ms in servlets service method.");
			long totalTimeSpentRendering = testBench()
					.totalTimeSpentRendering();
			System.out
					.println("Client:  "
							+ totalTimeSpentRendering
							+ "ms spent by browser to handle responses on client side.");

		}

	}

	@After
	public void tearDown() throws Exception {
		getDriver().quit();
	}

}

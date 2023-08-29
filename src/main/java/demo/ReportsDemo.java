package demo;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import constants.FileConstants;

public class ReportsDemo {

	public static void main(String[] args) {

		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(new File(FileConstants.REPORT_PATH));
		extent.attachReporter(spark);
		ExtentTest test;

		test = extent.createTest("TC01");

		test.log(Status.PASS, "");

		test.info("Password is entered");
		test.info("login button clicked");
		test.pass("TC01 PASSED");

		test = extent.createTest("TC02");

		test.info("Password is entered");
		test.info("login button clicked");
		test.fail("TC02 PASSED");
		extent.flush();

	}

}

package listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Media;

import tests.BaseTest;
import utils.CommonUtils;

public class SFDCListeners extends BaseTest implements ITestListener {
	
	
	public void onTestStart(ITestResult res) {
		BaseTest.test = extent.createTest(res.getName());
		BaseTest.threadExtentTest.set(BaseTest.test);
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		BaseTest.threadExtentTest.get().pass(MarkupHelper.createLabel(result.getName()+ " PASSED", ExtentColor.GREEN));
		
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		BaseTest.threadExtentTest.get().fail(MarkupHelper.createLabel(result.getName() + " FAILED", ExtentColor.RED));
		try {
			BaseTest.threadExtentTest.get().addScreenCaptureFromPath(CommonUtils.getScreenshot(BaseTest.getDriver()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

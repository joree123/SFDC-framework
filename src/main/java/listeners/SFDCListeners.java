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
//		BaseTest.test = extent.createTest(res.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
//		BaseTest.test.pass(MarkupHelper.createLabel(result.getName()+ " PASSED", ExtentColor.GREEN));
		
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
//		BaseTest.test.fail(MarkupHelper.createLabel(result.getName() + " FAILED", ExtentColor.RED));
//		try {
//			BaseTest.test.addScreenCaptureFromPath(CommonUtils.getScreenshot(BaseTest.getDriver()));
//		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}

package mail.gmail;

import java.io.IOException;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	}
	
	@Override          
	public void onTestFailure(ITestResult result) {
		String methodName = result.getName().toString().trim();
		try {
			testUtil.captureScreenshot(methodName);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void onFinish(ITestContext context) {
		testUtil.zip(System.getProperty("user.dir")+"\\screenshot");
		monitoringMail mail = new monitoringMail();
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

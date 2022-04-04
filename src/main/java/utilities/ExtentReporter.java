package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	static ExtentReports extent;
	
	public static ExtentReports extentReport() {
		
		  String extentReportPath = System.getProperty("user.dir")+"\\Reports\\extentReports.html";
		  ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
		  
		  reporter.config().setReportName("Ninja Test Report");
		  reporter.config().setDocumentTitle("Ninja commerce Report");
		  
		  
		  extent = new ExtentReports();
		  extent.attachReporter(reporter);
		  extent.setSystemInfo("Created By", "Sourabh");
		  
		  return extent;
		  
	}

}

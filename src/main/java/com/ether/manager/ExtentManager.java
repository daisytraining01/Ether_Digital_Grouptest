package com.ether.manager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static ExtentReports extent;
	// private static Platform platform;
	private static String reportFileName = "Test-Automaton-Report.html";

	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();
		return extent;
	}

	// Create an extent report instance
	public static ExtentReports createInstance() {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/" + reportFileName);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle(System.getProperty("user.dir") + "/" + reportFileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(System.getProperty("user.dir") + "/" + reportFileName);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		return extent;
	}

}
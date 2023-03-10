package com.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// dryRun : true - will not execute, just check that every scenario should have step definition
// if false - will execute script......

@CucumberOptions(features = "src/test/resources/Features", 
										glue = {"com.iris22a.stepdefination","com.iris22a.config"},
										dryRun = false)
public class RunnerTest extends AbstractTestNGCucumberTests{
		
	@DataProvider(parallel = true)
	@Override
		public Object[][] scenarios() {
			return super.scenarios();
		}
	
}



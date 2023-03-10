package com.iris22a.stepdefination;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Parameterization {

	int x,y,r=0;
	String countryName;
	
	/*
	@Given("Two numbers {int} & {int}")
	public void acceptNumbers(int x, int y) {
		this.x=x;
		this.y=y;
	}
	*/

	@When("Addition")
	public void addition() {
		this.r=x+y;
	}
	
	@Then("Print result")
	public void displayResult() {
		System.out.println("Result: "+r);
	}
	
	@Given("Country is {string}")
	public void acceptCountry(String country) {
		countryName = country;
	}
	
	@Then("Display the capital")
	public void displayCapital() {
		System.out.println(countryName+"'s capital is Paris");
	}

/*	
	@Given("given <states>")
	public void accetStates(List<String>states) {
		System.out.println("========STATES========");
		for (String state : states) {
			System.out.println(state);
		}
	}
*/

/*	
// Integer can also be used in 2nd parameter instead of string	
	@Given("given <states>")
	public void accetStates(Map<String,String>states) {
		System.out.println("========STATES========");
		Set<Entry<String, String>>keys = states.entrySet();
		for (Entry key : keys) {
			System.out.println(key.getKey()+"\t"+key.getValue());
		}
	}
*/	
	
	@Given("given <states>")
	public void accetStates(DataTable states) {
		System.out.println("========STATES========");
		
		Map<String, List>stateDetails = states.asMap(String.class,List.class);
		
		Set<Map.Entry<String, List>>entries = stateDetails.entrySet();
		for (Entry<String, List> entry : entries) {
			List<String>data = entry.getValue();
			System.out.println(entry.getKey()+"\t"+data.get(0)+"\t"+data.get(1));
		}
	}
	
	//@Then("Display state names")
	private void displayState() {

	}

	@Given("given {int} & {int} numbers")
	public void acceptNumbers(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	@Then("print if their addition is prime")
	public void isPrime() {
		System.out.println("Checking: "+r);
		int count = 0;
		for (int i = 1; i < r; i++) {
			if (r%i==0) {
				count++;
			}
			if (count>2) {
				break;
			}
		}
		if (count<=2) {
			System.out.println("Number "+r+" is Prime");
		}
		else {
			System.out.println("Number "+r+" is Not Prime");
		}
	}
	
	@Given("I have {int}")
	public void getRowNumber(int rowNum) {
		FileInputStream fis=null;
		try {
			 fis = new FileInputStream("C:\\Users\\91758\\Desktop\\Files\\Cucu data.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		XSSFWorkbook book = null;
		try {
			 book = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = book.getSheetAt(0);
		Row row = sheet.getRow(rowNum);
			Cell cell = row.getCell(1);
			x = (int) cell.getNumericCellValue();
			cell = row.getCell(2);
			y = (int) cell.getNumericCellValue();
		}
}	



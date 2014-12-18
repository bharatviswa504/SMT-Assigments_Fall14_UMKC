package com.objectsbydesign.calc.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.*;

public class DecimalValueTest {
	
	private BigDecimal value;
	private DecimalValue d;

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		value = null;
		d = null;
	}

	
	//Testing DecimalValue constructor taking input BigDecimalValue
	@Test
	public void testDecimalValueBigDecimal() {
		
		try {
		value = new BigDecimal(0);
		d = new DecimalValue(value);
		assertNotNull(d);
		assertEquals(value,d.value);
		
		value = new BigDecimal(10);
		d = new DecimalValue(value);
		assertNotNull(d);
		assertEquals(value,d.value);
		
		value = new BigDecimal(10.0);
		d = new DecimalValue(value);
		assertNotNull(d);
		assertEquals(value,d.value);
		
		value = new BigDecimal(0.0);
		d = new DecimalValue(value);
		assertEquals(value,d.value);
		
		value = new BigDecimal(-2.0);
		d = new DecimalValue(value);
		assertEquals(value,d.value);
		
		
		}
		catch(Exception e) {
			e.getMessage();	
			fail("test case failed");
		}
		
	}
	
	//Testing constructor taking double
	
	@Test
	public void testDecimalValueDouble() {
		
		try {
		
		double value1 = 100.00; //100.12
	    value = new BigDecimal(value1);
		value.setScale(10,BigDecimal.ROUND_UP);
		d = new DecimalValue(value1);
		assertNotNull(d);
		assertEquals(value.doubleValue(),d.value);
		
		
		value1 = 10.00;
		value = new BigDecimal(value1);
		value.setScale(10, BigDecimal.ROUND_UP);
	    d = new DecimalValue(value1);
	    assertNotNull(d);
		assertEquals(value.doubleValue(),d.value);
		}
		catch(Exception e) {
			e.getMessage();
		}
		
	}
	
	
	//Testing constructor taking string
	@Test
	public void testDecimalValueString() {
		
		try{
		String str ="100.0";
		value = new BigDecimal(str);
		d = new DecimalValue(str);
		assertNotNull(d);
		assertEquals(value,d.value);
		
		str ="10";
		value = new BigDecimal(str);
		d = new DecimalValue(str);
		assertNotNull(d);
		assertEquals(value,d.value);
		}
		catch(Exception e) {
			e.getMessage();
		}
		
		
		try {
		String str="bharat";
		d = new DecimalValue(str);
		assertNotNull(d);
		fail("Test case failed");
		}
		catch(NumberFormatException e){
			e.getMessage();
		}
		
	}
	
	@Test
	public void testDivide(){
			
		try{
		
		Value v = new DecimalValue("5");
		d = new DecimalValue("10");
		DecimalValue result = (DecimalValue) d.divide(v);
		BigDecimal b1 = new BigDecimal("2.0000000000");
		assertEquals(b1,result.value);
		// Actually in the case of normal double sending that time truncation issue coming
		// same issue happening in constrcutor taking double parameter.
//		assertEquals(b1,result.value.setScale(0,BigDecimal.ROUND_UP));
		
		v = new DecimalValue(new BigDecimal(2));
		d = new DecimalValue(new BigDecimal(1));
		result = (DecimalValue) d.divide(v);
		b1 = new BigDecimal("0.5000000000");
		assertEquals(b1,result.value);
		
		v = new DecimalValue("0");
		d.divide(v);
		fail("Exception should be thrown");
		
		}
		catch(Exception e){
			e.getMessage();
		}
	
		
	}
	
	@Test
	public void testaddDigit() {
		try {
		d = new DecimalValue(10);
		assertEquals("0",d.addDigit("0", "0"));
		assertEquals("3.26",d.addDigit("3.2", "6"));
		assertEquals("2.00",d.addDigit("2.0","0"));
		assertEquals("8",d.addDigit("0","8")); 
		assertEquals("2.2",d.addDigit("2.2", "."));
		}
		catch(Exception e){
			e.getMessage();
		}
	}
	
	@Test
	public void testtoString() {
		try {
		d = new DecimalValue("10");
		assertEquals("10.",d.toString());
		d = new DecimalValue("3.2");
		assertEquals("3.2",d.toString());
		d = new DecimalValue("10.00");
		assertEquals("10.",d.toString());
		}
		catch(Exception e){
			e.getMessage();
		}
		
	}
	

}

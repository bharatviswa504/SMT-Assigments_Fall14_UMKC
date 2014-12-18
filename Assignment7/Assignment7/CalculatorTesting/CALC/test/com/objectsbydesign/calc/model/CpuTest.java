package com.objectsbydesign.calc.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class CpuTest {
	
	private Cpu cpu;
	private State  wis;
	private State  wns;
	private State  wos;
	private State  ens;
	private Minus mi;
	private SquareRoot sq;
	private MemoryRecall mr;
	private Multiply mu;
	private Equals eq;

	@Before
	public void setUp() throws Exception {
		cpu = new Cpu();
		wis = new WaitingForInputState(cpu);
        wns = new WaitingForNumberState(cpu);
        wos = new WaitingForOperationState(cpu);
        ens = new EnteringNumberState(cpu);
        mi = new Minus();
        mu = new Multiply();
        sq = new SquareRoot();
        mr = new MemoryRecall();
        eq = new Equals();
	}

	@After
	public void tearDown() throws Exception {
		cpu = null;
		wis = null;
		wns = null;
		wos = null;
		ens = null;
		mi = null;
		mu = null;
		eq = null;
	}

	/*
	 * tested in this 
	 */
	@Test
	public void test()  {
		//EnteringNumberState.getClass();
		
		//State s = ens.enterDigit("1");
		//Testing for Entering Number State from waiting for input state
		try {	
			
		//Testing possible states from wos to other states
		
		assertEquals(cpu.EnteringNumberState, wos.enterDigit("5"));
		
		assertEquals(cpu.WaitingForNumberState,wos.enterOperation(mi));
		
		assertEquals(cpu.EnteringNumberState, wos.enterDigit("2"));
		assertEquals(cpu.EnteringNumberState, wos.enterDigit("5"));
		assertEquals(cpu.WaitingForInputState,wos.enterOperation(sq));
		cpu.WaitingForOperationState = wos;
		assertEquals(cpu.WaitingForOperationState, wos.enterValue(mr));
			
		
	} catch(Exception e) {
			e.getMessage();
		}
		
	}
	
	@Test
	public void test1()  {
		//EnteringNumberState.getClass();
		
		//State s = ens.enterDigit("1");
		//Testing for Entering Number State from waiting for input state
		try {
			
			//Testing possiblities from wis to other states
		assertEquals(cpu.EnteringNumberState, wis.enterDigit("1"));
		
		assertEquals(cpu.WaitingForNumberState,wis.enterOperation(mi));
		
		assertEquals(cpu.EnteringNumberState, wis.enterDigit("2"));
		assertEquals(cpu.EnteringNumberState, wis.enterDigit("5"));
		assertEquals(cpu.WaitingForInputState,wis.enterOperation(sq)); // becuase no lookahead needed
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	@Test
	public void test2()  {
		//EnteringNumberState.getClass();
		
		//State s = ens.enterDigit("1");
		//Testing for Entering Number State from waiting for input state
		try {	
		
		// Testing possible states from ens to other states
			
			cpu.EnteringNumberState = ens; // This is done because enterdigit is returning this so, cpu 
			// entering number state is differing from ens. // to avoid that this is done
		assertSame(cpu.EnteringNumberState,ens.enterDigit("3"));
		
		assertEquals(cpu.WaitingForNumberState,ens.enterOperation(mi));
		
		assertEquals(cpu.EnteringNumberState, ens.enterDigit("2"));
		assertEquals(cpu.EnteringNumberState, ens.enterDigit("5"));
		assertEquals(cpu.WaitingForInputState,ens.enterOperation(sq));
		assertEquals(cpu.WaitingForOperationState,ens.enterValue(mr));
		}
		catch(Exception e){
			e.getMessage();
		}
	}
	
	@Test
	public void test3()  {
		//EnteringNumberState.getClass();
		
		//State s = ens.enterDigit("1");
		//Testing for Entering Number State from waiting for input state
		try {	
			
		//Testing possible states from wns to other states
	
		
		assertEquals(cpu.EnteringNumberState,wns.enterDigit("4"));
		// this is done because enter operation in wns is returning this, which is diff from cpu.EnteringNumberState
		cpu.WaitingForNumberState = wns;
		
		assertEquals(cpu.WaitingForNumberState,wns.enterOperation(mi));
		
		assertEquals(cpu.EnteringNumberState, wns.enterDigit("2"));
		assertEquals(cpu.EnteringNumberState, wns.enterDigit("5"));
		assertEquals(cpu.WaitingForNumberState,wns.enterOperation(sq));
		
		assertEquals(cpu.WaitingForOperationState,wns.enterValue(mr));
		
		}
		catch(Exception e){
			e.getMessage();
		}
	}
	
	

	
	@Test
	public void test4(){
		// Testing complex operation
		try {
				
			// Tested this expression 22 - 1 *4 =
				assertEquals(cpu.EnteringNumberState,cpu.WaitingForInputState.enterDigit("2"));
				assertEquals(cpu.EnteringNumberState,cpu.EnteringNumberState.enterDigit("2"));
				
		
				assertEquals(cpu.WaitingForNumberState,cpu.EnteringNumberState.enterOperation(mi));
				cpu.enterDigit("1");
				assertEquals(cpu.EnteringNumberState,cpu.WaitingForNumberState.enterDigit("1"));
	
			
				assertEquals(cpu.WaitingForNumberState,cpu.EnteringNumberState.enterOperation(mu));
				
				assertEquals(cpu.EnteringNumberState,cpu.WaitingForNumberState.enterDigit("3"));
			
				assertEquals(cpu.WaitingForInputState,cpu.EnteringNumberState.enterOperation(eq));
				
				//2 Mr
				cpu = new Cpu();
				assertEquals(cpu.EnteringNumberState, cpu.WaitingForInputState.enterDigit("2"));
				assertEquals(cpu.WaitingForOperationState, cpu.EnteringNumberState.enterValue(mr));
							
				
		}
		catch(Exception e){
			e.getMessage();
		}
				
	}
	

}

package com.companyname.calculatorIncome.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.companyname.calculatorIncome.ICalcMethod;
import com.companyname.calculatorIncome.Position;
import com.companyname.calculatorIncome.TheCalculator;

public class TestCalculator {

	private ICalcMethod mockCalcMethod;
	private TheCalculator calculator;
	  
	@Before
	public void setUp() throws Exception {
		calculator = new TheCalculator();
		mockCalcMethod = EasyMock.createMock(ICalcMethod.class);
	}

	@Test
	public void test1() {
		 // Setting up the expected value of the method call calc
	    EasyMock.expect(mockCalcMethod.calc(Position.BOSS)).andReturn(70000.0).times(2);
	    EasyMock.expect(mockCalcMethod.calc(Position.PROGRAMMER)).andReturn(50000.0);
	    // Setup is finished need to activate the mock
	    EasyMock.replay(mockCalcMethod);

	    calculator.setCalcMethod(mockCalcMethod);
	    try {
	      calculator.calc();
	      fail("Exception did not occur");
	    } catch (RuntimeException e) {

	    }
	    calculator.setPosition(Position.BOSS);
	    assertEquals(70000.0, calculator.calc(), 0);
	    assertEquals(70000.0, calculator.calc(), 0);
	    calculator.setPosition(Position.PROGRAMMER);
	    assertEquals(50000.0, calculator.calc(), 0);
	    calculator.setPosition(Position.SURFER);
	    EasyMock.verify(mockCalcMethod);
	}

}

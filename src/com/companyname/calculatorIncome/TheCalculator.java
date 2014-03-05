package com.companyname.calculatorIncome;

public class TheCalculator {

	private ICalcMethod calcMethod;
	private Position position;
	
	public ICalcMethod getCalcMethod() {
		return calcMethod;
	}
	public void setCalcMethod(ICalcMethod calcMethod) {
		this.calcMethod = calcMethod;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public double calc() {
		if (calcMethod == null) {
            throw new RuntimeException("CalcMethod not yet maintained");
        }
        if (position == null) {
            throw new RuntimeException("Position not yet maintained");
        }
        return calcMethod.calc(position);
	}
	
}

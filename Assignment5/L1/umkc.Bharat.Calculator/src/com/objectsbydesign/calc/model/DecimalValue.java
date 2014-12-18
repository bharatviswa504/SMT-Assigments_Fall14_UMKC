package com.objectsbydesign.calc.model;
import java.math.*;



public class DecimalValue implements IDecimalValueImp, Value
{
	private DecimalValueArch _arch;
	
	protected BigDecimal value;
    private static BigDecimal one;
    private static BigDecimal hundred;

    private static final int SCALE = 10;

    static {
        one = new BigDecimal ( 1.0 );
        hundred = new BigDecimal ( 100.0 );
    }

    public DecimalValue ( String string ) {
        this.value = new BigDecimal ( string );
    }

    public DecimalValue ( BigDecimal value ) {
        this.value = value;
    }

    public DecimalValue ( double value ) {
        this.value = new BigDecimal ( value );
        this.value = this.value.setScale(SCALE, BigDecimal.ROUND_UP);
    }


    public DecimalValue (){
    	this.value = new BigDecimal (0);
    }

	public void setArch(DecimalValueArch arch){
		_arch = arch;
	}
	public DecimalValueArch getArch(){
		return _arch;
	}

	/*
  	  Myx Lifecycle Methods: these methods are called automatically by the framework
  	  as the bricks are created, attached, detached, and destroyed respectively.
	*/	
	public void init(){
	    //TODO Auto-generated method stub
	}
	public void begin(){
		//TODO Auto-generated method stub
	}
	public void end(){
		//TODO Auto-generated method stub
	}
	public void destroy(){
		//TODO Auto-generated method stub
	}

	@Override
	public Value create(String string) {
		// TODO Auto-generated method stub
		return new DecimalValue(string);
	}

	@Override
	public Value add(Value other) {
		// TODO Auto-generated method stub
		BigDecimal result = value.add(((DecimalValue)other).value);
        return new DecimalValue(result);
	}

	@Override
	public Value subtract(Value other) {
		// TODO Auto-generated method stub
		BigDecimal result = value.subtract(((DecimalValue)other).value);
        return new DecimalValue(result);
	}

	@Override
	public Value multiply(Value other) {
		// TODO Auto-generated method stub
		BigDecimal result = value.multiply(((DecimalValue)other).value);
        result = result.setScale(SCALE, BigDecimal.ROUND_UP);
        return new DecimalValue(result);
	}

	@Override
	public Value divide(Value other) {
		// TODO Auto-generated method stub
		BigDecimal result = null;
        try {
            result = value.divide(((DecimalValue)other).value,
                            SCALE, BigDecimal.ROUND_UP);
        } catch (ArithmeticException e) {
            // in case of divide by zero,
            // report the error and leave the current value  \
            System.err.println("Arithmetic Error");
            return this;
        }
        return  new DecimalValue(result);
	}

	@Override
	public Value negate() {
		// TODO Auto-generated method stub
		 return new DecimalValue(value.negate());
    }

	@Override
	public Value squareRoot() {
		// TODO Auto-generated method stub
		double result = value.doubleValue();
        result = Math.sqrt(result);
        return new DecimalValue(result);
	}

	@Override
	public Value inverse() {
		// TODO Auto-generated method stub
		 BigDecimal result = null;
	        try {
	            result = one.divide(value, SCALE, BigDecimal.ROUND_UP);
	        } catch (ArithmeticException e) {
	            // in case of divide by zero,
	            // report the error and leave the current value  \
	            System.err.println("Arithmetic Error");
	            return this;
	        }
	        return new DecimalValue(result);
	    }

	@Override
	public Value percent() {
		// TODO Auto-generated method stub
		 BigDecimal result = value.divide(hundred, SCALE, BigDecimal.ROUND_UP);
	        return new DecimalValue(result);
	 }

	@Override
	public String addDigit(String number, String digit) {
		// TODO Auto-generated method stub
		 // see if the decimal point is already set
        boolean decimalSet = (number.indexOf(".") == -1) ? false : true;

        // check for extra decimal points
        if (digit.equals(".")) {
            if (decimalSet)
                return number;
        }

        // check for leading zeros
        if (!decimalSet && number.equals("0")) {
            // only one zero allowed
            if (digit.equals("0"))
                return number;
            // trim leading zero
            else
                number = "";
        }

        // append digit to number
        return number + digit;
    }

	public String toString () {
        String  s = value.toString();
        int i;

        if (s.indexOf('.') != -1) {
            for (i = s.length(); i > 0; i--) {
                if (s.charAt(i-1) != '0')
                    break;
            }
            s = s.substring(0, i);
        }
        else
            s += ".";

        return s;
    }
	/*
  	  Implementation primitives required by the architecture
	*/
}
/**
    Object-Oriented Calculator

    Copyright (C) 1999-2002, Objects by Design, Inc. All Rights Reserved.

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation. A copy of the license may be found at
    http://www.objectsbydesign.com/projects/gpl.txt
 */

package com.objectsbydesign.calc.model;

import java.math.BigDecimal;

public class DecimalValue implements Value {
    protected BigDecimal value;
    private static BigDecimal one;
    private static BigDecimal hundred;

    private static final int SCALE = 10;

    static {
        one = new BigDecimal ( 1.0 );
        hundred = new BigDecimal ( 100.0 );
    }

    // Construct 1
    public DecimalValue ( String string ) {
        this.value = new BigDecimal ( string );
    }

    // Constructor 2
    public DecimalValue ( BigDecimal value ) {
        this.value = value;
    }

    // Constructor 3
    public DecimalValue ( double value ) {
        this.value = new BigDecimal ( value );
        this.value = this.value.setScale(SCALE, BigDecimal.ROUND_UP);
    }

    public Value create ( String string ) {
        return new DecimalValue(string);
    }

    public Value add(Value other) {
        BigDecimal result = value.add(((DecimalValue)other).value);
        return new DecimalValue(result);
    }

    public Value subtract(Value other) {
        BigDecimal result = value.subtract(((DecimalValue)other).value);
        return new DecimalValue(result);
    }

    public Value multiply(Value other) {
        BigDecimal result = value.multiply(((DecimalValue)other).value);
        result = result.setScale(SCALE, BigDecimal.ROUND_UP);
        return new DecimalValue(result);
    }

    // If divide by zero, exception should be thrown.
    public Value divide(Value other) throws ArithmeticException{
        BigDecimal result = null;
        result = value.divide(((DecimalValue)other).value,
                            SCALE, BigDecimal.ROUND_UP);
        return  new DecimalValue(result);
    }

    public Value squareRoot() {
        double result = value.doubleValue();
        result = Math.sqrt(result);
        return new DecimalValue(result);
    }

    public Value inverse() {
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

    public Value negate() {
        return new DecimalValue(value.negate());
    }

    public Value percent() {
        BigDecimal result = value.divide(hundred, SCALE, BigDecimal.ROUND_UP);
        return new DecimalValue(result);
    }

    /*This method links the digits that are entered consecutively as a string representing a single number.
     *  If there are leading zeros, they should be removed.
    */
    public String addDigit ( String number, String digit ) {

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
                number = "0";
        }

        // append digit to number
        return number + digit;
    }

    /* Convert the current value to a String object.
     * If the value is an integer (e.g. 2), the output string should be "2."
     * If the value is a decimal value (e.g. 3.2), the output string should be itself "3.2".
    */
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

}

package com.objectsbydesign.calc.model;


import com.objectsbydesign.calc.model.DecimalValueArch;

public interface IDecimalValueImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (DecimalValueArch arch);
	public DecimalValueArch getArch();
	
	/*
  	  Myx Lifecycle Methods: these methods are called automatically by the framework
  	  as the bricks are created, attached, detached, and destroyed respectively.
	*/	
	public void init();	
	public void begin();
	public void end();
	public void destroy();

	/*
  	  Implementation primitives required by the architecture
	*/
  
    
    public Value create (String string)  ;        
    public Value add (Value other)  ;        
    public Value subtract (Value other)  ;        
    public Value multiply (Value other)  ;        
    public Value divide (Value other)  ;        
    public Value negate ()  ;        
    public Value squareRoot ()  ;        
    public Value inverse ()  ;        
    public Value percent ()  ;        
    public String addDigit (String number,String digit)  ;        
}
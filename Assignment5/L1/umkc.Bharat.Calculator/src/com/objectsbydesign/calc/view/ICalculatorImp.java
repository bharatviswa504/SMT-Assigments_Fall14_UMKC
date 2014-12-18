package com.objectsbydesign.calc.view;


import com.objectsbydesign.calc.view.CalculatorArch;

public interface ICalculatorImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (CalculatorArch arch);
	public CalculatorArch getArch();
	
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
}
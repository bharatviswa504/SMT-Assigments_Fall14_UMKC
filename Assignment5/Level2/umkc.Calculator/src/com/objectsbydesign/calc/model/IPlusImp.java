package com.objectsbydesign.calc.model;


import com.objectsbydesign.calc.model.PlusArch;

public interface IPlusImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (PlusArch arch);
	public PlusArch getArch();
	
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
  
    
    public Value executeBinary (Value value1,Value value2)  ;        
}
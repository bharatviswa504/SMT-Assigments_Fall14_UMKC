package com.objectsbydesign.calc.model;


import com.objectsbydesign.calc.model.CommandArch;

public interface ICommandImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (CommandArch arch);
	public CommandArch getArch();
	
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
  
    
    public void execute (Cpu cpu)  ;        
    public void display ()  ;        
    public void setOp (Operation op)  ;        
}
package com.cpu;


import com.cpu.CpuArch;
import com.objectsbydesign.calc.model.*;

public interface ICentralProcessingUnitImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (CpuArch arch);
	public CpuArch getArch();
	
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
  
    
    public Cpu create ()  ;        
}
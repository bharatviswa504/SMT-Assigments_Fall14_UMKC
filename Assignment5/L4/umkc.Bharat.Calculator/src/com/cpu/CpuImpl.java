package com.cpu;
import com.objectsbydesign.calc.model.Cpu;



public class CpuImpl implements ICentralProcessingUnitImp
{
	private CpuArch _arch;

    public CpuImpl (){
    }

	public void setArch(CpuArch arch){
		_arch = arch;
	}
	public CpuArch getArch(){
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

	/*
  	  Implementation primitives required by the architecture
	*/
  
    
    public Cpu create ()   {
		//TODO Auto-generated method stub
		return new Cpu();
    }
}
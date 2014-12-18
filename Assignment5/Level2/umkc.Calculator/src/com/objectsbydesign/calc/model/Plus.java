package com.objectsbydesign.calc.model;



public class Plus extends BinaryOperation implements IPlusImp
{
	private PlusArch _arch;

    public Plus (){
    	symbol ="+";
    	precedence = LOW;
    }

	public void setArch(PlusArch arch){
		_arch = arch;
	}
	public PlusArch getArch(){
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
  
    
    public Value executeBinary (Value value1,Value value2)   {
		//TODO Auto-generated method stub
    	System.out.println("Bharat Add");
    	return value1.add(value2);
    }
}
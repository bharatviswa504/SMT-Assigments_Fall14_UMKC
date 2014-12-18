package com.objectsbydesign.calc.view;



public class CalcFrameImpl implements ICalculatorFrameImp
{
	private CalcFrameArch _arch;

    public CalcFrameImpl (){
    }

	public void setArch(CalcFrameArch arch){
		_arch = arch;
	}
	public CalcFrameArch getArch(){
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
  
    
    public CalculatorFrame create ()   {
		//TODO Auto-generated method stub
    	System.out.println("Bharat creating calculatorFrame");
		return new CalculatorFrame();
    }
}
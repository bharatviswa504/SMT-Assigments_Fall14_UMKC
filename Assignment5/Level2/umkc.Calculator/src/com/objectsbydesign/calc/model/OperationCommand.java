package com.objectsbydesign.calc.model;



public class OperationCommand implements ICommandImp
{
	private CommandArch _arch;
	Operation op;

    public OperationCommand (){
    }
    
    public OperationCommand(Operation op) {
        this.op = op;
    }

	public void setArch(CommandArch arch){
		_arch = arch;
	}
	public CommandArch getArch(){
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
  
    
    public void execute (Cpu cpu)   {
		//TODO Auto-generated method stub
        cpu.pushOperation(op);
		
    }
    public void display ()   {
		//TODO Auto-generated method stub
    	System.out.println(op.toString());
    }
    public void setOp (Operation op)   {
		//TODO Auto-generated method stub
    	System.out.println("Bharat added");
		this.op = op;
    }
}
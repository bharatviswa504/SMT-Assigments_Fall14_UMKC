package com.objectsbydesign.calc.model;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

public class OperationCommandArch extends AbstractMyxSimpleBrick implements Command
{
    public static final IMyxName msg_Command = MyxUtils.createName("com.objectsbydesign.calc.model.Command");


	private IOperationCommandImp _imp;

    public OperationCommandArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IOperationCommandImp getImplementation(){
        try{
			return new OperationCommand();    
        } catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public void init(){
        _imp.init();
    }
    
    public void begin(){
        _imp.begin();
    }
    
    public void end(){
        _imp.end();
    }
    
    public void destroy(){
        _imp.destroy();
    }
    
	public Object getServiceObject(IMyxName arg0) {
		if (arg0.equals(msg_Command)){
			return this;
		}        
		return null;
	}
  
    
    public void execute (Cpu cpu)   {
		_imp.execute(cpu);
    }    
    public void display ()   {
		_imp.display();
    }    
    public void setOp (Operation op)   {
		_imp.setOp(op);
    }    
}
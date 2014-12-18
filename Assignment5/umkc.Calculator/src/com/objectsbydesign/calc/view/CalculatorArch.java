package com.objectsbydesign.calc.view;


import com.objectsbydesign.calc.model.Command;

import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

public class CalculatorArch extends AbstractMyxSimpleBrick
{
    public static final IMyxName msg_Command = MyxUtils.createName("com.objectsbydesign.calc.model.Command");

    public Command OUT_Command;

	private ICalculatorImp _imp;

    public CalculatorArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected ICalculatorImp getImplementation(){
        try{
			return new Calculator();    
        } catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public void init(){
        _imp.init();
    }
    
    public void begin(){
        OUT_Command = (Command) MyxUtils.getFirstRequiredServiceObject(this,msg_Command);
        if (OUT_Command == null){
 			System.err.println("Error: Interface com.objectsbydesign.calc.model.Command returned null");
			return;       
        }
        _imp.begin();
    }
    
    public void end(){
        _imp.end();
    }
    
    public void destroy(){
        _imp.destroy();
    }
    
	public Object getServiceObject(IMyxName arg0) {
		return null;
	}
}
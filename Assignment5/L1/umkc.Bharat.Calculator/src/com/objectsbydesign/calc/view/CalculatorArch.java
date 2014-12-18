package com.objectsbydesign.calc.view;


import com.objectsbydesign.calc.model.Value;

import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

public class CalculatorArch extends AbstractMyxSimpleBrick
{
    public static final IMyxName msg_Value = MyxUtils.createName("com.objectsbydesign.calc.model.Value");

    public Value OUT_Value;

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
        OUT_Value = (Value) MyxUtils.getFirstRequiredServiceObject(this,msg_Value);
        if (OUT_Value == null){
 			System.err.println("Error: Interface com.objectsbydesign.calc.model.Value returned null");
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
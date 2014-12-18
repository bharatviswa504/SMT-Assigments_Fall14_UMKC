package com.objectsbydesign.calc.model;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

public class PlusArch extends AbstractMyxSimpleBrick implements BinaryOpExecute
{
    public static final IMyxName msg_BinaryOpExecute = MyxUtils.createName("com.objectsbydesign.calc.model.BinaryOpExecute");


	private IPlusImp _imp;

    public PlusArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IPlusImp getImplementation(){
        try{
			return new Plus();    
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
		if (arg0.equals(msg_BinaryOpExecute)){
			return this;
		}        
		return null;
	}
  
    
    public Value executeBinary (Value value1,Value value2)   {
		return _imp.executeBinary(value1,value2);
    }    
}
package com.cpu;


import com.objectsbydesign.calc.model.ICpu;
import com.objectsbydesign.calc.model.*;
import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

public class CpuArch extends AbstractMyxSimpleBrick implements ICpu
{
    public static final IMyxName msg_ICpu = MyxUtils.createName("com.objectsbydesign.calc.model.ICpu");


	private ICentralProcessingUnitImp _imp;

    public CpuArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected ICentralProcessingUnitImp getImplementation(){
        try{
			return new CpuImpl();    
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
		if (arg0.equals(msg_ICpu)){
			return this;
		}        
		return null;
	}
  
    
    public Cpu create ()   {
		return _imp.create();
    }    
}
package com.objectsbydesign.calc.view;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

public class CalcFrameArch extends AbstractMyxSimpleBrick implements CalcFrame
{
    public static final IMyxName msg_CalcFrame = MyxUtils.createName("com.objectsbydesign.calc.view.CalcFrame");


	private ICalculatorFrameImp _imp;

    public CalcFrameArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected ICalculatorFrameImp getImplementation(){
        try{
			return new CalcFrameImpl();    
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
		if (arg0.equals(msg_CalcFrame)){
			return this;
		}        
		return null;
	}
  
    
    public CalculatorFrame create ()   {
		return _imp.create();
    }    
}
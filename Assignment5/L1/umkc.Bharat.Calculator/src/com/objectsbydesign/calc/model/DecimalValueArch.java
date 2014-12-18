package com.objectsbydesign.calc.model;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

public class DecimalValueArch extends AbstractMyxSimpleBrick implements Value
{
    public static final IMyxName msg_Value = MyxUtils.createName("com.objectsbydesign.calc.model.Value");


	private IDecimalValueImp _imp;

    public DecimalValueArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IDecimalValueImp getImplementation(){
        try{
			return new DecimalValue();    
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
		if (arg0.equals(msg_Value)){
			return this;
		}        
		return null;
	}
  
    
    public Value create (String string)   {
		return _imp.create(string);
    }    
    public Value add (Value other)   {
		return _imp.add(other);
    }    
    public Value subtract (Value other)   {
		return _imp.subtract(other);
    }    
    public Value multiply (Value other)   {
		return _imp.multiply(other);
    }    
    public Value divide (Value other)   {
		return _imp.divide(other);
    }    
    public Value negate ()   {
		return _imp.negate();
    }    
    public Value squareRoot ()   {
		return _imp.squareRoot();
    }    
    public Value inverse ()   {
		return _imp.inverse();
    }    
    public Value percent ()   {
		return _imp.percent();
    }    
    public String addDigit (String number,String digit)   {
		return _imp.addDigit(number,digit);
    }    
    public String toString () {
    	return _imp.toString();
    }
}
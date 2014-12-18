package com.objectsbydesign.calc.view;
import com.objectsbydesign.calc.model.*;
import java.util.*;




public class Calculator implements ICalculatorImp
{
	private CalculatorArch _arch;
	
	// Executes the operations
    Cpu cpu;

    // Keeps a record of activity
    CalculatorTape tape;

    // Calculator frame
    CalculatorFrame frame;

    public Calculator (){
    //	cpu = new Cpu();
      //  tape = new CalculatorTape(cpu);
        //frame = new CalculatorFrame(this);
    }

	public void setArch(CalculatorArch arch){
		_arch = arch;
	}
	public CalculatorArch getArch(){
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
		//moved the code to begin
		cpu = new Cpu(_arch.OUT_Value);
        tape = new CalculatorTape(cpu);
        frame = new CalculatorFrame(this);
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
	
	public void enterOperation(String operation) {

        // input the operation to the CPU
        cpu.enterOperation(operation);
    }

    public void enterDigit(String digit) {

        // input the number to the CPU
        cpu.enterDigit(digit);
    }

    public void addDisplayObserver(Observer observer) {
        cpu.addDisplayObserver(observer);
    }

    public void addMemoryObserver(Observer observer) {
        cpu.addMemoryObserver(observer);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
package edu.umkc.bharat.calcext;

import com.objectsbydesign.calc.model.Command;
import com.objectsbydesign.calc.model.Cpu;
import com.objectsbydesign.calc.model.Operation;
import com.objectsbydesign.calc.model.Value;

public class OperationCommand implements Command {
	
	Operation op;
	
	public OperationCommand() {
		System.out.println("bharat OperationCommand");
	}

	public OperationCommand(Operation op)
	{
		System.out.println("Bharat this is 2nd plugin extension");
		this.op = op;
	}
	@Override
	public void execute(Cpu cpu) {
		System.out.println("Bharat this is execute");
		 cpu.pushOperation(op);

	}
	
	public void setOp(Operation op)
	{
		System.out.println("Bharat SetOp");
		this.op = op;
	}
	

	@Override
	public void display() {
		 System.out.println(op.toString());
	}

}

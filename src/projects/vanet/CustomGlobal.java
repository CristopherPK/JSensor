package projects.vanet;

import jsensor.nodes.Node;
import jsensor.runtime.AbsCustomGlobal;
import jsensor.runtime.Jsensor;

public class CustomGlobal extends AbsCustomGlobal {

	boolean flag = false;
	
	@Override
	public boolean hasTerminated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void postRound() {
		for(int i = 101; i <= Jsensor.getNumNodes(); i++){
			Node n = Jsensor.getNodeByID(i);
			VehicleLog.rsuLog(n.getID() + " " + n.getPosition().getPosX() 
				    + " " + n.getPosition().getPosY());
		}
	}

	@Override
	public void postRun() {
		VehicleLog.close();
	}

	@Override
	public void preRound() {
		
	}

	@Override
	public void preRun() {
		VehicleLog.initialize();
	}

}

package projects.vanet;

import jsensor.nodes.Node;
import jsensor.runtime.AbsCustomGlobal;
import jsensor.runtime.Jsensor;

public class CustomGlobal extends AbsCustomGlobal {

	@Override
	public boolean hasTerminated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void postRound() {
//		for(int i = 1; i <= Jsensor.getNumNodes(); i++){
//			Node n = Jsensor.getNodeByID(i);
//			Jsensor.log(Jsensor.currentTime + " " + n.getID() + " " + n.getPosition().getPosX() 
//					    + " " + n.getPosition().getPosY());
//		}
	}

	@Override
	public void postRun() {
	}

	@Override
	public void preRound() {
		
	}

	@Override
	public void preRun() {
		System.out.println("simulation started.");
	}

}

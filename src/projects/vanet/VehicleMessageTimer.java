package projects.vanet;

import jsensor.nodes.Node;
import jsensor.nodes.events.TimerEvent;
import jsensor.runtime.Jsensor;

public class VehicleMessageTimer extends TimerEvent {

	@Override
	public void fire() {
		Vehicle aux = (Vehicle) this.node;
		aux.findRSU();
		if(aux.getRSU() != -1){
			Node n; 
			n = this.node.getRandomNode("Vehicle");
			while(true){
				if(n == null){
					n = this.node.getRandomNode("Vehicle");
					continue;
				}
				
				if(this.node == n){
					n = this.node.getRandomNode("Vehicle");
					continue;
				}
				break;
			}
			
			VehicleMessage m = new VehicleMessage(node, n, 0, this.node.getChunk());
			m.setMessage("This is message number: " + this.node.getChunk() +
						"created by the node: " + node.getID() + "path");
			
//			Jsensor.log("time: " + Jsensor.currentTime + " nodeID: " +
//                    	this.node.getID() + " send to: " + n.getID() +
//                    	" by RSU: " + aux.getRSU());
			
//			Jsensor.log(Jsensor.currentTime + " " +  
//						this.node.getID() + " " + n.getID() +
//						" " + aux.getRSU());
			
			Node rsu = Jsensor.getNodeByID(aux.getRSU());
			this.node.unicast(m, rsu);
		} else {
			Jsensor.log("[No signal] time: " + Jsensor.currentTime + " nodeID: " + 
						this.node.getID() + " position: " + this.node.getPosition().getPosX() + 
							"," + this.node.getPosition().getPosY());
		}
	}

}

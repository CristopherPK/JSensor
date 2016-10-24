package projects.vanet;

import java.util.LinkedList;

import jsensor.nodes.Node;
import jsensor.nodes.messages.Inbox;
import jsensor.nodes.messages.Message;
import jsensor.runtime.Jsensor;

public class Vehicle extends Node {

	private int rsuID;
	private LinkedList<Long> messageIDs;
	
	@Override
	public void handleMessages(Inbox inbox) {
		while(inbox.hasMoreMessages()){
			Message m = inbox.getNextMessage();
			
			if(m instanceof VehicleMessage){
				if(this.messageIDs.contains(((VehicleMessage)m).getID())){
						continue;
				} else {
					this.messageIDs.add(((VehicleMessage)m).getID());
				}
				
				if(((VehicleMessage)m).getDestination().getID() == this.ID){
//					Jsensor.log("time: " + Jsensor.currentTime + " NodeID: " + this.ID + 
//								" received from: " + ((VehicleMessage)m).getSender().getID() +
//								" hops: " + ((VehicleMessage)m).getHops());
					
					if(this.getRandom().nextDouble() < 0.5){
						int time = 1 + this.getRandom().nextInt(100);
						VehicleMessageTimer ct = new VehicleMessageTimer();
						ct.startRelative(time, this);
					}
				}
				
			}
		}
		
	}

	@Override
	public void onCreation() {
		this.messageIDs = new LinkedList<Long>();
		this.rsuID = -1;
		
		if(this.getRandom().nextDouble() < 0.8){
			int time = 10 + this.getRandom().nextInt(100);
			VehicleMessageTimer st = new VehicleMessageTimer();
			st.startRelative(time, this);
			VehicleMobility ct = new VehicleMobility();
			ct.start(this, 1, 5000, 10);
		}
		
	}
	
	public int getRSU(){
		return rsuID;
	}
	
	public void findRSU(){
        if(this.getNeighbours().getNodesList().isEmpty())
            rsuID = -1;
        else
            rsuID = this.getNeighbours().getNodesList().first().getID();
    }
	
}

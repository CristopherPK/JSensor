package projects.vanet;

import java.util.LinkedList;

import jsensor.nodes.Node;
import jsensor.nodes.messages.Inbox;
import jsensor.nodes.messages.Message;
import jsensor.runtime.Jsensor;

public class RSU extends Node {
	
	private LinkedList<Long> messageIDs;

	@Override
	public void handleMessages(Inbox inbox) {
		// Checking if RSU is actually active.
		if(!this.isActive()){
			return;
		}
		
		// address any fact to the cell if required.
		
		while(inbox.hasMoreMessages()){
			Message m = inbox.getNextMessage();
			if(m instanceof VehicleMessage){
				if(this.messageIDs.contains(((VehicleMessage)m).getID())){
					continue;
				} else {
					this.messageIDs.add(((VehicleMessage)m).getID());
					((VehicleMessage)m).setMessage(((VehicleMessage)m).getMessage().concat(Integer.toString(this.ID)));
					this.multicast(m);
				}
			}
			
		}
		
		
	}

	@Override
	public void onCreation() {
		this.messageIDs = new LinkedList<Long>();
	}

}

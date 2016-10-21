package projects.vanet;

import java.util.LinkedList;

import jsensor.nodes.Node;
import jsensor.nodes.messages.Inbox;
import jsensor.nodes.messages.Message;
import projects.MobilePhone_AODV.Messages.SMSMessage;

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
			if(m instanceof SMSMessage){
				if(this.messageIDs.contains(((SMSMessage)m).getID())){
					continue;
				} else {
					this.messageIDs.add(((SMSMessage)m).getID());
					((SMSMessage)m).setMessage(((SMSMessage)m).getMessage().concat(Integer.toString(this.ID)));
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

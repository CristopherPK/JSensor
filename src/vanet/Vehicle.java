package vanet;

import java.util.LinkedList;

import jsensor.nodes.Node;
import jsensor.nodes.messages.Inbox;
import jsensor.nodes.messages.Message;
import jsensor.runtime.Jsensor;
import projects.MobilePhone_AODV.Messages.SMSMessage;
import projects.MobilePhone_AODV.Timers.CellPhoneMobilityTimer;
import projects.MobilePhone_AODV.Timers.SMSTimer;

public class Vehicle extends Node {

	private int rsuID;
	private LinkedList<Long> messageIDs;
	
	@Override
	public void handleMessages(Inbox inbox) {
		while(inbox.hasMoreMessages()){
			Message m = inbox.getNextMessage();
			
			if(m instanceof SMSMessage){
				if(this.messageIDs.contains(((SMSMessage)m).getID())){
						continue;
				} else {
					this.messageIDs.add(((SMSMessage)m).getID());
				}
				
				if(((SMSMessage)m).getDestination().getID() == this.ID){
					Jsensor.log("time: " + Jsensor.currentTime + "NodeID: " + this.ID + 
								"received from: " + ((SMSMessage)m).getSender().getID() +
								"hops: " + ((SMSMessage)m).getHops());
					
					if(this.getRandom().nextDouble() < 0.5){
						int time = 1 + this.getRandom().nextInt(100);
						SMSTimer ct = new SMSTimer();
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
		
		if(this.getRandom().nextDouble() < 0.4){
			int time = 10 + this.getRandom().nextInt(100);
			SMSTimer st = new SMSTimer();
			st.startRelative(time, this);
			CellPhoneMobilityTimer ct = new CellPhoneMobilityTimer();
			ct.start(this, 1, 5000, 10);
		}
		
	}
	
}

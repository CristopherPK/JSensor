package projects.vanet;

import jsensor.nodes.Node;
import jsensor.nodes.messages.Message;

public class VehicleMessage extends Message {

	private Node sender;
	private Node destination;
	private int hops;
	private String message;
	public static int idNumbers = 0;
	
	public VehicleMessage(Node sender, Node destination, int hops, short chunck){
		super(chunck);
		this.sender = sender;
		this.destination = destination;
		this.hops = hops;
		this.message = "";
	}
	
	public VehicleMessage(Node sender, Node destination, int hops, long ID, String message){
		this.setID(ID);
		this.sender = sender;
		this.destination = destination;
		this.hops = hops;
		this.message = message;
	}
	
	public Node getSender() {
		return sender;
	}

	public void setSender(Node sender) {
		this.sender = sender;
	}

	public Node getDestination() {
		return destination;
	}

	public void setDestination(Node destination) {
		this.destination = destination;
	}

	public int getHops() {
		return hops;
	}

	public void setHops(int hops) {
		this.hops = hops;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public Message clone() {
		return new VehicleMessage(sender, destination, hops + 1, this.getID(), this.message);
	}

}

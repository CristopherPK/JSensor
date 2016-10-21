package projects.vanet;

import java.util.Hashtable;

import jsensor.nodes.Node;
import jsensor.nodes.models.MobilityModel;
import jsensor.runtime.Jsensor;
import jsensor.utils.Position;

public class VehicleMobility extends MobilityModel {

	private Hashtable<Integer, Integer> nodes;
	
	public VehicleMobility(){
		this.nodes = new Hashtable<Integer,Integer>();
	}
	
	public VehicleMobility(Hashtable<Integer, Integer> nodes){
		this.nodes = nodes;
	}
	
	@Override
	public MobilityModel clone() {
		return new VehicleMobility(this.nodes);
	}

	@Override
	public Position getNextPosition(Node n) {
		return nextMoviment(n);
	}
	
	public Position nextMoviment(Node n) {
		int x = n.getPosition().getPosX();
		int y = n.getPosition().getPosY();
		
		int direction, newDirection = 0;
		
		if(nodes.containsKey(n.getID())){
			// TODO : Check what nodes.get returns.
			direction = nodes.get(n.getID());
			
			// if is stopped.
			if(direction == 4){
				// probability of remaining stopped.
				if(n.getRandom().nextDouble() < 0.4){
					return n.getPosition();
				} else {
					if(n.getRandom().nextDouble() < 0.2){
						nodes.put(n.getID(), 4);
						return n.getPosition();
					}
				}
				
				if(n.getRandom().nextDouble() > 0.4){
					do{
						newDirection = n.getRandom().nextInt(4);
					} while(direction == newDirection);
				}
				
			}
		}
		
		direction = needChange(n,x,y,newDirection);
		
		nodes.put(n.getID(), direction);
		
    	switch(direction){
    	case 0:{ //System.out.println((n.getPosition().getPosX()) +","+ (n.getPosition().getPosY() - 1)); 
    		return new Position(n.getPosition().getPosX(), n.getPosition().getPosY() - 1);}
		case 1:{ //System.out.println(n.getPosition().getPosX()+","+ n.getPosition().getPosY() + 1); 
			return new Position(n.getPosition().getPosX(), n.getPosition().getPosY() + 1);}
		case 2:{ //System.out.println(n.getPosition().getPosX() + 1 +","+ n.getPosition().getPosY()); 
			return new Position(n.getPosition().getPosX() + 1, n.getPosition().getPosY());}
		case 3:{ //System.out.println(n.getPosition().getPosX() - 1 +","+ n.getPosition().getPosY()); 
			return new Position(n.getPosition().getPosX() - 1, n.getPosition().getPosY());}
	}
	return null;
		
	}

	private int needChange(Node n, int x, int y, int direction) {
		// check if the position need to change.
		if(x == 0){
			if(direction != 3)
				return direction;
			
			if(y == 0){
				if(n.getRandom().nextDouble() < 0.5){
					direction = 1;
				} else {
					direction = 2;
				}
			} else if(y == Jsensor.getDimY()){
				if(n.getRandom().nextDouble() < 0.5){
					direction = 0;
				} else {
					direction = 1;
				}
			} else {
				direction = n.getRandom().nextInt(2);
			}
			
		} else if(x == Jsensor.getDimX()){
			if(direction != 0)
				return direction;
			
			if(y == 0){
				if(n.getRandom().nextDouble() < 0.5){
					direction = 3;
				} else {
					direction = 2;
				}
			} else if(y == Jsensor.getDimY()){
				if(n.getRandom().nextDouble() < 0.5){
					direction = 0;
				} else {
					direction = 3;
				}
			} else {
				if(n.getRandom().nextDouble() < 0.33){
					direction = 0;
				} else if(n.getRandom().nextDouble() > 0.66){
					direction = 2;
				} else {
					direction = 3;
				}
			}
			
		}
		
		if(y == 0){
			if(direction != 0)
				return direction;
			
			direction = 1 + n.getRandom().nextInt(2);
			
		} else if(y == Jsensor.getDimY()){
			if(n.getRandom().nextDouble() < 0.33){
				direction = 0;
			} else if(n.getRandom().nextDouble() > 0.66){
				direction = 1;
			} else {
				direction = 3;
			}
		}
		
		return 0;
	}

}

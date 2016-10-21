package vanet;

import jsensor.nodes.monitoring.DefaultJsensorCell;

public class Cell extends DefaultJsensorCell {

	public Cell() {
		super();
	}
	
	@Override
	public DefaultJsensorCell clone(){
		return new Cell();
	}
	
}

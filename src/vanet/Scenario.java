package vanet;

import jsensor.nodes.monitoring.DefaultJsensorCell;

public class Scenario extends DefaultJsensorCell {
	private int nBlocks;

	public int getnBlocks() {
		return nBlocks;
	}

	public void setnBlocks(int nBlocks) {
		this.nBlocks = nBlocks;
	}

	public Scenario(int nBlocks) {
		super();
		this.nBlocks = nBlocks;
	}
	
	@Override
	public DefaultJsensorCell clone(){
		return new Scenario(this.nBlocks);
	}
	
}

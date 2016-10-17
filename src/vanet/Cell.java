package vanet;

import jsensor.nodes.monitoring.DefaultJsensorCell;

public class Cell extends DefaultJsensorCell {
	private int nBlocks;

	public int getnBlocks() {
		return nBlocks;
	}

	public void setnBlocks(int nBlocks) {
		this.nBlocks = nBlocks;
	}

	public Cell(int nBlocks) {
		super();
		this.nBlocks = nBlocks;
	}
	
	@Override
	public DefaultJsensorCell clone(){
		return new Cell(this.nBlocks);
	}
	
}

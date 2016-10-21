package projects.vanet;

import jsensor.nodes.Node;
import jsensor.nodes.models.ConnectivityModel;

public class VehicleRSUConnectivity extends ConnectivityModel {

    @Override
    public boolean isConnected(Node from, Node to) 
    {
    	if((from instanceof RSU) && (to instanceof Vehicle))
    		return true;
    	else if ((from instanceof Vehicle) && (to instanceof RSU))
    		return true;
    	else if((from instanceof RSU) && (to instanceof RSU))
    		return true;
    	else
    		return false;
    }

}

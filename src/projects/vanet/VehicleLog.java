package projects.vanet;

import java.io.PrintWriter;
import java.time.LocalDateTime;

import jsensor.runtime.Jsensor;

public class VehicleLog {

	private static PrintWriter traces; 
	private static PrintWriter messages; 
	private static PrintWriter rsus; 
	private static boolean isInit = false; 
	
	public VehicleLog() {
	}
	
	public static void initialize(){
		try{
			VehicleLog.traces = new PrintWriter("Results/trace_log" + LocalDateTime.now() + ".txt", "UTF-8");
			VehicleLog.messages = new PrintWriter("Results/messages_log" + LocalDateTime.now() + ".txt", "UTF-8");
			VehicleLog.rsus = new PrintWriter("Results/rsus_log" + LocalDateTime.now() + ".txt", "UTF-8");
			VehicleLog.isInit = true;
		} catch (Exception e) {
		   VehicleLog.isInit = false;
		}
	}
	
	public static boolean isInitialized(){
		return VehicleLog.isInit;
	}
	
	public static void traceLog(String s){
		// a two step verification just to guarantee the actual file was created.
		if(VehicleLog.isInitialized()){
			VehicleLog.traces.println(s);
		}
	}
	
	public static void messagesLog(String s){
		// a two step verification just to guarantee the actual file was created.
		if(VehicleLog.isInitialized()){
			VehicleLog.messages.println(s);
		}
	}
	
	public static void rsuLog(String s){
		// a two step verification just to guarantee the actual file was created.
		if(VehicleLog.isInitialized()){
			VehicleLog.rsus.println(s);
		}
	}
	
	public static void close(){
		VehicleLog.traces.close();
		VehicleLog.messages.close();
		VehicleLog.rsus.close();
	}

}

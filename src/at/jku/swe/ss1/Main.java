package at.jku.swe.ss1;

import at.jku.swe.ss1.actors.TrafficLightInterface;
import at.jku.swe.ss1.actors.TrafficSignInterface;

import java.util.ArrayList;
import java.util.List;

public class Main{
	public static final int SERVER_SOCKET_PORT = 1234;
	private SensorDataPollingService sensorDataPollingService;
	private List<TrafficLightInterface> trafficLights=new ArrayList<>();
	private List<TrafficSignInterface> trafficSigns=new ArrayList<>();

	public Main(){
		new ConnectionReciever(this, SERVER_SOCKET_PORT);     //handle incoming connections
		sensorDataPollingService=new SensorDataPollingService();    //regularily poll the current sensor data
	}

	public static void main(String[] args) {
		new Main();
	}
}

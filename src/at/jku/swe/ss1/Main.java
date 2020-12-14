package at.jku.swe.ss1;

import at.jku.swe.ss1.actors.TrafficLightInterface;
import at.jku.swe.ss1.actors.TrafficSignInterface;
import at.jku.swe.ss1.sensors.SensorInterface;

import java.util.HashMap;
import java.util.Map;

public class Main {
	public static final int SERVER_SOCKET_PORT = 1234;
	private SensorDataPollingService sensorDataPollingService;
	private Map<Integer, TrafficLightInterface> trafficLights = new HashMap<>();
	private Map<Integer, TrafficSignInterface> trafficSigns = new HashMap<>();

	public Main() {
		new ConnectionReciever(this, SERVER_SOCKET_PORT);     //handle incoming connections
		sensorDataPollingService = new SensorDataPollingService();  //regularly poll the current sensor data
	}

	public static void main(String[] args) {
		new Main();
	}

	public Object getSensorData(int key) {
		return sensorDataPollingService.getSensorData(key);
	}

	public Exception setTrafficLights(int key, Object data) {
		return trafficLights.get(key).setData(data);
	}

	public Exception setTrafficSigns(int key, Object data) {
		return trafficSigns.get(key).setData(data);
	}

	public void addSensor(int key, SensorInterface sensor) {
		sensorDataPollingService.addSensor(key, sensor);
	}

	public void addTrafficLight(int key, TrafficLightInterface trafficLight) {
		trafficLights.put(key, trafficLight);
	}

	public void addTrafficSign(int key, TrafficSignInterface trafficSign) {
		trafficSigns.put(key, trafficSign);
	}
}

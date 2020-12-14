package at.jku.swe.ss1;

import at.jku.swe.ss1.sensors.SensorInterface;

import java.util.HashMap;

public class SensorDataPollingService extends Thread {
	private HashMap<Integer, SensorInterface> sensors = new HashMap<>();

	public SensorDataPollingService() {
		start();
	}

	@Override
	public void run() {
		sensors.forEach((key, value) -> value.refreshData());
		try {
			sleep(5000);
		} catch (InterruptedException ignored) {
		}   //to slow down refreshes //TODO: evaluate the need for this slowdown
	}
}

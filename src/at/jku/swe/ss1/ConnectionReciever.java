package at.jku.swe.ss1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnectionReciever extends Thread {
	private Main main;
	private int port;
	private ExecutorService threadies = Executors.newCachedThreadPool();
	private List<Socket> connectedEndpoints = new ArrayList<>();

	public ConnectionReciever(Main main, int port) {
		this.main=main;
		this.port = port;
		start();
	}

	@Override
	public void run() {
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			for (; ; ) {
				Socket socket = serverSocket.accept();
				connectedEndpoints.add(socket);
				threadies.execute(new RequestHandler(main,socket));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			connectedEndpoints.forEach(socket -> {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		}
	}
}

package at.jku.swe.ss1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;

public class RequestHandler implements Runnable {
	private Main main;
	private Socket theOtherEnd;

	public RequestHandler(Main main, Socket theOtherEnd) {
		this.main=main;
		this.theOtherEnd = theOtherEnd;
	}

	@Override
	public void run() {
		try (BufferedInputStream bis = new BufferedInputStream(theOtherEnd.getInputStream());
		     BufferedOutputStream bos = new BufferedOutputStream(theOtherEnd.getOutputStream())) {
			//TODO: implement communication
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

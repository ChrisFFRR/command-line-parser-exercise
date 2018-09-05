package no.kristiania.prg200.http;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class HttpRequest {

	private String hostname;
	private String path;
	private Socket socket;
	private OutputStream outputStream;
	
	public HttpRequest(String hostname, int port, String path ) throws IOException {
		this.path = path;
		socket = new Socket(hostname, port);
		outputStream = socket.getOutputStream();
	}

	public HttpResponse execute() throws IOException {
		writeLine("GET " + path + " HTTP/1.1");
		writeLine("Host: " + hostname);
		writeLine("Connection: close");
		writeLine("");
		outputStream.flush();
		
		return new HttpResponse(socket.getInputStream());
	}
	
	private void writeLine(String line) throws IOException {
		outputStream.write((line + "\r\n").getBytes());
	}

}

package no.kristiania.prg200.http;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HttpRequest {

	private String hostname;
	private String path;
	private String method;
	private Socket socket;
	private OutputStream outputStream;
	private Map<String, String> headers = new HashMap<>();
	
	private String body;
	
	
	public HttpRequest(String hostname, int port, String path) throws IOException {
		//this(hostname, port, path, "GET");
		this.hostname = hostname;
		this.path = path;
		this.method = "GET";
	

		socket = new Socket(hostname, port);
		outputStream = socket.getOutputStream();
	}
	
	public HttpRequest(String hostname, int port, String path, String method) throws IOException {
		//this.hostname = hostname;
		setRequestHeader("Host", hostname);
		this.path = path;
		this.method = method;
		socket = new Socket(hostname, port);
		outputStream = socket.getOutputStream();
	}

	public HttpResponse execute() throws IOException {
		writeLine(method + " " +  path + " HTTP/1.1");
		setRequestHeader("Host", hostname);
		writeLine("Connection: close");
		
		
		for(Entry<String, String> entry : headers.entrySet()){
			writeLine(entry.getKey() + ": " + entry.getValue());
		}
		writeLine("");	
		if(body != null) writeLine(body);
		outputStream.flush();
		
		return new HttpResponse(socket.getInputStream());
	}
	
	private void writeLine(String line) throws IOException {
		outputStream.write((line + "\r\n").getBytes());
	}

	public void setRequestHeader(String rule, String type) {
		this.headers.put(rule, type);
		
		
	}

	public void setBody(String body) {
		this.body = body;
	}

}

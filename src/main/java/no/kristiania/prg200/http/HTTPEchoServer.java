package no.kristiania.prg200.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class HTTPEchoServer {
	
	private int actualPort;
	
	
	public HTTPEchoServer(int port) throws IOException {
		ServerSocket serverSocket = new ServerSocket(port);
		this.actualPort = serverSocket.getLocalPort();
		new Thread(() -> {
			try {
				serverThread(serverSocket);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}

	private void serverThread(ServerSocket serverSocket) throws IOException {
		while(true) {
			try {
				Socket clientSocket = serverSocket.accept(); 
				
				InputStream input = clientSocket.getInputStream();
				OutputStream output = clientSocket.getOutputStream();
				
				Map<String, String> parameters = getParameters(input);

				String headerLine = readLine(input);
				while(!headerLine.isEmpty()) {
					System.out.println(headerLine);
					headerLine = readLine(input);
				}				
				
				
				String statusCode = parameters.get("status");
				if(statusCode == null) {
					statusCode = "200";
				}
				String body = parameters.get("body");
				if(body == null ) {
					body = "Hello World!";
				}
				String location = parameters.get("Location");
				String serverName = parameters.get("X-Server-Name");
				String connection = parameters.get("Connection");
				String contentType = parameters.get("Content-type");
				
				output.write(("HTTP/1.1 " + statusCode + " OK\r\n").getBytes());
				output.write(("X-Server-Name: " + serverName + "r\r\n").getBytes());
				output.write(("Connection: " + connection + "\r\n").getBytes());
				output.write(("Content-Type: " + contentType + "\r\n").getBytes());
				output.write(("Content-Length:" + body.length() + "\r\n").getBytes());
				output.write(("location: " + location + "\r\n").getBytes());
				output.write(("\r\n").getBytes());
				output.write(body.getBytes()); //vil ikke printe i terminal?
				output.flush();
			} catch(IOException e) {
				e.printStackTrace();
			}		
		}
	}

	private Map<String, String> getParameters(InputStream input) throws IOException, UnsupportedEncodingException {
		String line = readLine(input);
		
		String uri = line.toString().split(" ")[1];

		int questionPos = uri.indexOf('?');
		String query = uri.substring(questionPos +1);
		
		Map<String, String> parameters = new HashMap<>();
		for(String parameter : query.split("&")) {
			int equalsPos = parameter.indexOf('=');
			String paramName = URLDecoder.decode(parameter.substring(0, equalsPos), "UTF-8");
			String paramValue = URLDecoder.decode(parameter.substring(equalsPos + 1), "UTF-8");	
			
			parameters.put(paramName, paramValue);
		}
		return parameters;
	}
	
	public String readLine(InputStream input) throws IOException {
		StringBuilder line = new StringBuilder();
		
		int character;
		
		while((character = input.read()) != -1) {
			if(character == '\r') {
				input.read();
				break;
			}
			line.append((char)character);
		}
		
		return line.toString();
	}
	
	public int getPort() {
		// TODO Auto-generated method stub
		return actualPort;
	}
	
	public static void main(String[] args) throws IOException {
		//start();  <- kan ikke kjøre fordi det er void og ikke statisk.
	}

}

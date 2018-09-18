package no.kristiania.prg200.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.sound.sampled.Line;

public class HTTPEchoServer {
	
	private int port;
	private int actualPort;
	
	
	public HTTPEchoServer(int port) throws IOException {
		this.port = port;
		start(); //programm vil ikke funke uten?
	}
	
	public void start() throws IOException {
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
				
				String line = readLine(input);
				
				while(!line.isEmpty()) {
					System.out.println(line);
					line = readLine(input);
				}
				
				String body = "Greetings World!\r\n";
				
				output.write(("HTTP/1.1 200 OK\r\n").getBytes());
				output.write(("X-Server-Name: Chris sin test-server\r\n").getBytes());
				output.write(("Connection: close\r\n").getBytes());
				output.write(("Content-Type: text/plain\r\n").getBytes());
				output.write(("Content-length:" + body.length() + "\r\n").getBytes());
				output.write(("\r\n").getBytes());
				output.write(body.getBytes()); //vil ikke printe i terminal?
			} catch(IOException e) {
				e.printStackTrace();
			}		
		}
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
		
	}

}

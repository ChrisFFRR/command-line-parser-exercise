package HttpServerTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;




public class HttpServerTest {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(100_80);
		
		while(true) {
		
		Socket clientSocket = serverSocket.accept();
		
		InputStream input = clientSocket.getInputStream();
		OutputStream output = clientSocket.getOutputStream();
		
		String line;
		
		while(!line.isEmpty()) {
			line = line.readLine(input);
	}
		
   private static String readLine(InputStream input) throws IOException {
			StringBuilder line = new StringBuilder();
				
			int character;
				
			while((character = input.read()) != -1) {
				if(character == '\r') {
					character = input.read();
					assert character == '\n';
					break;				
				}
				line.append((char)character);
			}
				
			return line.toString();
   		}
	}

	


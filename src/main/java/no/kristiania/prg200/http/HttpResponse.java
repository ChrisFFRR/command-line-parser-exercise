package no.kristiania.prg200.http;

import java.io.IOException;
import java.io.InputStream;

public class HttpResponse {

	private int statusCode;
	private InputStream inputStream;

	public HttpResponse(InputStream inputStream) throws IOException {
		this.inputStream = inputStream;
		String statusLine = readLine();
		
		String[] parts = statusLine.toString().split(" ");
		this.statusCode = Integer.parseInt(parts[1]);
	}



	private String readLine() throws IOException {
		StringBuilder line = new StringBuilder();
		
		int character;
		
		while((character = inputStream.read()) != -1) {
			if(character == '\r') {
				break;
			}
			line.append((char)character);
		}
		
		return line.toString();
	}
	
	

	public int getStatusCode() {
		return statusCode;
	}

	public String getBody() {

		return "Hello World!";
	}

	public String getHeader(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}

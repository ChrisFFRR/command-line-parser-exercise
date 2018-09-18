package no.kristiania.prg200.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class HttpResponse {

	private int statusCode;
	private InputStream input;
	private String body;
	
	private Map<String, String> headers = new HashMap<>();

	public HttpResponse(InputStream inputStream) throws IOException {
		this.input = inputStream;
		String statusLine = readLine(input);
		
		String[] parts = statusLine.toString().split(" ");
		this.statusCode = Integer.parseInt(parts[1]);
		
		String headerLine;
		while((headerLine = readLine(input)) != null) {
			System.out.println(">" + headerLine + ">");
			if(headerLine.isEmpty()) break;
			
			int colonPos = headerLine.indexOf(':');
			String headerName = headerLine.substring(0, colonPos).trim(); 
			String headerValue = headerLine.substring(colonPos + 1).trim();
			
			headers.put(headerName, headerValue);
		
		}
		System.out.println();
		this.body = readLine(input);
	}

	public String readLine(InputStream input) throws IOException {
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
	public String readRestOfInput() throws IOException {
		StringBuilder line = new StringBuilder();
		
		int character;
		
		while((character = input.read()) != -1) {
			line.append((char)character);
			
			}
		return line.toString();
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getBody() throws IOException {

		return body;
	}

	public String getHeader(String headerName) {
		return headers.get(headerName);
	}
	
	public String getHeaderToString() {
		return headers.toString();
	}
}

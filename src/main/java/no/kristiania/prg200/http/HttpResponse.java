package no.kristiania.prg200.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class HttpResponse {

	private int statusCode;
	private InputStream inputStream;
	private String body;
	
	private Map<String, String> headers = new HashMap<>();

	public HttpResponse(InputStream inputStream) throws IOException {
		this.inputStream = inputStream;
		String statusLine = readLine();
		
		String[] parts = statusLine.toString().split(" ");
		this.statusCode = Integer.parseInt(parts[1]);
		
		String headerLine;
		while((headerLine = readLine()) != null) {
			if(headerLine.isEmpty()) break;
			int colonPos = headerLine.indexOf(':');
			headers.put(headerLine.substring(0, colonPos).trim(),
					headerLine.substring(colonPos + 1).trim());
		
		}
			this.body = readLine();
	}



	private String readLine() throws IOException {
		StringBuilder line = new StringBuilder();
		
		int character;
		
		while((character = inputStream.read()) != -1) {
			if(character == '\r') {
				character = inputStream.read();
				assert character == '\n';
				break;
			}
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
}

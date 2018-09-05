package no.kristiania.prg200.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import no.kristiania.prg200.http.HttpReponse;
import no.kristiania.prg200.http.HttpRequest;


public class HttpClientTest {
	
	@Test
	public void shouldReadStatusCode() {
		HttpRequest request = new HttpRequest("urlecho.appspot.com", "/echo?status=200");
		HttpReponse response = request.execute();
		
		assertThat(response.getStatusCode()).isEqualTo(200);
	}
	
	@
	Test
	public void shouldReadOtherStatusCodes() {
		HttpRequest request = new HttpRequest("urlecho.appspot.com", "/echo?status=200");
		HttpRequest response = request.execute();
		
		assertThat(response.getStatusCode()).isEqualTo(404);
	}

	public static void main(String[] args) throws IOException {
		
		try(Socket socket = new Socket("urlecho.appspot.com", 80)) {
		socket.getOutputStream()
			.write("GET /echo?status=200&body=Hello+World! HTTP/1.1\r\n".getBytes());
		socket.getOutputStream()
			.write("Host: urlecho.appspot.com\r\n".getBytes());
		socket.getOutputStream()
			.write("Connection: close\r\n".getBytes());
		socket.getOutputStream().write("\r\n".getBytes());
		
		InputStream input =  socket.getInputStream();
		
		int c;
		while ((c = input.read()) != -1) {
			System.out.print((char) c);
		}
		socket.close();
	}
}
}

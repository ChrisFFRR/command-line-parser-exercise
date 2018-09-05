package no.kristiania.prg200.http;

import static org.assertj.core.api.Assertions.assertThat;


import java.io.IOException;
import java.net.Socket;

import org.junit.Test;


public class HttpClientTest {
	
	
	@Test
	public void ShouldexecuteRequest() throws Exception {
		HttpRequest request = new HttpRequest("http://urlecho.appspot.com", 80, "/echo");
		HttpResponse response = request.execute();
		
		assertThat(response.getStatusCode()).isEqualTo(200);
	}
	
	@Test
	public void ShouldReadResponseCode() throws Exception {
		HttpRequest request = new HttpRequest("urlecho.appspot.com", 80, "/echo?status=404");
		HttpResponse response = request.execute();
		
		assertThat(response.getStatusCode()).isEqualTo(404);
	}
	
	@Test
	public void ShouldReadBody() throws Exception {
		HttpRequest request = new HttpRequest("urlecho.appspot.com", 80, "/echo");
		HttpResponse response = request.execute();
		
		assertThat(response.getBody()).isEqualTo("Hello World!");
	}
	/*
	@Test
	public void ShouldReadHeaders() throws Exception {
		HttpQuery query = new HttpQuery()
				.add("status", 307)
				.add("location", "http://google.com");
		http://urlecho.appspot.com/echo?status=307?&Location=http%3A%F%2Fwww.google.com
		HttpRequest request = new HttpRequest("urlecho.appspot.com", 80, "/echo?" + query);
		HttpResponse response = request.execute();
		
		assertThat(response.getStatusCode()).isEqualTo(200);
		assertThat(response.getHeader("Location")).isEqualTo("http://google.com");
	}
	*/
	
	

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("urlecho.appspot.com", 80);
		
		socket.getOutputStream().write("GET /echo HTTP/1.1\r\n".getBytes());
		socket.getOutputStream().write("Host: urlecho.appspot.com\r\n".getBytes());
		socket.getOutputStream().write("Connection: close\r\n".getBytes());
		socket.getOutputStream().write("\r\n".getBytes());
		
		
		int c;
		
		while((c = socket.getInputStream().read()) != -1) {
			System.out.print((char)c);
		}
		socket.close();
	}
	
}

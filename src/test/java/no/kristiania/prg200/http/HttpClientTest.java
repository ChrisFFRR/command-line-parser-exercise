package no.kristiania.prg200.http;

import static org.assertj.core.api.Assertions.assertThat;


import java.io.IOException;
import java.net.Socket;

import org.junit.Test;


public class HttpClientTest {
	
	
	@Test
	public void ShouldExecuteRequest() throws IOException {
		System.out.println("ShouldExecuteRequest");
		HttpRequest request = new HttpRequest("urlecho.appspot.com", 80, "/echo");
		HttpResponse response = request.execute();
		
		assertThat(response.getStatusCode())
			.isEqualTo(200);
	}
	
	@Test
	public void ShouldReadResponseCode() throws IOException {
		System.out.println("ShouldReadResponseCode");
		HttpQuery query = new HttpQuery().add("status", "404");
		HttpRequest request = new HttpRequest("urlecho.appspot.com", 80, 
				"/echo?" + query);
		HttpResponse response = request.execute();
		
		assertThat(response.getStatusCode())
			.isEqualTo(404);
	}
	
	@Test
	public void ShouldReadBody() throws IOException {
		System.out.println("ShouldReadBody");
		HttpRequest request = new HttpRequest("urlecho.appspot.com", 80, "/echo?"
				+ new HttpQuery().add("body", "Hello World"));
		HttpResponse response = request.execute();
		
		assertThat(response.getBody())
		.isEqualTo("Hello World");
	}

	@Test
	public void ShouldReadResponseHeader() throws IOException {
		System.out.println("ShouldReadResponseHeader");
		HttpQuery query = new HttpQuery()
			.add("status", "307")
			.add("Location", "http://www.google.com");
		HttpRequest request = new HttpRequest("urlecho.appspot.com", 80, "/echo?" + query);
		
		HttpResponse response = request.execute();
		
		assertThat(response.getStatusCode()).isEqualTo(307);
		assertThat(response.getHeader("Location")).isEqualTo("http://www.google.com");
	}
	
	opwepwoejwepoj
	
	@Test
	public void ShouldPostRequest() throws IOException {
		System.out.println("ShouldPostRequest");
		HttpQuery query = new HttpQuery()

				.add("custname", "Chris M")
				.add("custtel", "12345678")
				.add("topping", "bacon");

		
			HttpRequest request = new HttpRequest("httpbin.org", 80, "/post", "POST");
			request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			request.setBody(query.toString());
			
		HttpResponse response = request.execute();
		
		assertThat(response.getStatusCode()).isEqualTo(200);
	}

	public static void main(String[] args) throws IOException {
		/*
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
		*/
	}
	
}

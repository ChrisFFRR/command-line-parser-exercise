package no.kristiania.prg200.http;


import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;



public class HttpServerTest {
	
	private static HTTPEchoServer server;
	
	@BeforeClass
	public static void startServer() throws IOException {
		server = new HTTPEchoServer(0);
	}
	
	
	@Test
	public void shouldReadStatusCode() throws IOException {
		HttpRequest request = new HttpRequest("localhost", server.getPort(), "/echo?status=200");
		HttpResponse response = request.execute();
		
		assertThat(response.getStatusCode()).isEqualTo(200);
	}
	@Test
	public void shouldReadOtherStatusCode() throws IOException {
		HttpRequest request = new HttpRequest("localhost", server.getPort(), "/echo?status=404");
		HttpResponse response = request.execute();
		
		assertThat(response.getStatusCode()).isEqualTo(404);
	}
		
	@Test
	public void shouldReadResponseHeaders() throws IOException {
		HttpRequest request = new HttpRequest("localhost", server.getPort(), 
				"echo?status=307&Location=http%3A%2F%2Fwww.kristiania.no");
		
		HttpResponse response = request.execute();
		
		assertThat(response.getStatusCode()).isEqualTo(307);
		assertThat(response.getHeader("Location")).isEqualTo("http://www.kristiania.no");
	}
	
	@Test
	public void shouldReadResponseBody() throws IOException {
		HttpRequest request = new HttpRequest("localhost", server.getPort(),
				"echo?body=Hello+World!");
		
		HttpResponse response = request.execute();
		
		assertThat(response.getStatusCode()).isEqualTo(200);
		assertThat(response.getBody()).isEqualTo("Hello World!");
	}
	
}


	


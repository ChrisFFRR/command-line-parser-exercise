package no.kristiania.prg200.http;

import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

import no.kristiania.prg200.http.HTTPEchoServer;
import no.kristiania.prg200.http.HttpRequest;
import no.kristiania.prg200.http.HttpResponse;



public class HttpServerTest {
	
	private static HTTPEchoServer server;
	
	@BeforeClass
	public static void startServer() throws IOException {
		server = new HTTPEchoServer(0);
	}
	
	@Test
	public void shouldWriteRequest() throws IOException {
		HttpRequest request = new HttpRequest("localhost", server.getPort(), "/echo?status=200");
		HttpResponse response = request.execute();
		
		assertThat(response.getStatusCode()).isEqualTo(200);
	}
	
	@Test
	public void shouldHandleStatusCode() throws IOException {
		HttpRequest request = new HttpRequest("localhost", server.getPort(), "/echo?status=404");
		HttpResponse response = request.execute();
		
		assertThat(response.getStatusCode()).isEqualTo(404);
	}
		
}


	


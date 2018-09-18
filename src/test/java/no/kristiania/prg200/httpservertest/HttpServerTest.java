package no.kristiania.prg200.httpservertest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
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
		server = new HTTPEchoServer(8080);
	}
	
	@Test
	public void shouldWriteStatusCode() throws IOException {
		HttpRequest request = new HttpRequest("localhost", server.getPort(), "/echo?status=200");
		HttpResponse response = request.execute();
		
		assertThat(response.getStatusCode()).isEqualTo(200);
	}

}

	


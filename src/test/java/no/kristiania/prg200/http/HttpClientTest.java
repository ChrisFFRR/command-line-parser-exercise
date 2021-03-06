package no.kristiania.prg200.http;

import static org.assertj.core.api.Assertions.assertThat;


import java.io.IOException;

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
	
	@Test
	public void ShouldReadBody() throws IOException {
		System.out.println("ShouldReadBody");
		HttpQuery query = new HttpQuery().add("body", "Hello World");
		
		HttpRequest request = new HttpRequest("urlecho.appspot.com", 80, "/echo?" + query);
		HttpResponse response = request.execute();
		System.out.println(response.getBody());
		System.out.println(response.readRestOfInput());
		assertThat(response.getBody())
		.isEqualTo("Hello World");
	}

	
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
			System.out.println("Request: " + request.getBody());
			
		HttpResponse response = request.execute();
		
		assertThat(response.getStatusCode()).isEqualTo(200);
	}

}

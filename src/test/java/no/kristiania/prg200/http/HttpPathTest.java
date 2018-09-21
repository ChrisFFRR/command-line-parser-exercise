package no.kristiania.prg200.http;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class HttpPathTest {
	/*
	@Test
	public void shouldSeperatePathAndQuery() {
		HttpPath path = new HttpPath("/urlecho?status=200");
		assertThat(path.getPath()).isEqualTo("/urlecho");
		assertThat(path.getQuery().toString()).isEqualTo("status=200");
		assertThat(path.toString()).isEqualTo("/urlecho?status=200");
		//assertThat(path.getQuery().getParameters("status")).isEqualTo("200");
	}
	
	@Test 
	public void shouldReturnQueryNullWhenNoQuery() {
		HttpPath path = new HttpPath("/myfile");
		//assertThat(path.getPath()).isEqualTo("/myfile");
		assertThat(path.getQuery()).isNull();
	}
	
	/**
	 * Skille path og query
	 * Håndtere url uten "?"
	 * Lese Parameter
	 * Lese parametere
	 * Lese parametere med url encoding
	 * new HttpQuery() -> .add("status", "200").toString();
	 */
	

}

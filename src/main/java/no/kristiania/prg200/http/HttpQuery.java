package no.kristiania.prg200.http;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HttpQuery {

	private Map<String, String> parameters = new HashMap<>();
	
	public HttpQuery add(String parameter, String value) {
		this.parameters.put(parameter, value); 	
		return this;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Entry<String, String> parameter : parameters.entrySet()) {
			if (result.length() > 0) {
				result.append("&");
			}
			result.append(urlEncode(parameter.getKey()) + "=" + urlEncode(parameter.getValue()));
		}
		
		return result.toString();
	}

	private String urlEncode(String value) {
		
			try {
				return URLEncoder.encode(value, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException("Encoding not supported: ", e);
			}
	}
}

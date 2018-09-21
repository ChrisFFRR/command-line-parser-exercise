package no.kristiania.prg200.http;



public class HttpPath {
	
	private String path;
	
	public HttpPath(String path) {
		this.path = path;
	}
	
	public String getPath() {
		int questionPos = path.indexOf("?");
		
		return path.substring(0, questionPos);
	}

	public String getQuery() {
		// TODO Auto-generated method stub
		return null;
	}
	

}

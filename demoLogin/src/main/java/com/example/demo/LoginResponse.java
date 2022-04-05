package com.example.demo;


public class LoginResponse {
	
	private String content;
	
	public LoginResponse() {}
	
	public LoginResponse(String content) {
		super();
		this.content = content;
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Response login [content=" + content + "]";
	}
	
	

}

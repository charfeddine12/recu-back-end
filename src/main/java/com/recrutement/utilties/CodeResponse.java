package com.recrutement.utilties;

import javax.mail.Authenticator;

public class CodeResponse extends Authenticator {

	
	private String response;

    public CodeResponse(String s) { 
       this.response = s;
    }

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "CodeResponse [response=" + response + "]";
	}
    
    
}
package com.u_tad.web.spring;

public class FormService {
	
	private String input;
	
    public String getInput() {
        return input.toUpperCase();
    }

    public void setInput(String input) {
        this.input = input;
    }
}
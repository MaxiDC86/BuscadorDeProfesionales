package net.guides.springboot2.crud.model;

public class Formulario {
	
	private String name, email,message;

	public Formulario(String name, String email, String message) {
		this.name = name;
		this.email = email;
		this.message = message;
	}

	public Formulario() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

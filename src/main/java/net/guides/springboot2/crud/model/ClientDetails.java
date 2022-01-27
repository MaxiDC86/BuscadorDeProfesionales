package net.guides.springboot2.crud.model;

public class ClientDetails {
	
	private String Id;
	
	public ClientDetails(){
	
	}

	public Long getId() {
		return Long.parseLong(Id);
	}

	public void setId(String id) {
		Id = id;
	}

	
	
	
	
	
}

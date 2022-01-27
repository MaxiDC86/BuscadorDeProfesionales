package net.guides.springboot2.crud.model;

public class ClientDetails {
	
	private String Id;
	
	public ClientDetails(){
	
	}

	public Long getId() {
		return Long.parseLong(Id);
		//return (long) 3;
	}

	public void setId(String id) {
		this.Id = id;
	}

	
	
	
	
	
}

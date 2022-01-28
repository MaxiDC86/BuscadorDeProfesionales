package net.guides.springboot2.crud.model;

public class ClientDetails {

	private String Id;

	public ClientDetails() {

	}

	public ClientDetails(String Id) {
		this.Id = Id;
	}
	
	public String getId() {
		
		return Id;
	}	

	public void setId(String id) {
		this.Id = id;
	}

	public Long getLongId() {
		return Long.parseLong(Id);
		// return (long) 3;
	}
}

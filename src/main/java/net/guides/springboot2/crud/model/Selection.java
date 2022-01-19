package net.guides.springboot2.crud.model;

public class Selection {

	private String zone;
	private String city;

	public Selection() {
	}

	public Selection(String zone, String city) {
		this.zone = zone;
		this.city = city;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}

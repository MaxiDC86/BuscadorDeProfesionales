package net.guides.springboot2.crud.model;

import javax.persistence.*;

@Entity
@Table(name = "tokens")
public class Token {

	private long id;

	public Token() {
	}

	@Id
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}

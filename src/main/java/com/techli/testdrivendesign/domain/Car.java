package com.techli.testdrivendesign.domain;

import lombok.Data;

@Data
public class Car {
	private String name;
	
	private String type;

	public Car(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
}

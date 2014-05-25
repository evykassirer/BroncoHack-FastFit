package com.example.broncohack;

public class Exercise {
	private String name, desc;
	private int image;

	public Exercise(String name, int image, String desc) {
		this.name = name;
		this.image = image;
		this.desc = desc;
	}

	public String getName() {
		return this.name;
	}

	public int getImage() {
		return this.image;
	}

	public String getDesc() {
		return this.desc;
	}

}

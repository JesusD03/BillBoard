package model;

import java.io.Serializable;

public class Billboard implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	private double width;
	private double heigth;
	private boolean inUse;
	private String brand;
	
	public Billboard (double w, double h, boolean iu, String b) {
		width = w;
		heigth = h;
		inUse = iu;
		brand = b;
	}
	
	public double calculateArea() {
		double area = 0;
		area = (width*heigth)/2;
		return area;
	}

	public double getWidth() {
		return width;
	}

	public double getHeigth() {
		return heigth;
	}

	public String getBrand() {
		return brand;
	}

	public boolean isInUse() {
		return inUse;
	}
	
	
	
}

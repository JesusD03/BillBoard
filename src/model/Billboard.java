package model;

public class Billboard {
	
	private double width;
	private double heigth;
	private boolean inUse;
	private String brand;
	
	public Billboard(double width, double heigth, boolean inUse, String brand) {
		this.width = width;
		this.heigth = heigth;
		this.inUse = inUse;
		this.brand = brand;
	}
	
	public double calculateArea() {
		double area = 0;
		area = width*heigth;
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
	
	
	
}

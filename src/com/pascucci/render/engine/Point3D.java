package com.pascucci.render.engine;

/**
 * Represents a point in 3D coordinates.
 * 
 * @author Nick Pascucci <nick@kestrelrobotics.com>
 */

public class Point3D {
	public double x;
	public double y;
	public double z;

	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void setCoordinates(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
	}
}

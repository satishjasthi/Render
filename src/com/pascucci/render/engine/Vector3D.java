package com.pascucci.render.engine;

/**
 * Represents a displacement in 3 dimensional space.
 * 
 * @author Nick Pascucci <nick@kestrelrobotics.com>
 */

public class Vector3D {
	public double x;
	public double y;
	public double z;
	public static final Vector3D X_AXIS_VECTOR = new Vector3D(1.0, 0, 0);
	public static final Vector3D Y_AXIS_VECTOR = new Vector3D(0, 1.0, 0);
	public static final Vector3D Z_AXIS_VECTOR = new Vector3D(0, 0, 1.0);
	public static boolean debug = false;

	public Vector3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3D(Point3D src, Point3D dest) {
		x = dest.x - src.x;
		y = dest.y - src.y;
		z = dest.z - src.z;
	}

	@Override
	public String toString() {
		String s = "(" + x + ", " + y + ", " + z + ")";
		return s;
	}

	public Vector3D toUnitVector() {
		double length = Math.sqrt(x * x + y * y + z * z);
		return new Vector3D(x / length, y / length, z / length);
	}

	public void thisToUnitVector() {
		double length = Math.sqrt(x * x + y * y + z * z);
		x /= length;
		y /= length;
		z /= length;
	}

	/**
	 * Multiplies this vector by a scale, and returns the new vector.
	 * 
	 * @param scale
	 * @return
	 */
	public Vector3D scalar(double scale) {
		return new Vector3D(x * scale, y * scale, z * scale);
	}

	public boolean equals(Vector3D v2) {
		double xRatio = x / v2.x;
		double yRatio = y / v2.y;
		double zRatio = z / v2.z;
		if (debug)
			System.out.println("Comparing vectors " + this + " " + v2
					+ ". Ratios: " + xRatio + " " + yRatio + " " + zRatio);
		if (x == v2.x && y == v2.y && z == v2.z)
			return true;
		if (Math.abs(xRatio - yRatio) < 0.3 && Math.abs(yRatio - zRatio) < 0.3)
			return true;
		else
			return false;
	}

	public double length() {
		return Math.sqrt(x * x + y * y + z * z);
	}

	/**
	 * Sets the components of this vector.
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public void setCoordinates(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void setEndpoints(Point3D src, Point3D dest) {
		x = dest.x - src.x;
		y = dest.y - src.y;
		z = dest.z - src.z;
	}
}

/*
 * All rights reserved by the author.
 * Unauthorized distribution is prohibited.
 */

package com.pascucci.render.engine;

/**
 * Stupid-simple representation of a camera as a 3D point. Could be extended for
 * view fulcrum, depth, etc.
 * 
 * @author Nick Pascucci <nick@kestrelrobotics.com>
 */

public class Camera {
	private Point3D location;

	public Camera(double x, double y, double z) {
		location = new Point3D(x, y, z);
	}

	public Camera(Point3D location) {
		this.location = location;
	}

	public Point3D getLocation() {
		return location;
	}
}

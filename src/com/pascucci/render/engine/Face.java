/*
 * All rights reserved by the author.
 * Unauthorized distribution is prohibited.
 */

package com.pascucci.render.engine;

import java.awt.Color;

/**
 * Stores a 3D face with an array of 3 points which form a plane. The points
 * must be added in counter-clockwise order as perceived from the "outside" of
 * the plane in order for the normal calculation to function correctly.
 * 
 * @author Nick Pascucci <nick@kestrelrobotics.com>
 */

public class Face {
	private Point3D[] points;
	private Color fillcolor;
	private Color bordercolor;
	public double zavg;
	public double diffuseSensitivity;
	public double ambientSensitivity;

	public Face() {
		points = new Point3D[3];
	}

	public Face(Point3D[] points) {
		this.points = points;
		computeAverageZ();
	}

	public Face(Point3D a, Point3D b, Point3D c) {
		points = new Point3D[3];
		points[0] = a;
		points[1] = b;
		points[2] = c;
		computeAverageZ();
	}

	public Point3D[] getPoints() {
		return points;
	}

	public void computeAverageZ() {
		zavg = (points[0].z + points[1].z + points[2].z) / 3;
	}

	public Color getColor() {
		return fillcolor;
	}

	public void setColor(Color c) {
		fillcolor = c;
	}

	public Color getBorderColor() {
		return bordercolor;
	}

	public void setBorderColor(Color c) {
		bordercolor = c;
	}
}

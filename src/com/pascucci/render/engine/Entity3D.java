package com.pascucci.render.engine;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Stores mesh data for a 3D object.
 * 
 * @author Nick Pascucci <nick@kestrelrobotics.com>
 */

public class Entity3D {
	private ArrayList<Face> faces;
	private ArrayList<Point3D> points;
	private String name;

	public Entity3D() {
		faces = new ArrayList<Face>();
		points = new ArrayList<Point3D>();
	}

	public Entity3D(ArrayList<Face> faces, ArrayList<Point3D> points) {
		this.faces = faces;
		this.points = points;
	}

	public ArrayList<Face> getFaces() {
		return faces;
	}

	public ArrayList<Point3D> getPoints() {
		return points;
	}

	public void addPoint(Point3D p) {
		points.add(p);
	}

	public void addPoints(Point3D[] p) {
		points.addAll(Arrays.asList(p));
	}

	public void addFace(Face f) {
		faces.add(f);
	}

	public void addFaces(Face[] f) {
		faces.addAll(Arrays.asList(f));
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setColor(Color c){
		for(Face f : faces){
			f.setColor(c);
		}
	}
	
	public void setBorderColor(Color c){
		for(Face f: faces){
			f.setBorderColor(c);
		}
	}

	@Override
	public String toString() {
		return name;
	}
}

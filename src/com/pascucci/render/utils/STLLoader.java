package com.pascucci.render.utils;

import java.awt.Component;
import java.io.File;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.pascucci.render.engine.Entity3D;
import com.pascucci.render.engine.Scene;

/**
 * Very simple class to offload loading of STL files away from the main thread.
 * 
 * @author Nick Pascucci <nick@kestrelrobotics.com>
 */

public class STLLoader implements Runnable {
	private Component parent;
	private File target;
	private Entity3D entity;
	private Scene scene;
	private ChangeListener changelistener;

	public STLLoader(Component parent, File target, Scene scene) {
		this.parent = parent;
		this.target = target;
		this.scene = scene;
	}

	public void run() {
		entity = STLUtils.entityFromSTL(target, parent);
		scene.addEntity(entity);
		changelistener.stateChanged(new ChangeEvent(this));
	}

	public void addChangeListener(ChangeListener cl) {
		changelistener = cl;
	}

	public Entity3D getEntity() {
		return entity;
	}
}

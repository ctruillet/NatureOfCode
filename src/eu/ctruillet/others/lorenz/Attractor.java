/*
 * Copyright (c) 2020.
 * Clément Truillet (clement@ctruillet.eu)
 */

package eu.ctruillet.others.lorenz;

import processing.core.PVector;

import java.util.ArrayList;

public abstract class Attractor {
	//Attributs
	protected ArrayList<PVector> points = new ArrayList<>();
	protected float dt;

	//Constructeur
	public Attractor(){
		this.dt= (float) 0.001;
		this.points.add(new PVector(1,2,3));
	}

	public Attractor(float dt) {
		this.dt = dt;
		this.points.add(new PVector(1,2,3));
	}


	public Attractor(float dt, float x, float y, float z) {
		this.dt = dt;
		this.points.add(new PVector(x,y,z));
	}

	//Méthodes
	public ArrayList<PVector> getPoints() {
		return points;
	}

	public float getDt() {
		return dt;
	}

	public void display(){
		Main.processing.colorMode(Main.processing.HSB,this.points.size(),255,255);
		Main.processing.noFill();

		Main.processing.scale(5);
		Main.processing.stroke(255);

		Main.processing.beginShape();
		for (PVector point : points) {
			Main.processing.stroke(points.indexOf(point), 255,255);
			Main.processing.point(point.x, point.y,point.z);
		}
		Main.processing.endShape();
	}


	public abstract void compute(int NumerOfIteration);
}

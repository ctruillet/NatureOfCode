/*
 * Copyright (c) 2020.
 * Clément Truillet (clement@ctruillet.eu)
 */

package eu.ctruillet.chapter1.vectorMath;

import eu.ctruillet.chapter1.vector.Main;
import processing.core.PApplet;
import processing.core.PVector;

import javax.print.attribute.standard.PrinterMakeAndModel;

public class Walker {
	//Attributs
	private PVector pos;
	private PVector vel;

	private PApplet processing;


	//Constructeur
	public Walker(float x, float y){
		this.processing = eu.ctruillet.chapter1.vectorMath.Main.processing;

		this.pos = new PVector(x,y);
		this.vel = PVector.random2D();
		this.vel.mult(processing.random(3));
	}

	//Méthodes

	public void show(){
		processing.stroke(255,100);
		processing.strokeWeight(2);
		processing.fill(255,100);
		processing.circle(this.pos.x, this.pos.y,32*2);
	}

	public void update(){
		this.pos.add(this.vel);
	}
}

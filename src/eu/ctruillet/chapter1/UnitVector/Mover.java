/*
 * Copyright (c) 2020.
 * Clément Truillet (clement@ctruillet.eu)
 */

package eu.ctruillet.chapter1.UnitVector;

import processing.core.PApplet;
import processing.core.PVector;

public class Mover {
	//Attributs
	private PVector pos;
	private PVector vel = new PVector();
	private PVector acc = new PVector();
	private int topspeed =5;

	private PApplet processing;

	//Constructeur
	public Mover(){
		this.processing = Main.processing;
		this.pos = new PVector(processing.width/2,processing.height/2);
	}


	//Méthodes
	public void update(){

	}

	public void show(){
		processing.stroke(255,100);
		processing.strokeWeight(2);
		processing.fill(255,100);
		processing.circle(this.pos.x, this.pos.y,32*2);
	}
}

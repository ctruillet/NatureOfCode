/*
 * Copyright (c) 2020.
 * Clément Truillet (clement@ctruillet.eu)
 */

package eu.ctruillet.chapter1.vector;

import processing.core.PApplet;
import processing.core.PVector;

public class Walker {
	//Attributs
	private PVector pos;

	private PApplet processing;


	//Constructeur
	public Walker(float x, float y){
		this.processing = Main.processing;

		this.pos = new PVector(x,y);
	}

	//Méthodes

	public void show(){
		processing.stroke(255,100);
		processing.strokeWeight(2);
		processing.point(this.pos.x, this.pos.y);
	}

	public void update(){
		this.pos.x += processing.random(-1,1);
		this.pos.y += processing.random(-1,1);
	}
}

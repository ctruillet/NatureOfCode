/*
 * Copyright (c) 2020.
 * Clément Truillet (clement@ctruillet.eu)
 *
 *
 * CHAPTER 2.3 - FRICTION FORCE
 * https://www.youtube.com/watch?v=WBdhAuWS6X8
 */

package eu.ctruillet.chapter1.UnitVector;

import processing.core.PApplet;
import processing.core.PVector;

public class Main extends PApplet {
	//Attributs
	public static PApplet processing;

	private Mover mover;

	//Constructeur


	//Méthodes
	public static void main(String[] args) {
		PApplet.main("eu.ctruillet.chapter1.UnitVector.Main",args);
	}

	public void settings(){
		size(400, 400);
	}

	public void setup(){
		processing = this;
		surface.setTitle("Unit Vector");

		background(0);
	}

	public void draw(){
		background(0);

		PVector pos = new PVector(200,200);
		PVector mouse = new PVector(mouseX,mouseY);

		PVector v = PVector.sub(mouse,pos);
		v.setMag(50);


		translate(width/2,height/2);

		strokeWeight(4);
		stroke(255,50);
		line(0,0,v.x,v.y);

	}
}

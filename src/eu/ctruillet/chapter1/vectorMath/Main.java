/*
 * Copyright (c) 2020.
 * Clément Truillet (clement@ctruillet.eu)
 *
 *
 * CHAPTER 2.3 - FRICTION FORCE
 * https://www.youtube.com/watch?v=WBdhAuWS6X8
 */

package eu.ctruillet.chapter1.vectorMath;

import processing.core.PApplet;
import processing.core.PVector;

public class Main extends PApplet {
	//Attributs
	public static PApplet processing;
	private Walker walker;

	//Constructeur


	//Méthodes
	public static void main(String[] args) {
		PApplet.main("eu.ctruillet.chapter1.vectorMath.Main",args);
	}

	public void settings(){
		size(400, 400);
	}

	public void setup(){
		processing = this;
		surface.setTitle("VectorMath");

		this.walker = new Walker(width/2,height/2);
		background(0);
	}

	public void draw(){
		background(0,100);

		/*walker.update();
		walker.show();*/


		translate(width/2,height/2);

		PVector v = PVector.random2D();
		v.mult(random(50,100));

		strokeWeight(4);
		stroke(255,50);


		line(0,0,v.x, v.y);


	}
}

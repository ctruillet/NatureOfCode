/*
 * Copyright (c) 2020.
 * Clément Truillet (clement@ctruillet.eu)
 *
 *
 * CHAPTER 2.3 - FRICTION FORCE
 * https://www.youtube.com/watch?v=WBdhAuWS6X8
 */

package eu.ctruillet.others.lorenz;

import eu.ctruillet.chapter1.UnitVector.Mover;
import processing.core.PApplet;
import processing.core.PVector;

public class Main extends PApplet {
	//Attributs
	public static PApplet processing;
	public Attractor attractor = new LorenzAttractor();
	//Constructeur


	//Méthodes
	public static void main(String[] args) {
		PApplet.main("eu.ctruillet.others.lorenz.Main",args);
	}

	public void settings(){
		size(640, 640,P3D);
	}

	public void setup(){
		processing = this;
		surface.setTitle("Lorenz");
		this.attractor.compute(10000);

		background(0);
	}

	public void draw(){
		translate(width/2, height/2);
		this.attractor.display();



	}
}

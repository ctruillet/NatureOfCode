/*
 * Copyright (c) 2020.
 * Clément Truillet (clement@ctruillet.eu)
 *
 *
 * CHAPTER 2.3 - FRICTION FORCE
 * https://www.youtube.com/watch?v=WBdhAuWS6X8
 */

package eu.ctruillet.chapter1.vector;

import eu.ctruillet.chapter2.frictionForce.Mover;
import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class Main extends PApplet {
	//Attributs
	public static PApplet processing;

	private Walker walker;

	//Constructeur


	//Méthodes
	public static void main(String[] args) {
		PApplet.main("eu.ctruillet.chapter1.vector.Main",args);
	}

	public void settings(){
		size(400, 400);
	}

	public void setup(){
		processing = this;
		surface.setTitle("Vector");

		this.walker = new Walker(width/2, height/2);
		background(0);
	}

	public void draw(){


		walker.update();
		walker.show();
	}
}

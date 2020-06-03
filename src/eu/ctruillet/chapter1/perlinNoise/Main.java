/*
 * Copyright (c) 2020.
 * Clément Truillet (clement@ctruillet.eu)
 *
 *
 * CHAPTER 2.3 - FRICTION FORCE
 * https://www.youtube.com/watch?v=WBdhAuWS6X8
 */

package eu.ctruillet.chapter1.perlinNoise;

import eu.ctruillet.chapter1.UnitVector.Mover;
import processing.core.PApplet;
import processing.core.PVector;

public class Main extends PApplet {
	//Attributs
	public static PApplet processing;
	public float previousX;
	//Constructeur


	//Méthodes
	public static void main(String[] args) {
		PApplet.main("eu.ctruillet.chapter1.perlinNoise.Main",args);
	}

	public void settings(){
		size(400, 400);
	}

	public void setup(){
		processing = this;
		surface.setTitle("Perlin Noise");

		background(0);
		this.previousX=height/2;
	}

	public void draw(){
		background(0);
		fill(255);
		strokeWeight(1);
		stroke(255);

		for (int i = 0; i < width; i++) {
				float x = noise(i/5);
				x = map(x,0,1,height/2,height/4);
				line(i-1,previousX,i,x);
				previousX=x;
		}
	}
}

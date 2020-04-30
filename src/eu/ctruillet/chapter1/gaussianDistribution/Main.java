/*
 * Copyright (c) 2020.
 * Clément Truillet (clement@ctruillet.eu)
 *
 *
 * CHAPTER 2.3 - FRICTION FORCE
 * https://www.youtube.com/watch?v=WBdhAuWS6X8
 */

package eu.ctruillet.chapter1.gaussianDistribution;

import eu.ctruillet.chapter1.vectorMath.Walker;
import processing.core.PApplet;
import processing.core.PVector;

import java.util.Random;

public class Main extends PApplet {
	//Attributs
	public static PApplet processing;
	private Random gen;

	//Constructeur


	//Méthodes
	public static void main(String[] args) {
		PApplet.main("eu.ctruillet.chapter1.gaussianDistribution.Main",args);
	}

	public void settings(){
		size(400, 400);
	}

	public void setup(){
		processing = this;
		surface.setTitle("Gaussian Distribution");
		gen = new Random();

		colorMode(HSB);
		background(0);
	}

	public void draw(){
		background(0,100);
		float h = (float) gen.nextGaussian();

		h = h*10 + 100;

		fill(h,255,255);
		circle(width/2, height/2, h);

	}
}

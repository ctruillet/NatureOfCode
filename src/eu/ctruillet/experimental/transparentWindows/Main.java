/*
 * Copyright (c) 2020.
 * Clément Truillet (clement@ctruillet.eu)
 *
 *
 * CHAPTER 2.3 - FRICTION FORCE
 * https://www.youtube.com/watch?v=WBdhAuWS6X8
 */

package eu.ctruillet.experimental.transparentWindows;

import processing.core.PApplet;

import java.util.Random;

public class Main extends PApplet {
	//Attributs
	public static PApplet processing;
	private Random gen;

	//Constructeur


	//Méthodes
	public static void main(String[] args) {
		PApplet.main("eu.ctruillet.experimental.transparentWindows.Main",args);
	}

	public void settings(){
		size(400, 400);
	}

	public void setup(){
		processing = this;
		surface.setTitle("Transparent Windows");


	}

	public void draw(){
		background(-1);
		circle(width/2, height/2, 50);

	}
}

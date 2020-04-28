/*
 * Copyright (c) 2020.
 * Clément Truillet (clement@ctruillet.eu)
 *
 *
 * CHAPTER 2.3 - FRICTION FORCE
 * https://www.youtube.com/watch?v=WBdhAuWS6X8
 */

package eu.ctruillet.chapter2.frictionForce;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class Main extends PApplet {
	//Attributs
	public static PApplet processing;

	private ArrayList<Mover> moverArrayList = new ArrayList<>();

	//Constructeur


	//Méthodes
	public static void main(String[] args) {
		PApplet.main("eu.ctruillet.chapter2.frictionForce.Main",args);
	}

	public void settings(){
		size(400, 400);
	}

	public void setup(){
		processing = this;
		surface.setTitle("Friction Force");

		for (int i = 0; i < 1; i++) {
			moverArrayList.add(new Mover(random(width), 200, random(1,8)));
		}
	}

	public void draw(){
		background(0,100);

		for (Mover mover : moverArrayList) {

			if(mousePressed){
				mover.applyForce(new PVector((float) 0.1,0));
			}

			mover.applyForce(PVector.mult(new PVector(0, (float) 0.2), mover.getMass()));


			mover.friction();
			mover.update();
			mover.edge();

			mover.show();
		}


	}
}

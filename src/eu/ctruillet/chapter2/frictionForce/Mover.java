/*
 * Copyright (c) 2020.
 * Clément Truillet (clement@ctruillet.eu)
 */

package eu.ctruillet.chapter2.frictionForce;

import processing.core.PApplet;
import processing.core.PVector;

import static java.lang.Math.sqrt;

public class Mover {
	//Attributs
	private PVector pos;
	private PVector vel = new PVector(0,0);
	private PVector acc = new PVector(0,0);
	private float mass;
	private float radius;

	private final static double mu = 0.1;


	private PApplet processing;

	//Constructeur
	public Mover(float x, float y, float mass){
		this.processing = Main.processing;

		this.pos = new PVector(x, y);
		this.mass = mass;
		this.radius = (float) (sqrt(this.mass) * 10);
	}


	//Méthodes


	public PVector getPos() {
		return pos;
	}

	public PVector getVel() {
		return vel;
	}

	public PVector getAcc() {
		return acc;
	}

	public float getMass() {
		return mass;
	}

	public float getRadius() {
		return radius;
	}

	public void show(){
		processing.stroke(255);
		processing.strokeWeight(2);
		processing.fill(255,100);

		processing.circle(this.pos.x, this.pos.y, this.radius*2);
		this.showVector();
	}


	/**
	 * Show Velocity
	 */
	public void showVector(){
		processing.fill(255,0,0);
		processing.stroke(255,0,0);
		processing.line(this.pos.x,
				this.pos.y,
				this.pos.x + 5*this.vel.x,
				this.pos.y + 5*this.vel.y
				);


	}

	public void update(){
		this.vel.add(this.acc);
		this.pos.add(this.vel);
		this.acc.set(0, 0);
	}

	public void edge(){
		if (this.pos.y >= processing.height - this.radius) {
			this.pos.y = processing.height - this.radius;
			this.vel.y *= -1;
		}

		if (this.pos.x >= processing.width - this.radius) {
			this.pos.x = processing.width - this.radius;
			this.vel.x *= -1;
		} else if (this.pos.x <= this.radius) {
			this.pos.x = this.radius;
			this.vel.x *= -1;
		}
	}

	public void friction(){
		float distance = processing.height - (this.pos.y + this.radius);

		if(distance<1){
			PVector friction = this.vel.copy();
			friction.normalize().mult(-1);

			friction.setMag((float) (mu * this.mass));

			this.applyForce(friction);
		}

	}

	public void applyForce(PVector force){
		this.acc.add(PVector.div(force, this.mass));
	}
}

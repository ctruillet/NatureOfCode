/*
 * Copyright (c) 2020.
 * Clément Truillet (clement@ctruillet.eu)
 */

package eu.ctruillet.others.lorenz;

import processing.core.PVector;

public class LorenzAttractor extends Attractor{
	//Attributs


	//Constructeur


	//Méthodes
	@Override
	public void compute(int numberOfIteration) {
		for (int i = 0; i < numberOfIteration; i++) {
			float x = this.points.get(this.points.size()-1).x;
			float y = this.points.get(this.points.size()-1).y;
			float z = this.points.get(this.points.size()-1).z;


			float dx = (10 * (y -x)) * dt;
			float dy = (x * (28 - z) - y) * dt;
			float dz = (float) ((x*y - (8.0/3.0)*z) * dt);

			x+=dx;
			y+=dy;
			z+=dz;

			this.points.add(new PVector(x,y,z));
		}

	}
}

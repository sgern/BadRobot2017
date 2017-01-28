package org.usfirst.frc.team1014.robot.util;

public final class Vector2D {

	double x, y;
	final double THRESHOLD_VALUE = 0.001;

	public Vector2D(double a, double b) {
		x = a;
		y = b;
	}

	public double getX() {
		if (Math.pow(x, 2) < THRESHOLD_VALUE)
			return 0;
		return x;
	}

	public double getY() {
		if (Math.pow(y, 2) < THRESHOLD_VALUE)
			return 0;
		return y;
	}

	public void add(Vector2D vector) {
		x += vector.getX();
		y += vector.getY();
	}

	public void rotateRadians(double radians) {
		double magnitude = getMagnitude();
		double currentRadians;
		if (Math.pow(x, 2) < THRESHOLD_VALUE) {
			if (y >= 0)
				currentRadians = Math.PI / 2;
			else
				currentRadians = -Math.PI / 2;
		} else
			currentRadians = Math.atan(y / x);

		currentRadians += radians;
		x = Math.cos(currentRadians) * magnitude;
		y = Math.sin(currentRadians) * magnitude;
	}

	public void rotateRotations(double rotations) {
		double magnitude = getMagnitude();
		double currentRadians = Math.atan(y / x);
		if (Math.pow(x, 2) < THRESHOLD_VALUE)
			if (y >= 0)
				currentRadians = Math.PI / 2;
			else
				currentRadians = -Math.PI / 2;
		else
			currentRadians = Math.atan(y / x);
		currentRadians += rotations * 2 * Math.PI;
		x = Math.cos(currentRadians) * magnitude;
		y = Math.sin(currentRadians) * magnitude;
	}

	public void normalize() {
		double magnitude = getMagnitude();
		if (magnitude != 0) {
			x /= magnitude;
			y /= magnitude;
		}
	}

	public double getMagnitude() {
		return Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2));
	}

	public void scale(double scaleFactor) {
		x *= scaleFactor;
		y *= scaleFactor;
	}

	public void perpendicularCW() {
		rotateRadians(-Math.PI / 2);
	}

	public void perpendicularCCW() {
		rotateRadians(Math.PI / 2);
	}

	public double getAngleRadians() {
		return Math.atan(y / x);
	}

	public double getAngleRotations() {
		return Math.atan(y / x) / (Math.PI * 2);
	}

}

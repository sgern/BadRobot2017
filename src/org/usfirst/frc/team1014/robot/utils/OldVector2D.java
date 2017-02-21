package org.usfirst.frc.team1014.robot.utils;

public class OldVector2D {

	final double x, y;

	public OldVector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public OldVector2D add(OldVector2D vector) {
		OldVector2D newVector = new OldVector2D(x + vector.getX(), y + vector.getY());
		return newVector;
	}

	public OldVector2D rotateRadians(double radians) {
		double magnitude = getMagnitude();
		double currentRadians = 0;
		if (y == 0 && x < 0) {
			currentRadians = Math.PI;
		} else if (x == 0) {
			if (y > 0)
				currentRadians = Math.PI / 2;
			else
				currentRadians = -Math.PI / 2;
		} else
			currentRadians = Math.atan(y / x);
		currentRadians += radians;
		OldVector2D newVector = new OldVector2D(Math.cos(currentRadians) * magnitude, Math.sin(currentRadians) * magnitude);
		return newVector;
	}

	public OldVector2D rotateRotations(double rotations) {
		double magnitude = getMagnitude();
		double currentRadians = 0;
		if (y == 0 && x < 0) {
			currentRadians = Math.PI;
		} else if (x == 0) {
			if (y > 0)
				currentRadians = Math.PI / 2;
			else
				currentRadians = -Math.PI / 2;
		} else
			currentRadians = Math.atan(y / x);
		currentRadians += rotations * 2 * Math.PI;
		OldVector2D newVector = new OldVector2D(Math.cos(currentRadians) * magnitude, Math.sin(currentRadians) * magnitude);
		return newVector;
	}

	public OldVector2D normalize() {
		double magnitude = getMagnitude();
		if (magnitude != 0) {
			OldVector2D newVector = new OldVector2D(x / magnitude, y / magnitude);
			return newVector;
		}
		return null;
	}

	public double getMagnitude() {
		return Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2));
	}

	public OldVector2D scale(double scaleFactor) {
		OldVector2D newVector = new OldVector2D(x * scaleFactor, y * scaleFactor);
		return newVector;
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

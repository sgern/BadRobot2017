package org.usfirst.frc.team1014.robot.util;

public final class Vector2D {

	private final double x, y;

	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getAngleRadians() {
		double radians = 0;
		if (y >= 0)
			radians = Math.acos(x / Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
		else if (y < 0)
			radians = 2 * Math.PI - Math.acos(x / Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
		return radians;
	}

	public double getMagnitude() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

	public Vector2D add(Vector2D vector) {
		Vector2D newVector = new Vector2D(x + vector.x, y + vector.y);
		return newVector;
	}

	public Vector2D rotateRadians(double radians) {
		double cosVal = Math.cos(radians);
		double sinVal = Math.sin(radians);
		Vector2D newVector = new Vector2D((x * cosVal - y * sinVal), x * sinVal + y * cosVal);
		return newVector;
	}

	public Vector2D normalize() {
		double magnitude = getMagnitude();
		if (magnitude != 0) {
			Vector2D newVector = new Vector2D(x / magnitude, y / magnitude);
			return newVector;
		}
		return null;
	}

	public Vector2D scale(double scaleFactor) {
		Vector2D newVector = new Vector2D(x * scaleFactor, y * scaleFactor);
		return newVector;
	}

	public void perpendicularCW() {
		rotateRadians(-Math.PI / 2);
	}

	public void perpendicularCCW() {
		rotateRadians(Math.PI / 2);
	}

}
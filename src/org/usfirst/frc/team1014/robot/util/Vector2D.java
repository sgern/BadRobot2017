package org.usfirst.frc.team1014.robot.util;

public class Vector2D {

	private final double x, y;

	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vector2D add(Vector2D other) {
		return new Vector2D(this.x + other.getX(), this.y + other.getY());
	}

	/**
	 * Returns distance of a point at the end of the vector to the origin.
	 * 
	 * @return the magnitude of the vector
	 */
	public double magnitude() {
		return Math.sqrt(Math.abs(x) * Math.abs(x) + Math.abs(y) * Math.abs(y));
	}

	/**
	 * @param scale
	 * @return a new {@code Vector2d} scaled by the {@code scale}
	 */
	public Vector2D scale(double scale) {
		return new Vector2D(scale * x, scale * y);
	}

	public Vector2D normalize() {
		double magnitude = magnitude();
		return new Vector2D(x / magnitude, y / magnitude);
	}

	public Vector2D rotateRadians(double theta) {
		theta *= -1; // To make theta counterclockwise for math
		double x = this.x * Math.cos(theta) - this.y * Math.sin(theta);
		double y = this.x * Math.sin(theta) + this.y * Math.cos(theta);
		return new Vector2D(x, y);
	}

	public Vector2D rotateDegrees(double theta) {
		return rotateRadians(Math.toRadians(theta));
	}

	public Vector2D perpendicularCCW() {
		return new Vector2D(-y, x);
	}

	public Vector2D perpendicularCW() {
		return new Vector2D(y, -x);
	}

	@Override
	public Object clone() {
		return new Vector2D(x, y);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector2D other = (Vector2D) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

}

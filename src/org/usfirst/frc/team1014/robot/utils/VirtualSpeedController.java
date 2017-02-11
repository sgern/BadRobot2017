package org.usfirst.frc.team1014.robot.utils;

import edu.wpi.first.wpilibj.SpeedController;

public class VirtualSpeedController implements SpeedController {

	private double speed = 0;
	private boolean enabled = true;
	private boolean inverted = false;

	@Override
	public void pidWrite(double arg0) {

	}

	@Override
	public void disable() {
		enabled = false;
	}

	@Override
	public double get() {
		return speed;
	}

	@Override
	public boolean getInverted() {
		return inverted;
	}

	@Override
	public void set(double newSpeed) {
		if (enabled)
			if (inverted)
				speed = -newSpeed;
			else
				speed = newSpeed;
	}

	@Override
	public void setInverted(boolean newInverted) {
		inverted = newInverted;
	}

	@Override
	public void stopMotor() {
		speed = 0;
	}

}

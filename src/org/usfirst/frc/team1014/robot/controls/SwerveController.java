package org.usfirst.frc.team1014.robot.controls;

import org.usfirst.frc.team1014.robot.util.Vector2D;

public interface SwerveController {

	public Vector2D getTranslation();

	public double getRotation();

	public boolean isFieldCentric();

	public boolean resetFieldCentric();

}

package org.usfirst.frc.team5590.robot.commands;

import java.util.logging.Logger;

import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.autonomous.basics.TurnAngle;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Closes the grabber via pneumatics 
 */
public class CloseGrabber extends Command {

	private final static Logger logger = Logger.getLogger(CloseGrabber.class.getName());
	
	public CloseGrabber() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.grabber);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		logger.info("Starting CloseGrabber");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.grabber.clawsClose();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
		logger.info("Ending CloseGrabber");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		logger.info("Close Grabber Interrupted");
	}
}
package org.usfirst.frc.team5590.robot.subsystems;

import org.usfirst.frc.team5590.robot.RobotMap;
import org.usfirst.frc.team5590.robot.commands.Collect;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Controls the sucking in and sucking out of the cubes via a belt drive
 */
public class BeltDrive extends Subsystem {
	
	private static final double COLLECT_SPEED = .5;
	private static final double HOLD_SPEED = .2;
	
	private static final boolean INVERT_LEFT_MOTOR = false;
	private static final boolean INVERT_RIGHT_MOTOR = false;


	TalonSRX leftMotor;
	TalonSRX rightMotor;
	
	public BeltDrive() {
		leftMotor = new TalonSRX(RobotMap.BD_LEFT_TALON);
		rightMotor = new TalonSRX(RobotMap.BD_RIGHT_TALON);
		leftMotor.setInverted(INVERT_LEFT_MOTOR);
		rightMotor.setInverted(INVERT_RIGHT_MOTOR);
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new Collect());
	}
	
	public void output() {
		this.setBeltSpeed(-COLLECT_SPEED);
	}
	
	public void intake() {
		this.setBeltSpeed(COLLECT_SPEED);
	}
	
	public void superIntake() {
		this.setBeltSpeed(1);
	}

	/**
	 * Drives the beltdrives for the grabber at
	 * certain speeds based on if we are holding
	 * a cube or not
	 * @param invert
	 */
	public void operate(boolean isHoldingCube, boolean invert) {
		double speed = isHoldingCube ? HOLD_SPEED : COLLECT_SPEED;
		speed = invert ? -speed : speed;
		this.setBeltSpeed(speed);
	}

	// Deactivates the subsystem
	public void beltStop() {
		setBeltSpeed(0);
	}

	private void setBeltSpeed(double speed) {
		leftMotor.set(ControlMode.PercentOutput, speed);
		rightMotor.set(ControlMode.PercentOutput, -speed);
	}
}

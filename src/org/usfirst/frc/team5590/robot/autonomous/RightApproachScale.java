package org.usfirst.frc.team5590.robot.autonomous;

import java.util.logging.Logger;

import org.usfirst.frc.team5590.robot.autonomous.commands.PolarDrive;

/**
 *
 */
public class RightApproachScale extends AutoStrategy {
	
	private final static Logger logger = Logger.getLogger(RightApproachScale.class.getName());
    
    public void scheduleCommand() {
    	
    		logger.info("************ STARTING AUTONOMOUS ************");
    		
    		/*
    		 * SCALE ON OUR SIDE
    		 */
    		if (this.scaleSide == 'R') {
    			rightSideScale();
    		/*
    		 * SCALE ON OTHER SIDE 
    		 */
    		} else if (this.driveNearSide) {
    			leftSideScaleThruBackWallDrive();
    			
    		} else if (!this.driveNearSide) {
    			leftSideScaleThruSwitchScaleDrive();
    		}
    		
    }
    
    private void rightSideScale() {
    		logger.info("*** DRIVING TO RIGHT SCALE BETWEEN SCALE & SWITCH ***");
		addSequential(new PolarDrive(0, 288, fastSpeed));
		addSequential(new PolarDrive(-80, 0, slowSpeed));
    }
    
    private void leftSideScaleThruBackWallDrive() {
    		logger.info("*** DRIVING TO LEFT SCALE BETWEEN WALL & SWITCH ***");
    		addSequential(new PolarDrive(0, 57, slowSpeed));
    		addSequential(new PolarDrive(-90, 230, fastSpeed));
    		addSequential(new PolarDrive(90, 254, fastSpeed));
    		addSequential(new PolarDrive(90, 0, slowSpeed));
    }
    
    private void leftSideScaleThruSwitchScaleDrive() {
    		logger.info("*** DRIVING TO LEFT SCALE BETWEEN SCALE & SWITCH ***");
    		addSequential(new PolarDrive(0, 222, fastSpeed));
    		addSequential(new PolarDrive(-90, 240, fastSpeed));
    		addSequential(new PolarDrive(90, 85, slowSpeed));
    		addSequential(new PolarDrive(90, 0, slowSpeed));
    }
    
}
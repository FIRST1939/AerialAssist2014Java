// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc1939.AerialAssist2014.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc1939.AerialAssist2014.Robot;
import org.usfirst.frc1939.AerialAssist2014.RobotMap;
/**
 *
 */
public class  KickLatch extends Command {
    
    public KickLatch() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.catapult);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    // Called just before this Command runs the first time
    protected void initialize() {
        if(!Robot.arm.out){
            System.out.println("Arm not out");
            this.setTimeout(0.1);
            new SetColorForTime(1.5).start();
        }else{
            //this.setTimeout(Robot.catapult.limitSwitchDelay);
            this.setTimeout(0.7);
        }
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(Robot.arm.out){
            RobotMap.catapultMotor.set(Robot.catapult.catapultKickSpeed);
        }else{
            System.out.println("Arm not out");
        }
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //Stop motor when it has been hit and released
        return this.isTimedOut();//!RobotMap.catapultLatchLimitSwitch.get() && this.isTimedOut();
    }
    // Called once after isFinished returns true
    protected void end() {
        RobotMap.catapultMotor.set(0.0);
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

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
public class  DriveForward extends Command {
    private final double time;
    private double rightPower = -0.25;
    private final double leftPower = 0.25;
    private final double step = 0.01;
    
    public DriveForward(double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.drivetrain);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        this.time = time;
    }
    // Called just before this Command runs the first time
    protected void initialize() {
        this.setTimeout(time);
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double left = RobotMap.drivetrainLeftFrontEncoder.getRate();
        double right = RobotMap.drivetrainRightFrontEncoder.getRate();
        if(left>right){
            rightPower = rightPower - step;
        }else if(right>left){
            rightPower = rightPower + step;
        }
        
        RobotMap.drivetrainRobotDrive.setLeftRightMotorOutputs(leftPower, rightPower);
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimedOut();
    }
    // Called once after isFinished returns true
    protected void end() {
        RobotMap.drivetrainRobotDrive.mecanumDrive_Cartesian(0, 0, 0, 0);
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

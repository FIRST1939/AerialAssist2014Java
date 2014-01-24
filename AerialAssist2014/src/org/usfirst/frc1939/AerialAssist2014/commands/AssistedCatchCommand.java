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
import org.usfirst.frc1939.AerialAssist2014.subsystems.Ultrasonic;
/**
 *
 */
public class  AssistedCatchCommand extends Command {
    
    private final Ultrasonic ultrasonic;
    public static final int ignoreDistance = 120;
    public static final int margin = 5;
    public static final double turnSpeed = 0.3;
    public static final double strafeSpeed = 0.5;
    
    public AssistedCatchCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.drivetrain);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        ultrasonic = Robot.ultrasonic;
        
        //Disable safety due to slow motor input
        RobotMap.drivetrainRobotDrive.setSafetyEnabled(false);
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        ultrasonic.ping();
        int right = ultrasonic.getRight();
        int left = ultrasonic.getLeft();
        System.out.println("Right: " + right);
        System.out.println("Left: " + left);
        //Check For Ball
        if(right<ignoreDistance && left<ignoreDistance){ 
            //Sees ball in one sensor but not the other
            if(right<ignoreDistance && left>ignoreDistance){
                //Sees ball on right side but not left
                //Turn right
                Robot.drivetrain.mecanumDriveXYZ(0, 0, turnSpeed);
            }else if(left<ignoreDistance && right>ignoreDistance){
                //Sees ball on left side but not right
                //Turn left
                Robot.drivetrain.mecanumDriveXYZ(0, 0, -turnSpeed);
            }else{
                //Calculate margin of error
                int distanceApart;
                if(right>left){
                    distanceApart = right-left;
                }else if(left>right){
                    distanceApart = left-right;
                }else{
                    distanceApart = 0;
                }
                //Act on distance apart
                if(distanceApart <= margin){
                    //Acceptable margin of error
                    //Stay still
                    Robot.drivetrain.mecanumDriveXYZ(0, 0, 0);
                }else if(right>left || right>ignoreDistance){
                    //Go left
                    Robot.drivetrain.mecanumDriveXYZ(-strafeSpeed, 0, 0);
                }else if(left>right || left>ignoreDistance){
                    //Go right
                    Robot.drivetrain.mecanumDriveXYZ(strafeSpeed,0,0);
                }
            }
        }else{
            Robot.drivetrain.mecanumDriveXYZ(0, 0, 0);
        }
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
    // Called once after isFinished returns true
    protected void end() {
        RobotMap.drivetrainRobotDrive.setSafetyEnabled(true);
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        RobotMap.drivetrainRobotDrive.setSafetyEnabled(true);
    }
}

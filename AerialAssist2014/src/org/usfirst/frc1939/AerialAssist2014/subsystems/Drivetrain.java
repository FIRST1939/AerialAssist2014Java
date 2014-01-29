// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc1939.AerialAssist2014.subsystems;
import org.usfirst.frc1939.AerialAssist2014.RobotMap;
import org.usfirst.frc1939.AerialAssist2014.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc1939.AerialAssist2014.Robot;
/**
 *
 */
public class Drivetrain extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController leftFront = RobotMap.drivetrainleftFront;
    SpeedController leftRear = RobotMap.drivetrainleftRear;
    SpeedController rightFront = RobotMap.drivetrainrightFront;
    SpeedController rightRear = RobotMap.drivetrainrightRear;
    RobotDrive robotDrive = RobotMap.drivetrainRobotDrive;
    Encoder leftRearEncoder = RobotMap.drivetrainleftRearEncoder;
    Encoder leftFrontEncoder = RobotMap.drivetrainleftFrontEncoder;
    Encoder rightFrontEncoder = RobotMap.drivetrainrightFrontEncoder;
    Encoder rightRearEncoder = RobotMap.drivetrainrightRearEncoder;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new DriveWithJoyStickCommand());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /*
    Drive off joysticks
    */
    public void mecanumDrive(double multiplier){
        RobotMap.drivetrainRobotDrive.mecanumDrive_Cartesian(Robot.oi.moveStick.getX()*multiplier, Robot.oi.moveStick.getY()*multiplier, Robot.oi.rotateStick.getX()*multiplier, 0.0);
    }
    
    /*
    Drive based off of x, y, and z powers
    */
    public void mecanumDriveXYZ(double x, double y, double z){
        RobotMap.drivetrainRobotDrive.mecanumDrive_Cartesian(x, y, z, 0.0);
    }
}

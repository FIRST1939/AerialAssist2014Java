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
    public static final double distancePerPulse = 8*Math.PI/100;
    public static final double slipFactor = 1;
    
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
        
        leftRearEncoder.start();
        leftRearEncoder.setDistancePerPulse(distancePerPulse);
        leftFrontEncoder.start();
        leftFrontEncoder.setDistancePerPulse(distancePerPulse);
        rightFrontEncoder.start();
        rightFrontEncoder.setDistancePerPulse(distancePerPulse);
        rightRearEncoder.start();
        rightRearEncoder.setDistancePerPulse(distancePerPulse);
    }
    
    /*
    Drive off joysticks
    */
    public void mecanumDrive(double multiplier){
        RobotMap.drivetrainRobotDrive.mecanumDrive_Cartesian(Robot.oi.moveStick.getY()*multiplier*-1, Robot.oi.moveStick.getX()*multiplier*-1, Robot.oi.rotateStick.getX()*multiplier, 0.0);
    }
    
    /*
    Drive based off of x, y, and z powers
    */
    public void mecanumDriveXYZ(double x, double y, double z){
        RobotMap.drivetrainRobotDrive.mecanumDrive_Cartesian(x, y, z, 0.0);
    }
    
    public void mecanumDrivePolar(double magnitude, double direction, double rotation){
        RobotMap.drivetrainRobotDrive.mecanumDrive_Polar(magnitude, direction, rotation);
    }
    
    public void zeroEncoders(){
        leftRearEncoder.reset();
        leftFrontEncoder.reset();
        rightFrontEncoder.reset();
        rightRearEncoder.reset();
    }
    
    //Forward and Backward
    public double getYDistance(){
        return (leftRearEncoder.getDistance()+leftFrontEncoder.getDistance()+rightFrontEncoder.getDistance()+rightRearEncoder.getDistance())/4*slipFactor;
    }
    
    //Left and Right
    public double getXDistance(){
        return (rightFrontEncoder.getDistance()-rightRearEncoder.getDistance()+leftFrontEncoder.getDistance()-leftRearEncoder.getDistance())/4*slipFactor;
    }
    
    //Find third side of triangle
    public double getDistance(){
        double x = getXDistance();
        double y = getYDistance();
        //Java 1.3 has no power function
        return Math.sqrt((x*x) + (y*y));
    }
}

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
import edu.wpi.first.wpilibj.CounterBase.EncodingType; import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc1939.AerialAssist2014.Robot;
/**
 *
 */
public class Drivetrain extends Subsystem {
    
    public static final double KY = 12.5; //Inches
    public static final double KX = 15;
    
    public static final double wheelDiamter = 8; //Inches
    public static final double numberOfTicks = 360;
    public static final double distancePerPulse = wheelDiamter*Math.PI/numberOfTicks; //Inches
    public static final double slipFactorX = 1;
    public static final double slipFactorY = 1;
    public static final double slipFactorRotation = 1;
    
    //Autonomous drive variables
    public final double autonomousDriveSpeed = 0.5;
    public final double autonomousTurnSpeed = 1.0;
    
    //Margin for joystick
    public final double margin = 0.03;
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController leftFront = RobotMap.drivetrainLeftFront;
    SpeedController rightFront = RobotMap.drivetrainRightFront;
    SpeedController leftBack = RobotMap.drivetrainLeftBack;
    SpeedController rightBack = RobotMap.drivetrainRightBack;
    RobotDrive robotDrive = RobotMap.drivetrainRobotDrive;
    Encoder leftFrontEncoder = RobotMap.drivetrainLeftFrontEncoder;
    Encoder leftBackEncoder = RobotMap.drivetrainLeftBackEncoder;
    Encoder rightFrontEncoder = RobotMap.drivetrainRightFrontEncoder;
    Encoder rightBackEncoder = RobotMap.drivetrainRightBackEncoder;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new DriveWithJoystick());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
        leftBackEncoder.start();
        leftBackEncoder.setDistancePerPulse(distancePerPulse);
        leftFrontEncoder.start();
        leftFrontEncoder.setDistancePerPulse(distancePerPulse);
        rightFrontEncoder.start();
        rightFrontEncoder.setDistancePerPulse(distancePerPulse);
        rightBackEncoder.start();
        rightBackEncoder.setDistancePerPulse(distancePerPulse);
        
        rightFrontEncoder.setReverseDirection(true);
        rightBackEncoder.setReverseDirection(true);
    }
    
    public void zeroEncoders(){
        leftBackEncoder.stop();
        leftBackEncoder.reset();
        leftBackEncoder.start();
        
        leftFrontEncoder.stop();
        leftFrontEncoder.reset();
        leftFrontEncoder.start();
        
        rightFrontEncoder.stop();
        rightFrontEncoder.reset();
        rightFrontEncoder.start();
        
        rightBackEncoder.stop();
        rightBackEncoder.reset();
        rightBackEncoder.start();
        
        rightBackEncoder.setReverseDirection(true);
        rightFrontEncoder.setReverseDirection(true);
        
        leftBackEncoder.setDistancePerPulse(distancePerPulse);
        leftFrontEncoder.setDistancePerPulse(distancePerPulse);
        rightFrontEncoder.setDistancePerPulse(distancePerPulse);
        rightBackEncoder.setDistancePerPulse(distancePerPulse);
    }
    
    //Forward and Backward
    public double getYDistance(){
        return (leftBackEncoder.getDistance()+leftFrontEncoder.getDistance()+rightFrontEncoder.getDistance()+rightBackEncoder.getDistance())/4*slipFactorY;
    }
    
    //Left and Right
    public double getXDistance(){
        return (rightFrontEncoder.getDistance()-rightBackEncoder.getDistance()+leftFrontEncoder.getDistance()-leftBackEncoder.getDistance())/4*slipFactorX;
    }
    
    //Find third side of triangle
    public double getDistance(){
        double x = getXDistance();
        double y = getYDistance();
        //Java 1.3 has no power function
        return Math.sqrt((x*x) + (y*y))/10;
    }
    
    //Get degrees turned
    public double getDegrees(){
        double LF1 = leftFrontEncoder.get()*((2*Math.PI)/360);
        double LR2 = leftBackEncoder.get()*((2*Math.PI)/360);
        double RF3 = rightFrontEncoder.get()*((2*Math.PI)/360);
        double RR4 = rightBackEncoder.get()*((2*Math.PI)/360);
        
        double E1 = (LF1/(KY -KX));
        double E2 = (LR2/(-KY+KX));
        double E3 = (RF3/(KY +KX));
        double E4 = (RR4/(-KY-KX));
        
        double radians = ((Drivetrain.wheelDiamter/2)/4)*(E1 + E2 + E3 + E4);
        return radians * (360/(2*Math.PI)) * slipFactorRotation;
    }
    
    public void drive(double multiplier){
        double x = Robot.oi.moveJoystick.getY()*multiplier*-1;
        double y = Robot.oi.moveJoystick.getX()*multiplier*-1;
        double z = Robot.oi.rotateJoystick.getX()*multiplier;
        if(Math.abs(x)<margin){
            x = 0;
        }
        if(Math.abs(y)<margin){
            y = 0;
        }
        if(Math.abs(z)<margin){
            z = 0;
        }
        
        RobotMap.drivetrainRobotDrive.mecanumDrive_Cartesian(x, y, z, 0.0);
    }
}

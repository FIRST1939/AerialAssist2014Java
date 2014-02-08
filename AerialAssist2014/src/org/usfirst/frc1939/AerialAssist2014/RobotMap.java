// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc1939.AerialAssist2014;
    
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController drivetrainleftFront;
    public static SpeedController drivetrainleftRear;
    public static SpeedController drivetrainrightFront;
    public static SpeedController drivetrainrightRear;
    public static RobotDrive drivetrainRobotDrive;
    public static Encoder drivetrainleftRearEncoder;
    public static Encoder drivetrainleftFrontEncoder;
    public static Encoder drivetrainrightFrontEncoder;
    public static Encoder drivetrainrightRearEncoder;
    public static DigitalInput photoswitchfront;
    public static DoubleSolenoid armsolenoid;
    public static SpeedController armmotor;
    public static Compressor compressor1compressor;
    public static SpeedController wallsmotor;
    public static DigitalInput wallsout;
    public static DigitalInput wallsin;
    public static Solenoid catapultright;
    public static Solenoid catapultleft;
    public static DigitalInput catapultlatched;
    public static DigitalInput catapultdown;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drivetrainleftFront = new Talon(1, 1);
	LiveWindow.addActuator("Drivetrain", "leftFront", (Talon) drivetrainleftFront);
        
        drivetrainleftRear = new Talon(1, 3);
	LiveWindow.addActuator("Drivetrain", "leftRear", (Talon) drivetrainleftRear);
        
        drivetrainrightFront = new Talon(1, 2);
	LiveWindow.addActuator("Drivetrain", "rightFront", (Talon) drivetrainrightFront);
        
        drivetrainrightRear = new Talon(1, 4);
	LiveWindow.addActuator("Drivetrain", "rightRear", (Talon) drivetrainrightRear);
        
        drivetrainRobotDrive = new RobotDrive(drivetrainleftFront, drivetrainleftRear,
              drivetrainrightFront, drivetrainrightRear);
	
        drivetrainRobotDrive.setSafetyEnabled(true);
        drivetrainRobotDrive.setExpiration(0.1);
        drivetrainRobotDrive.setSensitivity(0.5);
        drivetrainRobotDrive.setMaxOutput(1.0);
        drivetrainleftRearEncoder = new Encoder(1, 3, 1, 4, false, EncodingType.k4X);
	LiveWindow.addSensor("Drivetrain", "leftRearEncoder", drivetrainleftRearEncoder);
        drivetrainleftRearEncoder.setDistancePerPulse(1.0);
        drivetrainleftRearEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        drivetrainleftRearEncoder.start();
        drivetrainleftFrontEncoder = new Encoder(1, 1, 1, 2, false, EncodingType.k4X);
	LiveWindow.addSensor("Drivetrain", "leftFrontEncoder", drivetrainleftFrontEncoder);
        drivetrainleftFrontEncoder.setDistancePerPulse(1.0);
        drivetrainleftFrontEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        drivetrainleftFrontEncoder.start();
        drivetrainrightFrontEncoder = new Encoder(1, 5, 1, 6, true, EncodingType.k4X);
	LiveWindow.addSensor("Drivetrain", "rightFrontEncoder", drivetrainrightFrontEncoder);
        drivetrainrightFrontEncoder.setDistancePerPulse(1.0);
        drivetrainrightFrontEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        drivetrainrightFrontEncoder.start();
        drivetrainrightRearEncoder = new Encoder(1, 7, 1, 8, true, EncodingType.k4X);
	LiveWindow.addSensor("Drivetrain", "rightRearEncoder", drivetrainrightRearEncoder);
        drivetrainrightRearEncoder.setDistancePerPulse(1.0);
        drivetrainrightRearEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        drivetrainrightRearEncoder.start();
        photoswitchfront = new DigitalInput(1, 10);
	LiveWindow.addSensor("Photoswitch", "front", photoswitchfront);
        
        armsolenoid = new DoubleSolenoid(1, 3, 4);      
	
        
        armmotor = new Talon(1, 5);
	LiveWindow.addActuator("Arm", "motor", (Talon) armmotor);
        
        compressor1compressor = new Compressor(1, 11, 1, 1);
	
        
        wallsmotor = new Talon(1, 6);
	LiveWindow.addActuator("Walls", "motor", (Talon) wallsmotor);
        
        wallsout = new DigitalInput(1, 13);
	LiveWindow.addSensor("Walls", "out", wallsout);
        
        wallsin = new DigitalInput(1, 12);
	LiveWindow.addSensor("Walls", "in", wallsin);
        
        catapultright = new Solenoid(1, 1);
	LiveWindow.addActuator("Catapult", "right", catapultright);
        
        catapultleft = new Solenoid(1, 2);
	LiveWindow.addActuator("Catapult", "left", catapultleft);
        
        catapultlatched = new DigitalInput(1, 14);
	LiveWindow.addSensor("Catapult", "latched", catapultlatched);
        
        catapultdown = new DigitalInput(1, 9);
	LiveWindow.addSensor("Catapult", "down", catapultdown);
        
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        drivetrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        drivetrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
    }
}

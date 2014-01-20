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
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
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
    public static DigitalInput photoSwitchPhotoSwitch;
    public static AnalogChannel ultrasonicright;
    public static AnalogChannel ultrasonicleft;
    public static AnalogChannel ultrasonicfront;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DigitalOutput ultraSonicOutput;
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
        photoSwitchPhotoSwitch = new DigitalInput(1, 5);
	LiveWindow.addSensor("PhotoSwitch", "PhotoSwitch", photoSwitchPhotoSwitch);
        
        ultrasonicright = new AnalogChannel(1, 1);
	LiveWindow.addSensor("Ultrasonic", "right", ultrasonicright);
        
        ultrasonicleft = new AnalogChannel(1, 2);
	LiveWindow.addSensor("Ultrasonic", "left", ultrasonicleft);
        
        ultrasonicfront = new AnalogChannel(1, 3);
	LiveWindow.addSensor("Ultrasonic", "front", ultrasonicfront);
        
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        drivetrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        drivetrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
    }
}

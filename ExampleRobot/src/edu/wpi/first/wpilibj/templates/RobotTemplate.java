/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory
 */
public class RobotTemplate extends SimpleRobot {
    
    RobotDrive chasis;
    Joystick moveStick;
    Joystick rotateStick;
    Talon leftFront;
    Talon leftRear;
    Talon rightFront;
    Talon rightRear;
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    
    protected void robotInit() {
        //super.robotInit(); //To change body of generated methods, choose Tools | Templates.
        LiveWindow.setEnabled(true);
        
        leftFront = new Talon(1);
        LiveWindow.addActuator("Drivetrain", "leftFront", leftFront);
        SmartDashboard.putNumber("leftFront", leftFront.getSpeed());
        leftRear = new Talon(2);
        LiveWindow.addActuator("Drivetrain", "leftRear", leftRear);
        SmartDashboard.putNumber("leftRear", leftRear.getSpeed());
        rightFront = new Talon(3);
        LiveWindow.addActuator("Drivetrain", "rightFront", rightFront);
        SmartDashboard.putNumber("rightFront", rightFront.getSpeed());
        rightRear = new Talon(4);
        LiveWindow.addActuator("Drivetrain", "rightRear", rightRear);
        SmartDashboard.putNumber("rightRear", rightRear.getSpeed());
        
        chasis = new RobotDrive(leftFront, leftRear, rightFront, rightRear);
        chasis.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        chasis.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        
        moveStick = new Joystick(1);
        rotateStick = new Joystick(2);
        
        System.out.println("Robot Initialized");
    }
    public void autonomous() {
        chasis.setSafetyEnabled(false);
        chasis.drive(-0.5, 0.0);
        Timer.delay(2.0);
        chasis.drive(0.0, 0.0);
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        System.out.println("Entered Operator Control");
        chasis.setSafetyEnabled(false);
        leftFront.set(1.0);
        while(isOperatorControl() && isEnabled()){
            chasis.mecanumDrive_Polar(moveStick.getY(), moveStick.getX(), rotateStick.getTwist());
            Timer.delay(0.01);
        }
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    
    }
}

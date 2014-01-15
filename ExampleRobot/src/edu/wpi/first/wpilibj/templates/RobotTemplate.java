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
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    
    protected void robotInit() {
        super.robotInit(); //To change body of generated methods, choose Tools | Templates.
        
        chasis = new RobotDrive(new Talon(1, 4),new Talon(1, 3),new Talon(1, 1),new Talon(1, 2));
        moveStick = new Joystick(1);
        rotateStick = new Joystick(2);
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
        chasis.setSafetyEnabled(true);
        while(isOperatorControl() && isEnabled()){
            chasis.arcadeDrive(moveStick);
            //chasis.mecanumDrive_Polar(moveStick.getY(), moveStick.getX(), rotateStick.getTwist());
            Timer.delay(0.01);
        }
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    
    }
}

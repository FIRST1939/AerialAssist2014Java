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
/**
 *
 */
public class Arm extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    DoubleSolenoid solenoid = RobotMap.armsolenoid;
    SpeedController motor = RobotMap.armmotor;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Relay relay;
    Timer timer;
    
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        relay = new Relay(2);
        timer = new Timer();
        ((Talon) motor).setSafetyEnabled(false);
    }
    
    public void extend(){
        solenoid.set(DoubleSolenoid.Value.kReverse);
        //relay.set(Relay.Value.kForward);
        System.out.println("Extend");
    }
    
    public void retract(){
        solenoid.set(DoubleSolenoid.Value.kForward);
        //relay.set(Relay.Value.kReverse);
        System.out.println("Retract");
    }
    
    public void rollersIn(){
        timer.delay(0.5);
        motor.set(1.0);
    }
    
    public void rollersOut(){
        timer.delay(0.5);
        motor.set(-1.0);
    }
    
    public void rollersStop(){
        motor.set(0.0);
    }
}
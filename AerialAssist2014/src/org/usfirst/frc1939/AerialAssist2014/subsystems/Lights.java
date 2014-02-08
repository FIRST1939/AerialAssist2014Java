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
import edu.wpi.first.wpilibj.Relay;
import org.usfirst.frc1939.AerialAssist2014.RobotMap;
import org.usfirst.frc1939.AerialAssist2014.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class Lights extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    Relay spike1 = RobotMap.lightsspike1;
    Relay spike2 = RobotMap.lightsspike2;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setColor(int color){
        if(color == 0){
            spike1.set(Relay.Value.kOff);
            spike2.set(Relay.Value.kOff);
        }else if(color == 1){
            spike1.set(Relay.Value.kOn);
            spike2.set(Relay.Value.kOff);
        }else if (color == 2){
            spike1.set(Relay.Value.kOff);
            spike2.set(Relay.Value.kOn);
        }else if(color == 3){
            spike1.set(Relay.Value.kOn);
            spike2.set(Relay.Value.kOn);
        }
    }
}

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
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc1939.AerialAssist2014.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton extendArmButton;
    public JoystickButton retractArmButton;
    public Joystick moveStick;
    public JoystickButton wallOutButton;
    public JoystickButton wallInButton;
    public JoystickButton resetEncodersButton;
    public Joystick rotateStick;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    public JoystickButton rollersOut;
    public JoystickButton rollersIn;
    public JoystickButton toggleAssistedCatch;
    public JoystickButton drivetrainTurbo;
    public JoystickButton togglePhotoswitch;
    public JoystickButton toggleGetRoborealm;
    
    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        rotateStick = new Joystick(2);
        
        resetEncodersButton = new JoystickButton(rotateStick, 8);
        resetEncodersButton.whenPressed(new ResetEncodersCommand());
        wallInButton = new JoystickButton(rotateStick, 12);
        wallInButton.whenPressed(new WallsInCommand());
        wallOutButton = new JoystickButton(rotateStick, 10);
        wallOutButton.whenPressed(new WallsOutCommand());
        moveStick = new Joystick(1);
        
        retractArmButton = new JoystickButton(moveStick, 7);
        retractArmButton.whenPressed(new RetractArmCommand());
        extendArmButton = new JoystickButton(moveStick, 6);
        extendArmButton.whenPressed(new ExtendArmCommand());
	    
        // SmartDashboard Buttons
        SmartDashboard.putData("ExtendArmCommand", new ExtendArmCommand());
        SmartDashboard.putData("RetractArmCommand", new RetractArmCommand());
        SmartDashboard.putData("RollersInCommand", new RollersInCommand());
        SmartDashboard.putData("RollersOutCommand", new RollersOutCommand());
        SmartDashboard.putData("ShootOnTargetTestCommand", new ShootOnTargetTestCommand());
        SmartDashboard.putData("ResetEncodersCommand", new ResetEncodersCommand());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        rollersIn = new JoystickButton(rotateStick, 1);
        rollersIn.toggleWhenPressed(new RollersInCommand());
        rollersOut = new JoystickButton(rotateStick, 2);
        rollersOut.toggleWhenPressed(new RollersOutCommand());
        
        drivetrainTurbo = new JoystickButton(moveStick, 1);
    }
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getmoveStick() {
        return moveStick;
    }
    public Joystick getrotateStick() {
        return rotateStick;
    }
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

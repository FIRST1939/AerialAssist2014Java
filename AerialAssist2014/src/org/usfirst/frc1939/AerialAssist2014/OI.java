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
    public JoystickButton armInButton;
    public JoystickButton armOutButton;
    public JoystickButton kickLatchButton;
    public JoystickButton shootButton;
    public JoystickButton pressurizeCatapultButton;
    public JoystickButton depressurizeCatapultButton;
    public Joystick moveJoystick;
    public JoystickButton wallsInButton;
    public JoystickButton wallsOutButton;
    public Joystick rotateJoystick;
    public JoystickButton openButton2;
    public JoystickButton closeButton2;
    public JoystickButton toggleArmButton2;
    public JoystickButton toggleWallsButton2;
    public Joystick gamepad;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    public JoystickButton rollersOut;
    public JoystickButton rollersIn;
    public JoystickButton drivetrainTurbo;
    
    public JoystickButton rollersOut2;
    public JoystickButton rollersIn2;
    public JoystickButton halfShoot2;
    
    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        gamepad = new Joystick(3);
        
        toggleWallsButton2 = new JoystickButton(gamepad, 3);
        toggleWallsButton2.whenPressed(new ToggleWalls());
        toggleArmButton2 = new JoystickButton(gamepad, 1);
        toggleArmButton2.whenPressed(new ToggleArm());
        closeButton2 = new JoystickButton(gamepad, 5);
        closeButton2.whenPressed(new CloseEverything());
        openButton2 = new JoystickButton(gamepad, 6);
        openButton2.whenPressed(new OpenEverything());
        rotateJoystick = new Joystick(2);
        
        wallsOutButton = new JoystickButton(rotateJoystick, 10);
        wallsOutButton.whenPressed(new WallsOut());
        wallsInButton = new JoystickButton(rotateJoystick, 12);
        wallsInButton.whenPressed(new WallsIn());
        moveJoystick = new Joystick(1);
        
        depressurizeCatapultButton = new JoystickButton(moveJoystick, 10);
        depressurizeCatapultButton.whenPressed(new DepressurizeCatapult());
        pressurizeCatapultButton = new JoystickButton(moveJoystick, 11);
        pressurizeCatapultButton.whenPressed(new PressurizeCatapult());
        shootButton = new JoystickButton(moveJoystick, 8);
        shootButton.whenPressed(new Shoot());
        kickLatchButton = new JoystickButton(moveJoystick, 9);
        kickLatchButton.whenPressed(new KickLatch());
        armOutButton = new JoystickButton(moveJoystick, 6);
        armOutButton.whenPressed(new ArmOut());
        armInButton = new JoystickButton(moveJoystick, 7);
        armInButton.whenPressed(new ArmIn());
	    
        // SmartDashboard Buttons
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        rollersIn = new JoystickButton(rotateJoystick, 1);
        rollersIn.toggleWhenPressed(new ToggleRollersIn());
        rollersOut = new JoystickButton(rotateJoystick, 3);
        rollersOut.toggleWhenPressed(new ToggleRollersOut());
        
        drivetrainTurbo = new JoystickButton(moveJoystick, 1);
        
        rollersIn2 = new JoystickButton(gamepad, 2);
        rollersIn2.toggleWhenPressed(new ToggleRollersIn());
        rollersOut2 = new JoystickButton(gamepad, 4);
        rollersOut2.toggleWhenPressed(new ToggleRollersOut());
        
        halfShoot2 = new JoystickButton(gamepad, 9);
        halfShoot2.toggleWhenPressed(new ShootHalf());
    }
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getMoveJoystick() {
        return moveJoystick;
    }
    public Joystick getRotateJoystick() {
        return rotateJoystick;
    }
    public Joystick getGamepad() {
        return gamepad;
    }
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

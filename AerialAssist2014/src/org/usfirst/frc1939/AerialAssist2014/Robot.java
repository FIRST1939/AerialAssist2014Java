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
import com.sun.squawk.microedition.io.FileConnection;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.io.IOException;
import javax.microedition.io.Connector;
import org.usfirst.frc1939.AerialAssist2014.commands.*;
import org.usfirst.frc1939.AerialAssist2014.subsystems.*;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    Command autonomousCommand;
    SendableChooser autoChooser;
    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Drivetrain drivetrain;
    public static Arm arm;
    public static Rollers rollers;
    public static Compressor1 compressor1;
    public static Walls walls;
    public static Catapult catapult;
    public static Lights lights;
    public static Photoswitch photoswitch;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
	RobotMap.init();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drivetrain = new Drivetrain();
        arm = new Arm();
        rollers = new Rollers();
        compressor1 = new Compressor1();
        walls = new Walls();
        catapult = new Catapult();
        lights = new Lights();
        photoswitch = new Photoswitch();
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
	
        // instantiate the command used for the autonomous period
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        
        //Smart Dashboard Setup
        SmartDashboard.putData(Scheduler.getInstance());
        SmartDashboard.putData(arm);
        SmartDashboard.putData(walls);
        
        //Auto Chooser; Creates the menu for choosing autonomous mode
        autoChooser = new SendableChooser();
        
        autoChooser.addDefault("Command Based: Default", new CommandBasedAutonomous("file:///autonomous.txt"));
        try{
            for(int i = 1;i<100;i++){
                String location = "file:///autonomous" + i + ".txt";
                FileConnection fc = (FileConnection)Connector.open(location, Connector.READ);
                if(fc.exists()){
                    autoChooser.addObject("Command Based: " + i, new CommandBasedAutonomous(location));
                }else{
                    i = 101;
                }
            }
        }catch (IOException e){
        }
        //autoChooser.addObject("Shoot On Target Test", new ShootOnTargetTestCommand());
        SmartDashboard.putData("Autonomous Mode Chooser", autoChooser);
    }
    public void autonomousInit() {
        // schedule the autonomous command (example)
        autonomousCommand = (Command) autoChooser.getSelected();
        if (autonomousCommand != null) autonomousCommand.start();
    }
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }
    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    /**
     * This function called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}

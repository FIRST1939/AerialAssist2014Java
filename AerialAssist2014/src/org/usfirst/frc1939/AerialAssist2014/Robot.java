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
import com.sun.squawk.io.BufferedReader;
import com.sun.squawk.microedition.io.FileConnection;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.io.IOException;
import java.io.InputStreamReader;
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
    
    int counter;
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
    public static Camera camera;
    public static Trigger trigger;
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
        camera = new Camera();
        trigger = new Trigger();
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
        autoChooser = new SendableChooser();
        SmartDashboard.putData(Scheduler.getInstance());
        autoChooser.addDefault("Command Based: Default", "file:///autonomous.txt");
        for(int i = 1;i<8;i++){
            String location = "file:///autonomous" + i + ".txt";
            autoChooser.addObject("Command Based: " + i, location);
        }
        SmartDashboard.putData("Autonomous Mode Chooser", autoChooser);
        
        //Set Lights
        Robot.lights.setGreen();
        
        //Set counter
        counter = 0;
    }
    public void autonomousInit() {
        // schedule the autonomous command (example)
        String location = (String) autoChooser.getSelected();
        autonomousCommand = new CommandBasedAutonomous(location);
        if (autonomousCommand != null) autonomousCommand.start();
    }
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        this.updateDashboard();
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
        this.updateDashboard();
        Scheduler.getInstance().run();
    }
    /**
     * This function called periodically during test mode
     */
    public void testPeriodic() {
        this.updateDashboard();
        LiveWindow.run();
    }
    
    public void disabledPeriodic(){
        this.updateDashboard();
    }
    
    public void updateDashboard(){
        counter++;
        if(counter>=10){
            counter = 0;
            FileConnection fc;
            String msg = "";
            try {
                fc = (FileConnection)Connector.open((String) autoChooser.getSelected(), Connector.READ);
                if(!fc.exists()){
                    msg = "File doesn't exist";
                }else{
                    BufferedReader buf = new BufferedReader(new InputStreamReader(fc.openInputStream()));
                    String line = buf.readLine();
                    if(line == null || line.equalsIgnoreCase("")){
                        msg = "File is empty";
                    }else{
                        msg = line;
                        if(msg.substring(0,1).equalsIgnoreCase("#")){
                            msg = line.substring(1);
                        }
                    }
                }
                fc.close();
            } catch (IOException ex) {
                msg = msg + "IOException";
            }
            SmartDashboard.putString("Autonmous Selected:", msg);
        }
    }
}

// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc1939.AerialAssist2014.commands;
import com.sun.squawk.io.BufferedReader;
import com.sun.squawk.microedition.io.FileConnection;
import com.sun.squawk.util.StringTokenizer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.microedition.io.Connector;

/**
 *
 */
public class CommandBasedAutonomousGroup extends CommandGroup {
    
    public static final String fileLocation = "file:///autonomous.txt";
    
    public  CommandBasedAutonomousGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        
        try {
            //Intialize file reader
            FileConnection fc = (FileConnection)Connector.open(fileLocation, Connector.READ);
            BufferedReader buf = new BufferedReader(new InputStreamReader(fc.openInputStream()));
            
            //Intialize line variable
            String line = "";
            
            //Intialize group variables
            CommandGroup group = null;
            boolean groupParallel = false;
            
            //Read each line of file
            while((line = buf.readLine()) != null){
                boolean parallel;
                boolean noCommand = false;
                String[] a = splitString(line);
                if(a.length==0){
                    System.out.println("String splitter returned an empty array");
                }else{
                    String keyword = a[0];
                    String[] args;
                    
                    if(keyword.equalsIgnoreCase("para")){
                        parallel = true;
                        keyword = a[1];
                        args = new String[a.length-2];
                        for(int i = 2;i<a.length;i++){
                            args[i-2] = a[i];
                        }
                    }else{
                        parallel = false;
                        keyword = a[0];
                        args = new String[a.length-1];
                        for(int i = 1;i<a.length;i++){
                            args[i-1] = a[i];
                        }
                    }
                    
                    Command command = null;
                    
                    if(keyword.equalsIgnoreCase("drive")){
                        command = new AutonomousDriveCommand(args);
                    }else if(keyword.equalsIgnoreCase("turn")){
                        command = new AutonomousTurnCommand(args);
                    }else if(keyword.equalsIgnoreCase("target")){
                        command = new AutonomousTargetCommand(args);
                    }else if(keyword.equalsIgnoreCase("shoot")){
                        command = new AutonomousShootCommand();
                    }else if(keyword.equalsIgnoreCase("runrollers")){
                        command = new AutonomousRunrollersCommand(args);
                    }else if(keyword.equalsIgnoreCase("arm")){
                        command = new AutonomousArmCommand(args);
                    }else if(keyword.equalsIgnoreCase("wait")){
                        command = new AutonomousWaitCommand(args);
                    }else if(keyword.equalsIgnoreCase("wall") || keyword.equalsIgnoreCase("walls")){
                        command = new AutonomousWallsCommand(args);
                    }else if(keyword.equalsIgnoreCase("group")){
                        noCommand = true;
                        group = new CommandGroup();
                        groupParallel = parallel;
                    }else if(keyword.equalsIgnoreCase("end")){
                        noCommand = true;
                        if(groupParallel){
                            addParallel(group);
                        }else{
                            addSequential(group);
                        }
                        group = null;
                    }
                    
                    if(noCommand){
                        //Catch keywords that don't set commands
                    }else if(group != null && command != null){
                        if(parallel){
                            group.addParallel(command);
                        }else{
                            group.addSequential(command);
                        }
                    }else if(command == null){
                        System.out.println("Invalid command: '" + keyword + "'");
                    }else{
                        if(parallel){
                            addParallel(command);
                        }else{
                            addSequential(command);
                        }
                    }
                }
                
            }
            fc.close();
        } catch (IOException e) {
        }
    }
    
    /*
    Method for seperating words in String.
    */
    private String[] splitString(String s){
        StringTokenizer t = new StringTokenizer(s, " ");
        String[] a = new String[t.countTokens()];
        int count = 0;
        while(t.hasMoreTokens()){
            a[count] = t.nextToken();
            count++;
        }
        return a;
    }
}

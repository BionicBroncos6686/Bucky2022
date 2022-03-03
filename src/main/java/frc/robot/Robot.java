/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard; //this isn't being used right now, but it's really helpful for debugging.
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
@SuppressWarnings("HungarianNotationMemberVariables")
public class Robot extends TimedRobot {
  
  private RobotContainer robotContainer;
  private Command m_autonomousCommand;

  //this is where you run any initialization (teleop and auto)
  @Override
  public void robotInit() {
    robotContainer = new RobotContainer();
  }

  //this robot periodic runs once per scheduler run, but it's best not to use this to create functionality, because it's just asking for problems to do so
  @Override
  public void robotPeriodic() {
    //the most important thing that happens here is that we refresh the commandscheduler, allowing commands to execute
    CommandScheduler.getInstance().run();
  }

  //This is called as soon as you enter disabled mode.
  @Override
  public void disabledInit() {}

  //I have no idea when you would use the one below. We've always just left it alone.
  @Override
  public void disabledPeriodic() {}

  //this runs the selected auto. you can add other stuff to happen when auto is initalized here.
  @Override
  public void autonomousInit() {
    m_autonomousCommand = robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  //this method is called once per scheduler run during the autonomous periodic.
  //this is an acceptable place to put gyro corrections and stuff like that, although it's even better if use commands to do so.
  @Override
  public void autonomousPeriodic() {

  }

  //This runs when you initialize teleop. By default, autonomous gets interrupted, but you can comment out the preexisting code if you want it to continue
  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  //this method is called ever scheduler run during periodic. Putting stuff in here is more acceptable than in robotPeriodic, but still discouraged.
  //As for why it's discouraged, idk. Beats me.
  @Override
  public void teleopPeriodic() {
  }

  //runs at initiliazation during test mode
  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  //the stuff you put in testPeriodic runs when you choose test mode in driverstation
  @Override
  public void testPeriodic() {

  }

}

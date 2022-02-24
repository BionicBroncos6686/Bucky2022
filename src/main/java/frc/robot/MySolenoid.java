/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Command;

public class MySolenoid extends Command {

private DoubleSolenoid exampleSolenoid;
private boolean isFinished = false;

  public MySolenoid() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    exampleSolenoid = DrivingCode.exampleSolenoid;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(!exampleSolenoid.get().equals(DoubleSolenoid.Value.kReverse)){
      exampleSolenoid.set(DoubleSolenoid.Value.kReverse);
      SmartDashboard.putString("Solenoid State", "Reverse");
    }else{
      exampleSolenoid.set(DoubleSolenoid.Value.kForward);
      SmartDashboard.putString("Solenoid State", "Forward");
    }
    isFinished = true;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isFinished;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}

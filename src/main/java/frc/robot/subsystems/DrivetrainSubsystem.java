/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

import frc.robot.Constants.Drivetrain;;
/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DrivetrainSubsystem extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //THE PORTS FOR THE FOLLOWING 4 LINES ARE INSIDE OF constants.java under java/frc/robot. The values I gave are placeholders.
  private final Spark rightMasterMotor    = new Spark(Drivetrain.RIGHT_MASTER_PORT);
  private final Spark rightFollowerMotor  = new Spark(Drivetrain.RIGHT_FOLLOWER_PORT);
  private final Spark leftMasterMotor     = new Spark(Drivetrain.LEFT_MASTER_PORT);
  private final Spark leftFollowerMotor   = new Spark(Drivetrain.LEFT_FOLLOWER_PORT);

  private final MotorControllerGroup leftControllerGroup;
  private final MotorControllerGroup rightControllerGroup;


  private DifferentialDrive drive;

  //constructor. set inversions, neutral modes, and set followers to follow master motors
  //MUST SET INVERSIONS AFTER TESTING THEM
  public DrivetrainSubsystem() {
    rightMasterMotor  .setInverted(false);
    rightFollowerMotor.setInverted(false);
    leftMasterMotor   .setInverted(false);
    leftFollowerMotor .setInverted(false);

    leftControllerGroup = new MotorControllerGroup(leftMasterMotor, leftFollowerMotor);
    rightControllerGroup = new MotorControllerGroup(rightMasterMotor, rightFollowerMotor);

    drive = new DifferentialDrive(leftControllerGroup, rightControllerGroup);
  }

  public void drive(DoubleSupplier throttle, DoubleSupplier turn) {
    drive.arcadeDrive(throttle.getAsDouble(), turn.getAsDouble());
  }


}

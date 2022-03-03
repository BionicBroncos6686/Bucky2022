/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.Shooter;;;

public class ShooterSubsystem extends SubsystemBase {
  private final Spark shooterMotor = new Spark(Shooter.SHOOTER_PORT);

  public ShooterSubsystem() {
  }

  public void shoot(DoubleSupplier speed) {
    shooterMotor.set(speed.getAsDouble());
  }
}

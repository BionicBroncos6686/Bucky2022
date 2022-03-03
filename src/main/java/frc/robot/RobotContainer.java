package frc.robot;

import edu.wpi.first.cscore.UsbCamera;

import java.util.function.DoubleSupplier;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj2.command.*;
import frc.robot.Constants.Drivetrain;
import frc.robot.commands.DrivetrainCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.commands.DrivetrainCommand;

public class RobotContainer {
  //defining controllers
  public static final XboxController driverController = new XboxController(0);
  public static final XboxController operatorController = new XboxController(1);
  
  // Defining doublesuppliers that we will use for axis
  private DoubleSupplier throttle = () -> driverController.getLeftY();
  private DoubleSupplier turn = () -> driverController.getRightX();    

  //define subsystems
  private DrivetrainSubsystem drivetrain = new DrivetrainSubsystem();

  //set default commands for subsystems and stuff
  public RobotContainer() {
    drivetrain.setDefaultCommand(new DrivetrainCommand(drivetrain, throttle, turn));
  }

  private void configureButtonBindings() {
      //THIS IS WHERE WE WILL BIND BUTTONS WITH COMMANDS
  }

  //default wpi library for running autos
  public Command getAutonomousCommand() {
    return null;
  }

}
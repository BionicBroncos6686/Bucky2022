package frc.robot;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.Shooter;
import frc.robot.commands.DrivetrainCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class RobotContainer {
  // defining controllers
  public static final XboxController driverController = new XboxController(0);
  // public static final XboxController operatorController = new
  // XboxController(1);

  // Defining doublesuppliers that we will use for axis
  private DoubleSupplier throttle = () -> driverController.getLeftY();
  private DoubleSupplier turn = () -> driverController.getRightX();

  // define subsystems
  private DrivetrainSubsystem drivetrain = new DrivetrainSubsystem();
  private ShooterSubsystem shooter = new ShooterSubsystem();

  private static final JoystickButton lowSpeedShoot = new JoystickButton(driverController,
      XboxController.Button.kLeftBumper.value);
  private static final JoystickButton highSpeedShoot = new JoystickButton(driverController,
      XboxController.Button.kRightBumper.value);

  // set default commands for subsystems and stuff
  public RobotContainer() {
    drivetrain.setDefaultCommand(new DrivetrainCommand(drivetrain, throttle, turn));
    shooter.setDefaultCommand(new ShooterCommand(shooter, () -> 0));

    configureButtonBindings();
  }

  private void configureButtonBindings() {
    highSpeedShoot.whileHeld(new ShooterCommand(shooter, () -> Shooter.HIGH_SPEED_SHOOT));
    lowSpeedShoot.whileHeld(new ShooterCommand(shooter, () -> Shooter.LOW_SPEED_SHOOT));
  }

  // default wpi library for running autos
  public Command getAutonomousCommand() {
    return null;
  }
}
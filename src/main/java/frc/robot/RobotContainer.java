package frc.robot;

import edu.wpi.first.cscore.UsbCamera;

import java.util.function.DoubleSupplier;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class RobotContainer {
    
}


@SuppressWarnings("ALL")
public class DrivingCode extends TimedRobot {

  //defining controllers
  public static final XboxController driverController = new XboxController(0);
  public static final XboxController operatorController = new XboxController(1);
  
  // Defining doublesuppliers that we will use for axis
  private DoubleSupplier throttle = () -> driverController.getLeftY();
  private DoubleSupplier turn = () -> driverController.getRightX();

  // --Commented out by Inspection (2/10/2022 4:25 PM):public static OI m_oi;
  final Spark m_frontLeft = new Spark(1);
  final Spark m_rearLeft = new Spark(0);

  final MotorControllerGroup m_left = new MotorControllerGroup(m_frontLeft, m_rearLeft);

  final Spark m_frontRight = new Spark(3);
  final Spark m_rearRight = new Spark(2);
  final MotorControllerGroup m_right = new MotorControllerGroup(m_frontRight, m_rearRight);
  
  //static final DoubleSolenoid exampleSolenoid = new DoubleSolenoid(0, 1);

  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_left, m_right);
  public static final Joystick m_stick = new Joystick(0);

  private final Timer m_timer = new Timer();

  @Override
  public void robotInit() {
    //m_oi = new OI();
/*
 * This function is run when the robot is first started up and should be used
 * for any initialization code.
 */
    UsbCamera cam0 = CameraServer.startAutomaticCapture(0);
cam0.setResolution(320, 240);
cam0.setFPS(20);

  }
  public void update() {
    CommandScheduler.getInstance().run();
    m_robotDrive.arcadeDrive(throttle.getAsDouble(), turn.getAsDouble());
  }
  

  /**
   * This function is run once each time the robot enters autonomous mode.
   */
  @Override
  public void autonomousInit() {
    m_timer.reset();
    m_timer.start();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    update();
  }

  /**
   * This function is called once each time the robot enters teleoperated mode.
   */
  @Override
  public void teleopInit() {
  }

  /**
   * This function is called periodically during teleoperated mode.
   */
  @Override
  public void teleopPeriodic() {
    update();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

  }
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.AutoTest;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ChassisSubsystem;
import frc.robot.subsystems.CompressorSubsystem;
import frc.robot.subsystems.GrabSubsystem;
import edu.wpi.first.vision.VisionThread;
import edu.wpi.first.vision.VisionRunner;
//import org.usfirst.frc.team486.grip.MyVisionPipeline;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */


public class Robot extends TimedRobot {
  //Initializing the subsystems
  public static ChassisSubsystem drive = new ChassisSubsystem();
  public static ArmSubsystem arm = new ArmSubsystem();
  public static CompressorSubsystem compressor = new CompressorSubsystem();
  public static GrabSubsystem grab = new GrabSubsystem();
  public static OI m_oi;

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  public static final int image_width = 240;
  public static final int image_height = 320;

  /**
  private VisionThread vision_thread;
  private double centerX = 0.0;
  private final Object image_lock = new Object();
  */

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */ 
  @Override
  public void robotInit() {
    m_oi = new OI();
    //Autonomous chooser
    m_chooser.addOption("AutoTest", new AutoTest());
    //Initializing the camera stream
    UsbCamera server = CameraServer.getInstance().startAutomaticCapture();
    server.setResolution(image_width, image_height);

    /** AUTONOMOUS VISION PROCESSING
    vision_thread = new VisionThread(server, new MyVisionPipe, pipeline -> {
      if (!pipeline.filterContoursOutput().isEmpty()) {
          Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
          synchronized (imgLock) {
              centerX = r.x + (r.width / 2);
          }
      }
    });
    vision_thread.start();
    */

    //Starting the compressor
    Robot.compressor.compressor_start();
    //Calibration of the gyro
    Robot.drive.gyro_calibrate();
    //Reseting the arm encoder
    Robot.arm.arm_encoder_reset();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    if(Robot.arm.arm_encoder_distance()>150 && Robot.arm.arm_encoder_distance()<450){
      Robot.compressor.arm_retract();
    }
    else if (Robot.arm.arm_encoder_distance()>450 && !Robot.m_oi.opstick_arm_retract.get()){
      Robot.compressor.arm_extend();
    }
    else if(Robot.arm.arm_encoder_distance()>3 && Robot.arm.arm_encoder_distance()<150 && !Robot.m_oi.opstick_arm_retract.get()){
      Robot.compressor.arm_extend();
    }
    SmartDashboard.putBoolean("Arm Extention", Robot.compressor.arm_extend_get());
    SmartDashboard.putBoolean("Middle Rocket Button", Robot.m_oi.station_rocket_middle.get());
    SmartDashboard.putNumber("Arm Encoder", Robot.arm.arm_encoder_distance());

    /** AUTONOMOUS VISION PROCESSING
    double centerX;
    synchronized(image_lock){
      centerX = this.centerX;
    }
    double offset = centerX - (image_width/2);

    if(Robot.m_oi.left_vision_drive_button.get() || Robot.m_oi.right_vision_drive_button.get()){
      Robot.drive.arcade_drive(0.5, offset * 0.005);
    }
    */
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

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

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
} 
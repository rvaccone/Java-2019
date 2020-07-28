/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;

/**
 * Add your docs here.
 */
public class ChassisSubsystem extends Subsystem {
  //Initializing the motors
  private Talon left_motor = new Talon(RobotMap.left_motor_port);
  private Talon right_motor = new Talon(RobotMap.right_motor_port);
  private DifferentialDrive drive = new DifferentialDrive(left_motor, right_motor);
  //Initializing the gyro
  private Gyro gyro = new AnalogGyro(1);
  //Initializing the encoders
  private Encoder left_encoder = new Encoder(RobotMap.left_encoder0_port, RobotMap.left_encoder1_port);
  private Encoder right_encoder = new Encoder(RobotMap.right_encoder0_port, RobotMap.right_encoder1_port);

  //Drive functions
  public void drive(double lspeed, double rspeed){
    this.drive.tankDrive(-lspeed, -rspeed);
  }
  public void straight_drive(double speed, double kP){
    this.drive.arcadeDrive(-speed, this.gyro.getAngle()*kP);
  }
  public void arcade_drive(double speed, double kp){
    this.drive.arcadeDrive(-speed, kp);
  }
  //Gyro functions
  public double gyro_angle(){
    return -1 * this.gyro.getAngle();
  }
  public void gyro_reset(){
    this.gyro.reset();
  }
  public void gyro_calibrate(){
    this.gyro.calibrate();
  }
  //Encoder functions
  public void encoders_reset(){
    this.left_encoder.reset();
    this.right_encoder.reset();
  }
  public double left_encoder_rate(){
    return this.left_encoder.getRate();
  }
  public double right_encoder_rate(){
    return this.right_encoder.getRate();
  }
  public double left_encoder_raw(){
    return this.left_encoder.getRaw();
  }
  public double right_encoder_raw(){
    return this.right_encoder.getRaw();
  }
  public double left_encoder_distance(){
    return this.left_encoder.getDistance();
  }
  public double right_encoder_distance(){
    return this.right_encoder.getDistance();
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveCommand());
  }
}
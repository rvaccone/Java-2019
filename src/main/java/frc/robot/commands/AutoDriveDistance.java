/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class AutoDriveDistance extends Command {
  private double inches, speed;
  double ratio = 13.2629119243;
  double kP = 0.1;
  double conversion;

  public AutoDriveDistance(double inches_in, double speed_in) {
    this.inches = inches_in;
    this.speed = speed_in;
    this.conversion = (-1*(this.inches/Math.abs(this.inches)));
    requires(Robot.drive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.drive.gyro_reset();
    //Robot.drive.encoders_reset();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.drive.straight_drive(this.speed, this.kP);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(Math.abs(Robot.drive.left_encoder_distance())>=Math.abs((this.ratio*this.inches)) && (-1*(Math.abs(Robot.drive.right_encoder_distance())))<=(-1*(Math.abs(this.inches*this.ratio)))){
      return true;
    }
    else{
      return false;
    }
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.drive.drive(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.drive.drive(0, 0);
  }
}
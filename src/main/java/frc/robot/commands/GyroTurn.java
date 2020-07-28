/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class GyroTurn extends Command {
  double angle, speed;
  double threshold = 3;
  
  public GyroTurn(double angle_in, double speed_in) {
    this.angle = angle_in;
    this.speed = speed_in;
    requires(Robot.drive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.drive.gyro_reset();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (this.angle<0){
      //Turning right
      Robot.drive.drive(-this.speed, this.speed);
    }
    else{
      //Turning left
      Robot.drive.drive(this.speed, -this.speed);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    double offset = Math.abs(this.angle - Robot.drive.gyro_angle());
    return (offset<threshold);
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

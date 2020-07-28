/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveCommand extends Command {
  public DriveCommand() {
    requires(Robot.drive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(!Robot.m_oi.left_vision_drive_button.get() && !Robot.m_oi.right_vision_drive_button.get()){
      if(!Robot.m_oi.left_drive_slow_button.get() || !Robot.m_oi.right_drive_slow_button.get()){
        if(Robot.m_oi.left_drive_invert_button.get() || Robot.m_oi.right_drive_invert_button.get()){
          Robot.drive.drive(-Robot.m_oi.left_stick.getY(), -Robot.m_oi.right_stick.getY());
        } else {
          Robot.drive.drive(Robot.m_oi.right_stick.getY(), Robot.m_oi.left_stick.getY());
        }
      }
      else{
        Robot.drive.drive(Robot.m_oi.right_stick.getY()/2, Robot.m_oi.left_stick.getY()/2);
      }
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
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

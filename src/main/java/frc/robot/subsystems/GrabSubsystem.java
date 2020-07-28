/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.GrabCommand;

/**
 * Add your docs here.
 */
public class GrabSubsystem extends Subsystem {
  //Initializing the motors
  private Talon grab_motor1 = new Talon(RobotMap.grab_motor1_port);
  private Talon grab_motor0 = new Talon(RobotMap.grab_motor0_port);
  private DifferentialDrive arm_grab = new DifferentialDrive(grab_motor0, grab_motor1);

  public void grab_set(double speed) {
    this.arm_grab.tankDrive(-speed, speed);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new GrabCommand());
  }
}

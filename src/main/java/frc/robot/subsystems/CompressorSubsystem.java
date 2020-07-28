/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


/**
 * Add your docs here.
 */
public class CompressorSubsystem extends Subsystem {
  //Initializing the compressor
  private Compressor compressor = new Compressor();
  //Solenoid
  private Solenoid arm_solenoid = new Solenoid(RobotMap.arm_solenoid_port);
  private Solenoid back_stinger_soldenoid = new Solenoid(RobotMap.back_stinger_solenoid_port);
  private Solenoid pivot_solenoid = new Solenoid(RobotMap.pivot_solenoid_port);
  private Solenoid front_stinger_solenoid = new Solenoid(RobotMap.front_stinger_solenoid_port);
  private Solenoid push_solenoid = new Solenoid(RobotMap.push_solenoid_port);
  private Solenoid punch_solenoid = new Solenoid(RobotMap.punch_solenoid_port);
  //Compressor functions
  public void compressor_start(){
    this.compressor.start();
  }
  //Arm functions
  public void arm_extend(){
    this.arm_solenoid.set(true);
  }
  public void arm_retract(){
    this.arm_solenoid.set(false);
  }
  public boolean arm_extend_get(){
    return this.arm_solenoid.get();
  }
  //Back stinger functions
  public void back_stinger_extend(){
    this.back_stinger_soldenoid.set(true);
  }
  public void back_stinger_retract(){
    this.back_stinger_soldenoid.set(false);
  }
  //Pivot functions
  public void pivot_vertical(){
    this.pivot_solenoid.set(false);
  }
  public void pivot_horizontal(){
    this.pivot_solenoid.set(true);
  }
  public boolean pivot_get(){
    return this.pivot_solenoid.get();
  }
  //Front stinger functions
  public void front_stinger_extend(){
    this.front_stinger_solenoid.set(true);
  }
  public void front_stinger_retract(){
    this.front_stinger_solenoid.set(false);
  }
  //Push functions
  public void push_extend(){
    this.push_solenoid.set(true);
  }
  public void push_retract(){
    this.push_solenoid.set(false);
  }
  public boolean push_get(){
    return this.push_solenoid.get();
  }
  //Punch functions
  public void punch_extend(){
    this.punch_solenoid.set(true);
  }
  public void punch_retract(){
    this.punch_solenoid.set(false);
  }

  @Override
  public void initDefaultCommand() {
    // setDefaultCommand(new MySpecialCommand());
  }
}

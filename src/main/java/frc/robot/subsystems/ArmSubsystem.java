/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ArmCommand;

/**
 * Add your docs here.
 */
public class ArmSubsystem extends Subsystem {
  //Initializing the motors
  private Talon arm_motor = new Talon(RobotMap.arm_motor_port);
  //Initializing the encoders
  private Encoder arm_encoder = new Encoder(RobotMap.arm_encoder0_port, RobotMap.arm_encoder1_port);
  
  public void arm_set(double speed) {
    this.arm_motor.set(speed);
  }
  public double arm_encoder_rate(){
    return this.arm_encoder.getRate();
  }
  public double arm_encoder_raw(){
    return this.arm_encoder.getRaw();
  }
  public double arm_encoder_distance(){
    return this.arm_encoder.getDistance();
  }
  public void arm_encoder_reset(){
    this.arm_encoder.reset();
  }
  public void arm_pwr(double target, double speed){
    if(target> this.arm_encoder_distance()){
      this.arm_motor.set(speed);
    }
    else if (target < this.arm_encoder_distance()){
      this.arm_motor.set(-speed*0.25);
    }
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ArmCommand());
  }
}
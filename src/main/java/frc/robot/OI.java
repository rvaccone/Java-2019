/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //Initializing the joysticks
  public Joystick op_stick = new Joystick(RobotMap.op_stick_port);
  public Joystick left_stick = new Joystick(RobotMap.left_stick_port);
  public Joystick right_stick = new Joystick(RobotMap.right_stick_port);
  public Joystick station_stick = new Joystick(RobotMap.station_stick_port);
  //Initializing the left drivestick joystick buttons
  public JoystickButton front_stringer_extend = new JoystickButton(left_stick, RobotMap.stinger_extend_port);
  public JoystickButton front_stringer_retract = new JoystickButton(left_stick, RobotMap.stinger_retract_port);
  public JoystickButton left_drive_slow_button = new JoystickButton(left_stick, RobotMap.drive_slow_button_port);
  public JoystickButton left_drive_invert_button = new JoystickButton(left_stick, RobotMap.drive_invert_button_port);
  public JoystickButton left_vision_drive_button= new JoystickButton(left_stick, RobotMap.vision_drive_button_port);
  //Initializing the right drivestick joystick buttons
  public JoystickButton back_stinger_extend = new JoystickButton(right_stick, RobotMap.stinger_extend_port);
  public JoystickButton back_stringer_retract = new JoystickButton(right_stick, RobotMap.stinger_retract_port);
  public JoystickButton right_drive_slow_button = new JoystickButton(right_stick, RobotMap.drive_slow_button_port);
  public JoystickButton right_drive_invert_button = new JoystickButton(right_stick, RobotMap.drive_invert_button_port);
  public JoystickButton right_vision_drive_button = new JoystickButton(right_stick, RobotMap.vision_drive_button_port);
  //Initializing the opstick joystick buttons
  public JoystickButton grab_trigger_button = new JoystickButton(op_stick, RobotMap.grab_button_port);
  public JoystickButton opstick_grab_invert_button = new JoystickButton(op_stick, RobotMap.grab_invert_button_port);
  public JoystickButton opstick_arm_retract = new JoystickButton(op_stick, RobotMap.arm_retract_port);
  public JoystickButton opstick_pivot = new JoystickButton(op_stick, RobotMap.pivot_button_port);
  public JoystickButton opstick_punch = new JoystickButton(op_stick, RobotMap.punch_button_port);
  public JoystickButton opstick_push_extend = new JoystickButton(op_stick, RobotMap.push_extend_port);
  public JoystickButton opstick_ball_higher_button = new JoystickButton(op_stick, RobotMap.ball_higher_button_port);
  public JoystickButton opstick_ball_lower_button = new JoystickButton(op_stick, RobotMap.ball_lower_button_port);
  //Initializing the station joystick buttons
  public JoystickButton station_rocket_low = new JoystickButton(station_stick, RobotMap.rocket_low_port);
  public JoystickButton station_rocket_middle = new JoystickButton(station_stick, RobotMap.rocket_middle_port);
  public JoystickButton station_rocket_high = new JoystickButton(station_stick, RobotMap.rocket_high_port);

  public OI(){
    //Drivestick commands
    this.back_stinger_extend.whenPressed(new BackStingerExtend());
    this.back_stringer_retract.whenPressed(new BackStingerRetract());
    this.front_stringer_extend.whenPressed(new FrontStingerExtend());
    this.front_stringer_retract.whenPressed(new FrontStingerRetract());
    //Button commands
    this.opstick_arm_retract.whileActive(new ArmRetract());
    this.opstick_pivot.whileActive(new PivotVertical());
    this.opstick_punch.whileActive(new PunchCommand());
    this.opstick_push_extend.whileActive(new PushExtend());
    this.grab_trigger_button.whileActive(new GrabCommand());
    this.opstick_ball_higher_button.whileActive(new CargoBallHigh());
    this.opstick_ball_lower_button.whileActive(new CargoBallLow());
    //station commands
    this.station_rocket_low.whileActive(new RocketArmLow());
    this.station_rocket_middle.whileActive(new RocketArmMiddle());
    this.station_rocket_high.whileActive(new RocketArmHigh());
  }
}
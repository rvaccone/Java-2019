/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  //Joystick ports
  public static int op_stick_port = 2;
  public static int left_stick_port = 1;
  public static int right_stick_port = 0;
  public static int station_stick_port = 4;
  
  //Drive joystick buttons
  public static int stinger_extend_port= 3;
  public static int stinger_retract_port = 2;
  public static int drive_slow_button_port = 1;
  public static int drive_invert_button_port = 5;
  public static int vision_drive_button_port = 4;

  //Opstick joystick buttons
  public static int grab_button_port = 1;
  public static int arm_retract_port = 7;
  public static int punch_button_port = 3;
  public static int pivot_button_port = 2;
  public static int push_extend_port = 4;
  public static int grab_invert_button_port = 5;
  public static int ball_higher_button_port = 9;
  public static int ball_lower_button_port = 8;

  //Station joystick buttons
  public static int rocket_low_port = 3;
  public static int rocket_middle_port = 5;
  public static int rocket_high_port = 6;

  //PWMS
  public static int left_motor_port = 1;
  public static int right_motor_port = 0;
  public static int arm_motor_port = 2;
  public static int grab_motor0_port = 3;
  public static int grab_motor1_port = 4;

  //DIO
  public static int left_encoder0_port = 0;
  public static int left_encoder1_port = 1;
  public static int right_encoder0_port = 2;
  public static int right_encoder1_port = 3;
  public static int arm_encoder0_port = 4;
  public static int arm_encoder1_port = 5;

  //Solenoid00
  public static int arm_solenoid_port = 1;
  public static int back_stinger_solenoid_port = 2;
  public static int pivot_solenoid_port = 3;
  public static int front_stinger_solenoid_port = 4;
  public static int push_solenoid_port = 5;
  public static int punch_solenoid_port = 0;

  //Arm encoder values
  public static double rocket_low_arm_encoder = 148.5;
  public static double rocket_middle_arm_encoder = 324.5;
  public static double rocket_high_arm_encoder = 532.25;
  public static double cargo_ball_arm_encoder = 275.25;
  public static double floor_ball_arm_encoder = 77.5;
  public static double arm_encoder_threshold = 6;
  public static double arm_encoder_speed = 0.725;
  }
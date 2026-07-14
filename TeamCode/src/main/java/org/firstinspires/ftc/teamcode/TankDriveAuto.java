package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "Tank Drive Auto")
public class TankDriveAuto extends LinearOpMode {

    // TODO (Step 3): declare your motor variables here, same as in TankDriveTeleOp.
    // 4-motor drivetrains need leftFront, leftBack, rightFront, rightBack.
    // 2-motor (true tank) drivetrains only need leftFront and rightFront.


    @Override
    public void runOpMode() {

        // TODO (Step 3): hardwareMap your motors here. Copy these lines from TankDriveTeleOp.


        // TODO (Step 3): Copy the motor configuration and reverse lines here too



        waitForStart();

        // TODO (Step 5): drive forward at half (0.5) power for 3 seconds, then stop.


    }

    // TODO (Step 7): write your drive(forwardSpeed, turnSpeed, time) function here.
    private void drive(double forwardSpeed, double turnSpeed, double time) {

    }

}
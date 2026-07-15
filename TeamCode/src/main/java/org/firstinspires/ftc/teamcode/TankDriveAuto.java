package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "Tank Drive Auto")
public class TankDriveAuto extends LinearOpMode {
    private DcMotor leftFront;
    private DcMotor leftBack;
    private DcMotor rightFront;
    private DcMotor rightBack;

    // TODO (Step 3): declare your motor variables here, same as in TankDriveTeleOp.
    // 4-motor drivetrains need leftFront, leftBack, rightFront, rightBack.
    // 2-motor (true tank) drivetrains only need leftFront and rightFront.


    @Override
    public void runOpMode() {
        // Initialize hardware components
        // TODO (Step 3): hardwareMap your motors here. Copy these lines from TankDriveTeleOp.
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        // TODO: Initialize the other three wheels here (leftBack, rightFront, rightBack)

        // TODO (Step 3): Copy the motor configuration and reverse lines here too
        // Configure motors
        leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftFront.setPower(0.0);

        leftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBack.setPower(0.0);

        rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setPower(0.0);

        rightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setPower(0.0);

        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.REVERSE);
        // TODO: Configure the other three wheels the same way

        // The right-side motors are mounted facing the opposite direction, so we reverse
        // them so that positive power always means "drive forward" on both sides.
        // TODO: rightFront.setDirection(DcMotor.Direction.REVERSE);
        // TODO: rightBack.setDirection(DcMotor.Direction.REVERSE);



        waitForStart();
        drive(0.5,0,2);
        drive(-0.5,0,2);
        drive(0.0,0.5,2);
        drive(0.0,-0.5,2);
        /* rightFront.setPower(0.5);
        rightBack.setPower(0.5);
        leftFront.setPower(0.5);
        leftBack.stPower(0.5);
        sleep(3000);
        rightFront.setPower(0.0);
        rightBack.setPower(0.0);
        leftFront.setPower(0.0);
        leftBack.setPower(0.0);*/



        // TODO (Step 5): drive forward at half (0.5) power for 3 seconds, then stop.


    }

    // TODO (Step 7): write your drive(forwardSpeed, turnSpeed, time) function here.
    private void drive(double forwardSpeed, double turnSpeed, double time) {
        // TODO: Calculate "leftPower" from forwardSpeed and turnSpeed
        double leftPower = forwardSpeed-turnSpeed;
        // TODO: Calculate "rightPower" from forwardSpeed and turnSpeed
        double rightPower = forwardSpeed+turnSpeed;

        rightFront.setPower(rightPower);
        rightBack.setPower(rightPower);
        leftFront.setPower(leftPower);
        leftBack.setPower(leftPower);
        sleep((long)(time*1000));
        rightFront.setPower(0.0);
        rightBack.setPower(0.0);
        leftFront.setPower(0.0);
        leftBack.setPower(0.0);
    }

}
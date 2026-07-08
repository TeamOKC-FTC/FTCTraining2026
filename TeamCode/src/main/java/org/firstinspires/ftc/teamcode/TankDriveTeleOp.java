package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Tank Drive")
public class TankDriveTeleOp extends LinearOpMode {
    private DcMotor leftFront;
    private DcMotor leftBack;
    private DcMotor rightFront;
    private DcMotor rightBack;
    // TODO: Create three more wheel variables here (leftBack, rightFront, rightBack)

    @Override
    public void runOpMode() {
        // Initialize hardware components
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        // TODO: Initialize the other three wheels here (leftBack, rightFront, rightBack)

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

        while (opModeIsActive()) {
            double forwardSpeed = gamepad1.right_stick_y*-1;
            // TODO: Create a "forwardSpeed" variable from a gamepad axis

            double turnSpeed = gamepad1.right_stick_x*-1;
            // TODO: Create a "turnSpeed" variable from a gamepad axis


            // TODO: Calculate "leftPower" from forwardSpeed and turnSpeed
            double leftPower = forwardSpeed-turnSpeed;
            // TODO: Calculate "rightPower" from forwardSpeed and turnSpeed
            double rightPower = forwardSpeed+turnSpeed;

            // TODO: Set power on all four wheel motors

            //   Set the power of BOTH left motors to leftPower
            leftFront.setPower(leftPower);
            leftBack.setPower(leftPower);
            rightFront.setPower(rightPower);
            rightBack.setPower(rightPower);

            //   Set the power of BOTH right motors to rightPower

            telemetry.update();
        }
    }
}

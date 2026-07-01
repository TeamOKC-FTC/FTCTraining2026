package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

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
        // TODO: Initialize the other three wheels here (leftBack, rightFront, rightBack)

        // Configure motors
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftFront.setPower(0.0);
        // TODO: Configure the other three wheels the same way

        // The right-side motors are mounted facing the opposite direction, so we reverse
        // them so that positive power always means "drive forward" on both sides.
        rightFront.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()) {
            // TODO: Create a "forwardSpeed" variable from a gamepad axis

            // TODO: Create a "turnSpeed" variable from a gamepad axis
            double forwardSpeed =-gamepad1.right_stick_y;
            double turnSpeed = -gamepad1.right_stick_x;


            // TODO: Calculate "leftPower" from forwardSpeed and turnSpeed
            double leftPower = forwardSpeed-turnSpeed;
            // TODO: Calculate "rightPower" from forwardSpeed and turnSpeed
            double rightPower = forwardSpeed+turnSpeed;

            // TODO: Set power on all four wheel motors

            //   Set the power of BOTH left motors to leftPower
            leftFront.setPower(leftPower);

            //   Set the power of BOTH right motors to rightPower

            telemetry.update();
        }
    }
}

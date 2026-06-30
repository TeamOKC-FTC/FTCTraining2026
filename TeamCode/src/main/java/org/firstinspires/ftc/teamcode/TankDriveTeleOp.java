package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Tank Drive")
public class TankDriveTeleOp extends LinearOpMode {
    private DcMotor leftFront;
    // TODO: Create three more wheel variables here (leftBack, rightFront, rightBack)

    @Override
    public void runOpMode() {
        // Initialize hardware components
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        // TODO: Initialize the other three wheels here (leftBack, rightFront, rightBack)

        // Configure motors
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftFront.setPower(0.0);
        // TODO: Configure the other three wheels the same way

        // The right-side motors are mounted facing the opposite direction, so we reverse
        // them so that positive power always means "drive forward" on both sides.
        // TODO: rightFront.setDirection(DcMotor.Direction.REVERSE);
        // TODO: rightBack.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()) {
            // TODO: Create a "forwardSpeed" variable from a gamepad axis

            // TODO: Create a "turnSpeed" variable from a gamepad axis


            // TODO: Calculate "leftPower" from forwardSpeed and turnSpeed
            double leftPower = 0.0;
            // TODO: Calculate "rightPower" from forwardSpeed and turnSpeed
            double rightPower = 0.0;

            // TODO: Set power on all four wheel motors

            //   Set the power of BOTH left motors to leftPower
            leftFront.setPower(leftPower);

            //   Set the power of BOTH right motors to rightPower

            telemetry.update();
        }
    }
}

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;

@TeleOp(name="PD Controller")
public class PDOpMode extends LinearOpMode {
    private TouchSensor touchSensor;
    private DcMotor motor;

    @Override
    public void runOpMode() {
        // Initialize hardware components
        touchSensor = hardwareMap.get(TouchSensor.class, "testTouch");
        motor = hardwareMap.get(DcMotor.class, "testMotor");

        // Configure the motor
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor.setPower(0.0);

        // Set our controller targets positions (in encoder ticks)
        int defaultPosition = 0; // Position to target when the button is not pressed
        int pressedPosition = 1000; // Position to target when the button is pressed

        waitForStart();

        while (opModeIsActive()) {
            if (touchSensor.isPressed()) {
                // While the button is pressed, move the motor
                motor.setPower(0.3);
            } else {
                // When the button is not pressed, stop the motor
                motor.setPower(0.0);
            }

            // Display encoder ticks
            telemetry.addData("Encoder Ticks", motor.getCurrentPosition());
            telemetry.update();
        }
    }
}

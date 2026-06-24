package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;

@TeleOp(name="Move To Position")
public class MoveToPositionOpMode extends LinearOpMode {
    private TouchSensor touchSensor;
    private DcMotor motor;

    @Override
    public void runOpMode() {
        touchSensor = hardwareMap.get(TouchSensor.class, "testTouch");
        motor = hardwareMap.get(DcMotor.class, "testMotor");

        // Configure the motor
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor.setPower(0.0);

        waitForStart();

        while (opModeIsActive()) {
            if (motor.getCurrentPosition() <960) {
                motor.setPower(0.4);
            } else {
                motor.setPower(0.0);
            }

            telemetry.addData("Encoder Ticks", motor.getCurrentPosition());
            telemetry.update();
        }
    }
}

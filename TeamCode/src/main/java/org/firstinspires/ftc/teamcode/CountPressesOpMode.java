package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.TouchSensor;

@TeleOp(name="Count Presses")
public class CountPressesOpMode extends LinearOpMode {
    private TouchSensor touchSensor;

    @Override
    public void runOpMode() {
        touchSensor = hardwareMap.get(TouchSensor.class, "testTouch");

        waitForStart();

        while (opModeIsActive()) {
            int pressCount = 0; // Our counter variable

            if (touchSensor.isPressed()) {
                pressCount = pressCount + 1;
            }

            telemetry.addData("Sensor Press Count", pressCount);
            telemetry.update();
        }
    }
}

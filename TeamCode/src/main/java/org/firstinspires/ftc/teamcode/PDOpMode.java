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
        //pid values
        double kP=.03;//propotinal gain
        double kD=0.01; //derivative gain

        double lastError =0.0;//tracks previous error

        waitForStart();

        while (opModeIsActive()) {
            int targetPosition=defaultPosition;
            if (touchSensor.isPressed()){
                targetPosition=pressedPosition;

            }

            double error = targetPosition- motor.getCurrentPosition(); //calculate error
            double derivative=error-lastError;//calculate derivative

            //calculate power using PD control
            double power=(error*kP)+(derivative*kD);

            motor.setPower(power);
            lastError=error;
            // Display encoder ticks
            telemetry.addData("Encoder Ticks", motor.getCurrentPosition());
            telemetry.update();
        }
    }
}

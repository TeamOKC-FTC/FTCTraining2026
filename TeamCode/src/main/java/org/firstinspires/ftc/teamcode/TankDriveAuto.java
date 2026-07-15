package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "Tank Drive Auto")
public class TankDriveAuto extends LinearOpMode {
    private DcMotor leftFront;
    private DcMotor leftBack;
    private DcMotor rightFront;
    private DcMotor rightBack;

    private Servo  prism;
    // TODO (Step 3): declare your motor variables here, same as in TankDriveTeleOp.
    // 4-motor drivetrains need leftFront, leftBack, rightFront, rightBack.
    // 2-motor (true tank) drivetrains only need leftFront and rightFront.


    @Override
    public void runOpMode() {
        motorinilization();


        // TODO (Step 3): hardwareMap your motors here. Copy these lines from TankDriveTeleOp.

        double starttime = 0;
        boolean driveFoward = false;
        boolean doneFoward = false;
        prism.setPosition(.223);


        waitForStart();
        drive(0.8,1,10);
        drive(-.5,.2,2);
        drive(0,1,5);
        drive(1,1,2);




        // TODO (Step 5): drive forward at half (0.5) power for 3 seconds, then stop.
    }


    // TODO (Step 7): write your drive(forwardSpeed, turnSpeed, time) function here.
    private void drive(double forwardSpeed, double turnSpeed, double time) {
        double starttime = 0;

        starttime = getRuntime();
        rightFront.setPower(forwardSpeed+turnSpeed);
        rightBack.setPower(forwardSpeed+turnSpeed);
        leftBack.setPower(forwardSpeed-turnSpeed);
        leftFront.setPower(forwardSpeed-turnSpeed);
        while (opModeIsActive()) {


            if (getRuntime() - starttime > time) {
                rightBack.setPower(0.0);
                leftBack.setPower(0);
                rightFront.setPower(0);
                leftFront.setPower(0);
                return;


            }

        }

    }
    void motorinilization(){
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        prism=hardwareMap.get(Servo.class,"prism");

        leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftFront.setPower(0.0);
        leftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBack.setPower(0.0);
        rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setPower(0.0);     // The right-side motors are mounted facing the opposite direction, so we reverse
        rightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);   // them so that positive power always means "drive forward" on both sides.
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setPower(0.0);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);

    }
}

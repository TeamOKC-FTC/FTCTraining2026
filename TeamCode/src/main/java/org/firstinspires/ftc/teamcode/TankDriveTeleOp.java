package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Tank Drive")
public class TankDriveTeleOp extends LinearOpMode {
    private DcMotor leftFront;
    private DcMotor leftBack;
    private DcMotor rightFront;
    private DcMotor rightBack;


    @Override
    public void runOpMode() {
        // Initialize hardware components
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");

        boolean autoTurn;

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
        rightBack.setDirection(DcMotor.Direction.REVERSE);
        double startTime = 0;
        autoTurn = false;
        waitForStart();
        while (opModeIsActive()) {



            if (gamepad1.aWasPressed()) {
               startTime = getRuntime();
                telemetry.addData("timer",startTime);
                rightBack.setPower(1);
                leftBack.setPower(-1);
                telemetry.update();
                autoTurn=true;


            }

            else if (!autoTurn){
                double forwardSpeed = -gamepad1.left_stick_y;


                double turnSpeed = gamepad1.right_stick_x;

                double leftPower = forwardSpeed + turnSpeed;

                double rightPower = forwardSpeed - turnSpeed;
                leftFront.setPower(leftPower);
                leftBack.setPower(leftPower);
                //   Set the power of BOTH right motors to rightPower
                rightFront.setPower(rightPower);
                rightBack.setPower(rightPower);

            }
            if (autoTurn&&getRuntime() - startTime > 3.0) {

                rightBack.setPower(0);
                leftBack.setPower(0);
                autoTurn=false;


            }



            }
        }
                //   Set the power of BOTH left motors to leftPower

            }







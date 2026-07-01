package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Motor Finder")
public class MotorFinderOp extends LinearOpMode {
    private DcMotor leftFront;
    private DcMotor leftBack;
    private DcMotor rightFront;
    private DcMotor rightBack;

    @Override
    public void runOpMode() {
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack  = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack  = hardwareMap.get(DcMotor.class, "rightBack");

        waitForStart();

        while (opModeIsActive()) {
            leftFront.setPower(gamepad1.a ? 1.0 : 0.0);
            leftBack.setPower(gamepad1.b ? 1.0 : 0.0);
            rightFront.setPower(gamepad1.x ? 1.0 : 0.0);
            rightBack.setPower(gamepad1.y ? 1.0 : 0.0);

            telemetry.addLine("Hold A=leftFront  B=leftBack  X=rightFront  Y=rightBack");
            telemetry.addData("leftFront  (A)", leftFront.getPower());
            telemetry.addData("leftBack   (B)", leftBack.getPower());
            telemetry.addData("rightFront (X)", rightFront.getPower());
            telemetry.addData("rightBack  (Y)", rightBack.getPower());
            telemetry.update();
        }
    }
}

package org.team4631.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(name = "Ross: Teleop", group = "Ross")
public class TeleopRoss extends OpMode {

    private HardwareRoss hardwareRoss;

    /* How far the trigger buttons on game pad one need to be pushed to trigger. */
    private static final double leftTriggerPushThreshold = 0.5;
    private static final double rightTriggerPushThreshold = 0.5;
    private static final double drivetrainServosSpeed = 0.75;

    /* The speed percentage of the drivetrain. */
    private double drivetrainSpeedPercentage = 0.7;

    /* Runs once when initialize button is pressed. */
    @Override
    public void init() {
        /* Initialize hardware. */
        hardwareRoss = new HardwareRoss();
        hardwareRoss.init(HardwareRoss.HardwareMode.COMPETITION, hardwareMap);
    }

    /* Runs repeatedly after initialize button is pressed but play button is not. */
    @Override
    public void init_loop() {

    }

    /* Runs once when play button is pressed. */
    @Override

    public void start() {

    }

    /* Runs repeatedly after play button is pressed but stop button is not. */
    @Override
    public void loop() {

        if (gamepad1.dpad_up) {
            drivetrainSpeedPercentage += 0.001;
        }

        if (gamepad1.dpad_down) {
            drivetrainSpeedPercentage -= 0.001;
        }

        if (drivetrainSpeedPercentage < 0.3) {
            drivetrainSpeedPercentage = 0.3;
        }

        if (drivetrainSpeedPercentage > 1.0) {
            drivetrainSpeedPercentage = 1.0;
        }

        telemetry.clear();
        telemetry.addData("Drivetrain speed percentage: ", drivetrainSpeedPercentage);

        double left;
        double right;

        left = -gamepad1.left_stick_y;
        right = -gamepad1.right_stick_y;
        left *= drivetrainSpeedPercentage;
        right *= drivetrainSpeedPercentage;

        hardwareRoss.leftFrontMotor.setPower(left);
        hardwareRoss.leftBackMotor.setPower(left);
        hardwareRoss.rightFrontMotor.setPower(right);
        hardwareRoss.rightBackMotor.setPower(right);

        if (gamepad1.right_bumper && gamepad1.left_bumper) {
            hardwareRoss.leftFrontServo.setPower(-drivetrainServosSpeed);
            hardwareRoss.leftBackServo.setPower(-drivetrainServosSpeed);
            hardwareRoss.rightFrontServo.setPower(-drivetrainServosSpeed);
            hardwareRoss.rightBackServo.setPower(-drivetrainServosSpeed);
        } else if (gamepad1.left_trigger > leftTriggerPushThreshold
                && gamepad1.right_trigger > rightTriggerPushThreshold) {
            hardwareRoss.leftFrontServo.setPower(drivetrainServosSpeed);
            hardwareRoss.leftBackServo.setPower(drivetrainServosSpeed);
            hardwareRoss.rightFrontServo.setPower(drivetrainServosSpeed);
            hardwareRoss.rightBackServo.setPower(drivetrainServosSpeed);
        } else {
            hardwareRoss.leftFrontServo.setPower(0);
            hardwareRoss.leftBackServo.setPower(0);
            hardwareRoss.rightFrontServo.setPower(0);
            hardwareRoss.rightBackServo.setPower(0);
        }

        if (gamepad1.a) {
            hardwareRoss.landerLatchServo.setPosition(0);
        }

        if (gamepad1.y) {
            hardwareRoss.landerLatchServo.setPosition(1);
        }
    }


    /* Runs once when stop button is pressed. */
    @Override
    public void stop() {

    }

}

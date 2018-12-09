package org.team4631.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.concurrent.TimeUnit;

@Autonomous(name = "Ross: Autonomous Gold", group = "Ross")
public class AutoRossGold extends LinearOpMode {

    private HardwareRoss hardwareRoss;

    /* Objects and values needed to drop the motors at the start of autonomous. */

    private static final double MOTOR_DROP_TIME = 4;

    private ElapsedTime motorDropTimer;
    private double motorDropStartTime;
    private double motorDropEndTime;

    @Override
    public void runOpMode() throws InterruptedException {
        /* Initialize hardware. */
        hardwareRoss = new HardwareRoss();
        hardwareRoss.init(HardwareRoss.HardwareMode.COMPETITION, hardwareMap);

        /* Set the servo position to 1. */
        hardwareRoss.landerLatchServo.setPosition(1.0);

        waitForStart();

        /* Dummy wait loop; robot sometimes skips first step. */


        ElapsedTime dummyLoopTimer;
        double dummyLoopStartTime;
        double dummyLoopEndTime;

        dummyLoopTimer = new ElapsedTime();
        dummyLoopTimer.reset();
        dummyLoopStartTime = dummyLoopTimer.now(TimeUnit.SECONDS);
        dummyLoopEndTime = dummyLoopStartTime + 0.5;

        /* Dummy wait loop. */
        while (opModeIsActive()) {
            if (dummyLoopTimer.now(TimeUnit.SECONDS) > dummyLoopEndTime) {
                /* Exit step. */
                break;
            }
        }

        motorDropTimer = new ElapsedTime();
        motorDropTimer.reset();
        motorDropStartTime = motorDropTimer.now(TimeUnit.SECONDS);
        motorDropEndTime = motorDropStartTime + MOTOR_DROP_TIME;

        /* First step. */
        while (opModeIsActive()) {
            if (motorDropTimer.now(TimeUnit.SECONDS) < motorDropEndTime) {
                hardwareRoss.leftFrontServo.setPower(-1.0);
                hardwareRoss.leftBackServo.setPower(-1.0);
                hardwareRoss.rightFrontServo.setPower(-1.0);
                hardwareRoss.rightBackServo.setPower(-1.0);
            } else {
                hardwareRoss.leftFrontServo.setPower(0.0);
                hardwareRoss.leftBackServo.setPower(0.0);
                hardwareRoss.rightFrontServo.setPower(0.0);
                hardwareRoss.rightBackServo.setPower(0.0);

                /* Exit step. */
                break;
            }
        }

        ElapsedTime servoPullBackElapsed;
        double servoPullBackStartTime;
        double servoPullBackEndTime;

        servoPullBackElapsed = new ElapsedTime();
        servoPullBackElapsed.reset();
        servoPullBackStartTime = servoPullBackElapsed.now(TimeUnit.SECONDS);
        servoPullBackEndTime = servoPullBackStartTime + 0.5;

        /* Second step. */
        while (opModeIsActive()) {
            /* Unlatch servo. */

            hardwareRoss.landerLatchServo.setPosition(0.0);

            if (servoPullBackElapsed.now(TimeUnit.SECONDS) > servoPullBackEndTime) {
                /* Exit step. */
                break;
            }
        }

        ElapsedTime servosDownTimer;
        double servosDownStartTime;
        double servosDownEndTime;

        servosDownTimer = new ElapsedTime();
        servosDownTimer.reset();
        servosDownStartTime = servosDownTimer.now(TimeUnit.SECONDS);
        servosDownEndTime = servosDownStartTime + 4;

        /* Third step. */
        while (opModeIsActive()) {
            if (servosDownTimer.now(TimeUnit.SECONDS) < servosDownEndTime) {
                hardwareRoss.leftFrontServo.setPower(1.0);
                hardwareRoss.leftBackServo.setPower(1.0);
                hardwareRoss.rightFrontServo.setPower(1.0);
                hardwareRoss.rightBackServo.setPower(1.0);
            } else {
                hardwareRoss.leftFrontServo.setPower(0.0);
                hardwareRoss.leftBackServo.setPower(0.0);
                hardwareRoss.rightFrontServo.setPower(0.0);
                hardwareRoss.rightBackServo.setPower(0.0);

                /* Exit step. */
                break;
            }
        }

        ElapsedTime motorPullUpTimer;
        double motorPullUpStartTime;
        double motorPullUpEndTime;

        motorPullUpTimer = new ElapsedTime();
        motorPullUpTimer.reset();
        motorPullUpStartTime = motorPullUpTimer.now(TimeUnit.SECONDS);
        motorPullUpEndTime = motorPullUpStartTime + 2.5;

        /* Third step. */
        while (opModeIsActive()) {
            if (motorPullUpTimer.now(TimeUnit.SECONDS) < motorPullUpEndTime) {
                hardwareRoss.leftFrontMotor.setPower(0.4);
                hardwareRoss.leftBackMotor.setPower(0.4);
                hardwareRoss.rightFrontMotor.setPower(0.4);
                hardwareRoss.rightBackMotor.setPower(0.4);
            } else {
                hardwareRoss.leftFrontMotor.setPower(0.0);
                hardwareRoss.leftBackMotor.setPower(0.0);
                hardwareRoss.rightFrontMotor.setPower(0.0);
                hardwareRoss.rightBackMotor.setPower(0.0);

                /* Exit step. */
                break;
            }
        }

        /* Fourth step. */

        ElapsedTime servoDropFullTimer;
        double servoDropFullStartTime;
        double servoDropFullEndTime;

        servoDropFullTimer = new ElapsedTime();
        servoDropFullTimer.reset();
        servoDropFullStartTime = servoDropFullTimer.now(TimeUnit.SECONDS);
        servoDropFullEndTime = servoDropFullStartTime + 1.0;

        while (opModeIsActive()) {
            if (servoDropFullTimer.now(TimeUnit.SECONDS) < servoDropFullEndTime) {
                hardwareRoss.leftFrontServo.setPower(1.0);
                hardwareRoss.leftBackServo.setPower(1.0);
                hardwareRoss.rightFrontServo.setPower(1.0);
                hardwareRoss.rightBackServo.setPower(1.0);
            } else {
                hardwareRoss.leftFrontServo.setPower(0.0);
                hardwareRoss.leftBackServo.setPower(0.0);
                hardwareRoss.rightFrontServo.setPower(0.0);
                hardwareRoss.rightBackServo.setPower(0.0);
                /* Exit step. */
                break;
            }
        }

        ElapsedTime servoReleaseTimer;
        double servoReleaseStartTime;
        double servoReleaseEndTime;

        servoReleaseTimer = new ElapsedTime();
        servoReleaseTimer.reset();
        servoReleaseStartTime = servoReleaseTimer.now(TimeUnit.SECONDS);
        servoReleaseEndTime = servoReleaseStartTime + 0.5;

        /* Fifth step. */
        while (opModeIsActive()) {
            /* Release servo. */

            hardwareRoss.markerServo.setPosition(1.0);

            if (servoReleaseTimer.now(TimeUnit.SECONDS) > servoReleaseEndTime) {
                /* Exit step. */
                break;
            }
        }

        ElapsedTime servoFlipBackTimer;
        double servoFlipBackStartTime;
        double servoFlipBackEndTime;

        servoFlipBackTimer = new ElapsedTime();
        servoFlipBackTimer.reset();
        servoFlipBackStartTime = servoFlipBackTimer.now(TimeUnit.SECONDS);
        servoFlipBackEndTime = servoFlipBackStartTime + 0.5;

        /* Sixth step. */
        while (opModeIsActive()) {
            /* Flip back servo. */

            hardwareRoss.markerServo.setPosition(0.0);

            if (servoFlipBackTimer.now(TimeUnit.SECONDS) > servoFlipBackEndTime) {
                /* Exit step. */
                break;
            }
        }

        ElapsedTime motorPullBackTimer;
        double motorPullBackStartTime;
        double motorPullBackEndTime;

        motorPullBackTimer = new ElapsedTime();
        motorPullBackTimer.reset();
        motorPullBackStartTime = motorPullBackTimer.now(TimeUnit.SECONDS);
        motorPullBackEndTime = motorPullBackStartTime + 0.5;

        /* Seventh step. */
        while (opModeIsActive()) {
            if (motorPullBackTimer.now(TimeUnit.SECONDS) < motorPullBackEndTime) {
                hardwareRoss.leftFrontMotor.setPower(-0.4);
                hardwareRoss.leftBackMotor.setPower(-0.4);
                hardwareRoss.rightFrontMotor.setPower(-0.4);
                hardwareRoss.rightBackMotor.setPower(-0.4);
            } else {
                hardwareRoss.leftFrontMotor.setPower(0.0);
                hardwareRoss.leftBackMotor.setPower(0.0);
                hardwareRoss.rightFrontMotor.setPower(0.0);
                hardwareRoss.rightBackMotor.setPower(0.0);

                /* Exit step. */
                break;
            }
        }
    }

}

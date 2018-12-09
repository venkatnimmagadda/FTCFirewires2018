package org.team4631.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.concurrent.TimeUnit;

@Autonomous(name = "Ross: Autonomous Silver", group = "Ross")
public class AutoRossSilver extends LinearOpMode {

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
        motorPullUpEndTime = motorPullUpStartTime + 1.5;

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
    }

}

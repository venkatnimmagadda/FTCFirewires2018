package org.team4631.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class HardwareRoss {

    enum HardwareMode {
        COMPETITION, TESTING
    }

    public DcMotor rightFrontMotor = null;
    public DcMotor rightBackMotor = null;
    public DcMotor leftFrontMotor = null;
    public DcMotor leftBackMotor = null;

    public CRServo rightFrontServo = null;
    public CRServo rightBackServo = null;
    public CRServo leftFrontServo = null;
    public CRServo leftBackServo = null;

    public Servo landerLatchServo = null;
    public Servo markerServo = null;

    private HardwareMode hardwareMode = HardwareMode.TESTING;
    private HardwareMap hardwareMap = null;

    HardwareRoss() {

    }

    public boolean init(HardwareMode hardwareMode, HardwareMap hardwareMap) {
        this.hardwareMode = hardwareMode;
        this.hardwareMap = hardwareMap;

        /*  Initialize motors. */
        rightFrontMotor = hardwareMap.get(DcMotor.class, "rightFrontMotor");
        rightBackMotor = hardwareMap.get(DcMotor.class, "rightBackMotor");
        leftFrontMotor = hardwareMap.get(DcMotor.class, "leftFrontMotor");
        leftBackMotor = hardwareMap.get(DcMotor.class, "leftBackMotor");

        /* Reverse right motors and keep left motors on forward because they are on opposite sides. */
        leftFrontMotor.setDirection(DcMotor.Direction.FORWARD);
        leftBackMotor.setDirection(DcMotor.Direction.FORWARD);
        rightFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        rightBackMotor.setDirection(DcMotor.Direction.REVERSE);

        /* Set all motors to zero power. */
        leftFrontMotor.setPower(0);
        leftBackMotor.setPower(0);
        rightFrontMotor.setPower(0);
        rightBackMotor.setPower(0);

        /* Set motors to run without encoders. */
        leftFrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftBackMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBackMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        /* Initialize servos. */
        leftFrontServo = hardwareMap.get(CRServo.class, "leftFrontServo");
        leftBackServo = hardwareMap.get(CRServo.class, "leftBackServo");
        rightFrontServo = hardwareMap.get(CRServo.class, "rightFrontServo");
        rightBackServo = hardwareMap.get(CRServo.class, "rightBackServo");

        landerLatchServo = hardwareMap.get(Servo.class, "landerLatchServo");
        markerServo = hardwareMap.get(Servo.class, "markerServo");

        /* Set directions of servos. */
        leftFrontServo.setDirection(CRServo.Direction.REVERSE);
        leftBackServo.setDirection(CRServo.Direction.FORWARD);
        rightFrontServo.setDirection(CRServo.Direction.FORWARD);
        rightBackServo.setDirection(CRServo.Direction.REVERSE);

        landerLatchServo.setDirection(Servo.Direction.FORWARD);
        markerServo.setDirection(Servo.Direction.FORWARD);

        /* Set all continuous servos to zero power. */
        leftFrontServo.setPower(0);
        leftBackServo.setPower(0);
        rightFrontServo.setPower(0);
        rightBackServo.setPower(0);

        markerServo.setPosition(0.0);

        return true;
    }

    public HardwareMode getHardwareMode() {
        return hardwareMode;
    }

    public void setHardwareMode(HardwareMode hardwareMode) {
        this.hardwareMode = hardwareMode;
    }

}

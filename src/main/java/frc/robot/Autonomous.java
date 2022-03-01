package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Timer;

public class Autonomous {
    AutoRobotAction useRobot;
    Timer timer;
    int autoStep;
    AHRS ahrs;
    // AutoGyroAction useGyro;
    /* */

    public Autonomous(AutoRobotAction useRobot, AHRS ahrs, Timer timer) {

        
        //this.useGyro = useGyro;
        this.useRobot = useRobot;
        this.ahrs = ahrs;
        this.timer = timer;
        autoStep = 0;
    
      }

    public void resetStep() {
        autoStep = 0;
    }

    public void dumpEscapeDR() {
        if(autoStep == 0) {
            if(timer.get() < 2.0){
                useRobot.intakeForward();
            }
            else {
                autoStep = 1;
                timer.reset();
                timer.start();
                ahrs.reset();
            }
        }
        else if(autoStep == 1) {
            if(timer.get() < 5.0) {
                useRobot.DriveBack();
            }
            else {
                autoStep = 2;
                timer.reset();
                timer.start();
                ahrs.reset();
            }
        }
    }

    public void dumpEscape() {
        if(autoStep == 0) {
            if(timer.get() < 2.0) {
                useRobot.intakeForward();
            }
            else {
                autoStep = 1;
                timer.reset();
                timer.start();
                ahrs.reset();
            }
        }
        else if(autoStep == 2) {
            if(timer.get() < 5.0) {
                useRobot.driveStraightBackward();
            }
            else {
                autoStep = 2;
                timer.reset();
                timer.start();
                ahrs.reset();
            }
        }
    }

    public void DumpPickUp() {
        if(autoStep == 0) {
            if(timer.get() < 2.0) {
                useRobot.intakeForward();
            }
            else {
                autoStep = 1;
                timer.reset();
                timer.start();
                ahrs.reset();
            }
        }
        else if(autoStep == 1) {
            if( timer.get() < 2.0) {
                useRobot.DriveBack();
            }            
            else {
                timer.reset();
                timer.start();
                ahrs.reset();
            }
        }
        else if(autoStep == 2) {
            if(timer.get() < 5.0) {
                useRobot.rotateToAngle(180);
            }
            else {
                autoStep = 2;
                timer.reset();
                timer.start();
                ahrs.reset();
            }
        }
        else if(autoStep == 3) {
            if(timer.get() < 5.0) {
                useRobot.driveStraightEncoder(1);
                useRobot.intakeForward();
            }
            else {
                autoStep = 3;
                timer.reset();
                timer.start();
                ahrs.reset();
            }
        }
    }

    public void auto4() {
        
    }

}

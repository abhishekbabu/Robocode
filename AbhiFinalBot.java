/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robots;

import java.awt.Color;
import robocode.*;

/**
 *
 * @author abhishekbabu
 */
public class FirstRobot extends AdvancedRobot {

    int count = 0;
    double gunTurnAmt;

    public void run() {
        setColors(Color.RED, Color.MAGENTA, Color.CYAN);
        setAdjustGunForRobotTurn(true);
        gunTurnAmt = Math.PI / 18;
        while (true) {
            setTurnGunRightRadians(gunTurnAmt);
            count++;
            if (count > 2) {
                gunTurnAmt = -1 * Math.PI / 18;
            }
            if (count > 5) {
                gunTurnAmt = Math.PI / 18;
            }
            execute();
        }
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent e) {

        // Reset count
        count = 0;

        // If the target is too far away, turn and move toward it
        if (e.getDistance() > 100) {
            gunTurnAmt = robocode.util.Utils.normalRelativeAngle(e.getBearingRadians() + getHeadingRadians() - getRadarHeadingRadians());
            setTurnGunRightRadians(gunTurnAmt);
            setTurnRight(e.getBearing());
            setFire(0.5);
            setAhead(e.getDistance() - 90);
            return;
        }

        // The target is close
        gunTurnAmt = robocode.util.Utils.normalRelativeAngle(e.getBearingRadians() + getHeadingRadians() - getRadarHeadingRadians());
        setTurnGunRightRadians(gunTurnAmt);
        setFire(1);

        // If the target is too close, back up
        if (e.getDistance() < 75) {
            if (e.getBearing() > -90 && e.getBearing() <= 90) {
                setBack(20);
            } else {
                setAhead(20);
            }
        }
        scan();
    }

    /**
     * onWin: Do a victory dance
     */
    @Override
    public void onWin(WinEvent e) {
        for (int i = 0; i < 50; i++) {
            turnRight(30);
            turnLeft(30);
        }
    }

}

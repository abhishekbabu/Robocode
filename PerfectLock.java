/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstbot;

import robocode.AdvancedRobot;
import robocode.ScannedRobotEvent;
import robocode.util.Utils;

/**
 *
 * @author babuabh18
 */
public class PerfectLock extends AdvancedRobot {

    public void run() {
        turnRadarRightRadians(Double.POSITIVE_INFINITY);
        do {
            scan();
        } while (true);
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        fire(0.5);
        double radarTurn = getHeadingRadians() + e.getBearingRadians() - getRadarHeadingRadians();
        setTurnRadarRightRadians(Utils.normalRelativeAngle(radarTurn));
    }

}

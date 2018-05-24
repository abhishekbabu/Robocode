/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstbot;

import robocode.Robot;
import robocode.ScannedRobotEvent;

/**
 *
 * @author babuabh18
 */
public class FirstBot extends Robot{

    public void run() {
        while (true) {
            ahead(100);
            turnGunRight(360);
            back(100);
            turnGunRight(360);
        }
    }
    
    public void onScannedRobot(ScannedRobotEvent e) {
        fire(1);
    }
    
}

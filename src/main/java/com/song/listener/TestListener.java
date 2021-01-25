package com.song.listener;

import org.springframework.stereotype.Service;

/**
 * @ClassName TestListener
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2020-09-29 10:54
 */
@Service
public class TestListener {
    public static void main(String[] args) {
//        Robot robot = new Robot();
//        robot.registerListener(new MyRobotListener());
//        robot.dancing();
//        robot.working();

//        RobotTop top = new RobotTop() {
//            @Override
//            public void work() {
//
//            }
//
//            @Override
//            public void dance() {
//
//            }
//        }

        GoodRobot r2 = new GoodRobot();
        r2.registerListener(new MyRobotListener());
        r2.dancing();
        r2.working();

    }
}

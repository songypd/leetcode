package com.song.listener;

/**
 * @ClassName TestListener
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2020-09-29 10:54
 */
public class TestListener {
    public static void main(String[] args) {
        Robot robot = new Robot();
//        robot.registerListener(new MyRobotListener());
        robot.dancing();
        robot.working();

    }
}

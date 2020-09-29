package com.song.listener;

/**
 * @ClassName MyRobotListener
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2020-09-29 10:52
 */
public class MyRobotListener implements RobotListener {
    @Override
    public void working(Event event) {
        Robot robot = event.getRobot();
        System.out.println("我即将监视机器人工作");
    }

    @Override
    public void dancing(Event event) {
        Robot robot = event.getRobot();
        System.out.println("我即将观赏机器人跳舞");
    }
}

package com.song.listener;

/**
 * @ClassName Robot
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2020-09-29 10:37
 */
//时间源
public class Robot {

    private RobotListener robotListener;


    public void registerListener(RobotListener robotListener) {
        this.robotListener = robotListener;
    }

    public void working() {
        if (robotListener != null) {
            Event event = new Event(this);
            this.robotListener.working(event);
        }
        System.out.println("机器人正在工作");
    }

    public void dancing() {
        if (robotListener != null) {
            Event event = new Event(this);
            this.robotListener.dancing(event);
        }

        System.out.println("机器人正在跳舞");
    }
}

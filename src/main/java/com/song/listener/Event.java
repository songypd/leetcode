package com.song.listener;

/**
 * @ClassName Enevt
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2020-09-29 10:42
 */
public class Event {

    private Robot robot;

    public Event() {
        super();
    }

    public Event(Robot robot) {
        super();
        this.robot = robot;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }
}

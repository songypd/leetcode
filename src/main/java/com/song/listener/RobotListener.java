package com.song.listener;

/**
 * @ClassName RobotListener
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2020-09-29 10:41
 */
public interface RobotListener {
    void working(Event event);

    void dancing(Event event);

    void working();

    void dancing();
}

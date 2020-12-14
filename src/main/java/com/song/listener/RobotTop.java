package com.song.listener;

/**
 * @ClassName RobotTop
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2020-12-14 12:03
 */
public abstract class RobotTop {

    private RobotListener robotListener;


    public void registerListener(RobotListener robotListener) {
        this.robotListener = robotListener;
    }

    public void working(){
        if (robotListener != null){
            robotListener.dancing();
        }
        work();
    }

    public void dancing(){
        if (robotListener != null){
            robotListener.dancing();
        }
        dance();
    }



    public abstract void work();

    public abstract void dance();
}

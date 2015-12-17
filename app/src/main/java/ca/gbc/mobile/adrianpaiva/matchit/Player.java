package ca.gbc.mobile.adrianpaiva.matchit;

import java.io.Serializable;

/*
*************************************************
* Adrian Paiva
* 100864588
* ‎Friday, ‎October ‎3, ‎2014
* lastEdit: October ‎11, ‎2014
**************************************************/
public class Player implements Serializable {

    private String name;
    private long time;
    private String timeString;


    public Player(String name, long time, String timeString) {
        this.name = name;
        this.time = time;
        this.timeString = timeString;
    }
    public String toString()
    {
        return "Player [name=" + name + ", time=" + time + ", timeString=" + timeString
                + "]";
        /*
        StringBuffer buffer = new StringBuffer();
        buffer.append(name);
        buffer.append(timeString);
        buffer.append(time);


        return buffer.toString();
        */
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getTimeString() {
        return timeString;
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }
}

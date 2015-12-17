package ca.gbc.mobile.adrianpaiva.matchit;

import java.util.ArrayList;

/*
*************************************************
* Adrian Paiva
* 100864588
* ‎Friday, ‎October ‎11, ‎2014
* lastEdit: October ‎11, ‎2014
**************************************************/
public class ScoreBoard {

    private static ArrayList<Player> list = new ArrayList<Player>();

    public ArrayList<Player> getPlayers()
    {
        return list;
    }
    public void addPlayer(String name, long time, String timeString)
    {

        list.add( new Player(name, time, timeString) );
    }
}

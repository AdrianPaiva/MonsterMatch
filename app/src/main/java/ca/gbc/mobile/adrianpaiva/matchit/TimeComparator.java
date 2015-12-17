package ca.gbc.mobile.adrianpaiva.matchit;

import java.util.Comparator;

/*
*************************************************
* Adrian Paiva
* 100864588
* created: ‎Monday, ‎October ‎11, ‎2014
* lastEdit: October ‎11, ‎2014
**************************************************/
public class TimeComparator implements Comparator<Player> {


    @Override
    public int compare(Player player, Player player2) {
        if (player.getTime() < player2.getTime()) {
            return -1;
        } else if (player.getTime() > player2.getTime()) {
            return 1;
        }
        return 0;
    }
}

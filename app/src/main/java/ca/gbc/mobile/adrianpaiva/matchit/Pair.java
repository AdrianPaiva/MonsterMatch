package ca.gbc.mobile.adrianpaiva.matchit;

/*
*************************************************
* Adrian Paiva
* 100864588
* ‎Friday, ‎October ‎3, ‎2014
* lastEdit: October ‎11, ‎2014
**************************************************/
public class Pair {

    private Card first;
    private Card second;

    public Pair(Card first, Card second) {
        this.first = first;
        this.second = second;
    }

    public Card getFirst() {
        return first;
    }

    public void setFirst(Card first) {
        this.first = first;
    }

    public Card getSecond() {
        return second;
    }

    public void setSecond(Card second) {
        this.second = second;
    }
}

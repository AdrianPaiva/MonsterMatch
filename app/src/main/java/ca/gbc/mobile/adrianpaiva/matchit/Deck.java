package ca.gbc.mobile.adrianpaiva.matchit;

import java.util.ArrayList;
import java.util.Collections;

/*
*************************************************
* Adrian Paiva
* 100864588
* ‎Friday, ‎October ‎3, ‎2014
* lastEdit: October ‎11, ‎2014
**************************************************/

public class Deck {

    private ArrayList<Pair> deck;
    private Pair p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25;
    private Pair[] randomPairs;
    private ArrayList<Card> randomCards;

    public Deck() {
        randomCards = new ArrayList<Card>();
        randomPairs = new Pair[6];

        Card c1 = new Card(R.drawable.one,1);
        Card c2 = new Card(R.drawable.one,1);
        Card c3 = new Card(R.drawable.two,2);
        Card c4 = new Card(R.drawable.two,2);
        Card c5 = new Card(R.drawable.three,3);
        Card c6 = new Card(R.drawable.three,3);
        Card c7 = new Card(R.drawable.four,4);
        Card c8 = new Card(R.drawable.four,4);
        Card c9 = new Card(R.drawable.five,5);
        Card c10 = new Card(R.drawable.five,5);

        Card c11 = new Card(R.drawable.six,7);
        Card c12 = new Card(R.drawable.six,7);
        Card c13 = new Card(R.drawable.seven,8);
        Card c14 = new Card(R.drawable.seven,8);
        Card c15 = new Card(R.drawable.eight,9);
        Card c16 = new Card(R.drawable.eight,9);
        Card c17 = new Card(R.drawable.nine,10);
        Card c18 = new Card(R.drawable.nine,10);
        Card c19 = new Card(R.drawable.ten,11);
        Card c20 = new Card(R.drawable.ten,11);
        Card c21 = new Card(R.drawable.eleven,12);
        Card c22 = new Card(R.drawable.eleven,12);
        Card c23 = new Card(R.drawable.twelve,13);
        Card c24 = new Card(R.drawable.twelve,13);

        Card c25 = new Card(R.drawable.thirteen,14);
        Card c26 = new Card(R.drawable.thirteen,14);
        Card c27 = new Card(R.drawable.fourteen,15);
        Card c28 = new Card(R.drawable.fourteen,15);
        Card c29 = new Card(R.drawable.fifteen,16);
        Card c30 = new Card(R.drawable.fifteen,16);
        Card c31 = new Card(R.drawable.sixteen,17);
        Card c32 = new Card(R.drawable.sixteen,17);
        Card c33 = new Card(R.drawable.seventeen,18);
        Card c34 = new Card(R.drawable.seventeen,18);
        Card c35 = new Card(R.drawable.eighteen,19);
        Card c36 = new Card(R.drawable.eighteen,19);
        Card c37 = new Card(R.drawable.nineteen,20);
        Card c38 = new Card(R.drawable.nineteen,20);
        Card c39 = new Card(R.drawable.twenty,21);
        Card c40 = new Card(R.drawable.twenty,21);
        Card c41 = new Card(R.drawable.twentyone,22);
        Card c42 = new Card(R.drawable.twentyone,22);
        Card c43 = new Card(R.drawable.twentytwo,23);
        Card c44 = new Card(R.drawable.twentytwo,23);
        Card c45 = new Card(R.drawable.twentythree,24);
        Card c46 = new Card(R.drawable.twentythree,24);
        Card c47 = new Card(R.drawable.twentyfour,25);
        Card c48 = new Card(R.drawable.twentyfour,25);
        Card c49 = new Card(R.drawable.twentyfive,6);
        Card c50 = new Card(R.drawable.twentyfive,6);

        p1 = new Pair(c1,c2);
        p2 = new Pair(c3,c4);
        p3 = new Pair(c5,c6);
        p4 = new Pair(c7,c8);
        p5 = new Pair(c9,c10);
        p6 = new Pair(c11,c12);
        p7 = new Pair(c13,c14);
        p8 = new Pair(c15,c16);
        p9 = new Pair(c17,c18);
        p10 = new Pair(c19,c20);
        p11 = new Pair(c21,c22);
        p12 = new Pair(c23,c24);
        p13 = new Pair(c25,c26);
        p14 = new Pair(c27,c28);
        p15 = new Pair(c29,c30);
        p16 = new Pair(c31,c32);
        p17 = new Pair(c33,c34);
        p18 = new Pair(c35,c36);
        p19 = new Pair(c37,c38);
        p20 = new Pair(c39,c40);
        p21 = new Pair(c41,c42);
        p22 = new Pair(c43,c44);
        p23 = new Pair(c45,c46);
        p24 = new Pair(c47,c48);
        p25 = new Pair(c49,c50);

        deck = new ArrayList<Pair>()
        {{
                add(p1);
                add(p2);
                add(p3);
                add(p4);
                add(p5);
                add(p6);
                add(p7);
                add(p8);
                add(p9);
                add(p10);
                add(p11);
                add(p12);
                add(p13);
                add(p14);
                add(p15);
                add(p16);
                add(p17);
                add(p18);
                add(p19);
                add(p20);
                add(p21);
                add(p22);
                add(p23);
                add(p24);
                add(p25);

        }};

        Collections.shuffle(deck);// randomize pairs


        randomizeCards();

    }

    public ArrayList<Card> getRandomCards()
    {
        return randomCards;
    }
    public void randomizeCards()
    {
        randomPairs[0] = deck.get(0);
        randomPairs[1] = deck.get(1);
        randomPairs[2] = deck.get(2);
        randomPairs[3] = deck.get(3);
        randomPairs[4] = deck.get(4);
        randomPairs[5] = deck.get(5);

        randomCards.add(randomPairs[0].getFirst());
        randomCards.add(randomPairs[0].getSecond());
        randomCards.add(randomPairs[1].getFirst());
        randomCards.add(randomPairs[1].getSecond());
        randomCards.add(randomPairs[2].getFirst());
        randomCards.add(randomPairs[2].getSecond());
        randomCards.add(randomPairs[3].getFirst());
        randomCards.add(randomPairs[3].getSecond());
        randomCards.add(randomPairs[4].getFirst());
        randomCards.add(randomPairs[4].getSecond());
        randomCards.add(randomPairs[5].getFirst());
        randomCards.add(randomPairs[5].getSecond());

        Collections.shuffle(randomCards);
    }
}

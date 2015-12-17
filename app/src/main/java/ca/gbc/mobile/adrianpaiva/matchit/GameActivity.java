package ca.gbc.mobile.adrianpaiva.matchit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

/*
*************************************************
* Adrian Paiva
* 100864588
* ‎Friday, ‎October ‎3, ‎2014
* lastEdit: October ‎11, ‎2014
**************************************************/

public class GameActivity extends Activity  {

    private ArrayList<Card> randCards;
    private Deck d;
    private int cardsFlipped = 0;
    private CardView[] cvArr;
    private int card1 = 0;
    private int card2 = 0;
    private TextView timerTextView;
    private Button quitButton;
    private long startTime = 0;
    private long millis;
    private Button submitButton;
    private EditText nameEditTxt;

    Handler timerHandler = new Handler();// Clock
    Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
            millis = System.currentTimeMillis() - startTime; // total time in ms
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;
            long ms = millis % 1000;

            String time = String.format("%02d:%02d:%04d", minutes, seconds, ms);
            timerTextView.setText(time);

            timerHandler.postDelayed(this, 100); // update rate of timer - lower number = more responsive clock
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        quitButton = (Button) findViewById(R.id.quitButton);
        timerTextView = (TextView) findViewById(R.id.timerTextView);
        startTime = System.currentTimeMillis();
        timerHandler.postDelayed(timerRunnable, 0);
        submitButton = (Button) findViewById(R.id.submitButton);
        nameEditTxt = (EditText) findViewById(R.id.nameedit);

        submitButton.setEnabled(false);
        submitButton.setVisibility(View.INVISIBLE);
        nameEditTxt.setEnabled(false);
        nameEditTxt.setVisibility(View.INVISIBLE);

        submitButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if(nameEditTxt.getText().toString() != null && nameEditTxt.getText().toString() != "Name")
                {
                    String name = nameEditTxt.getText().toString();
                    Long time = millis;
                    String timeString = timerTextView.getText().toString();

                    Intent intent = new Intent(GameActivity.this, ScoreActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("time", time);
                    intent.putExtra("timeString", timeString);
                    startActivity(intent);
                }
            } });




        d = new Deck();
        randCards = d.getRandomCards();

        quitButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                finish();
            }
        }); // quit button

        CardView cv1 = (CardView) findViewById(R.id.view1);
        cv1.setCard(randCards.get(0));
        CardView cv2 = (CardView) findViewById(R.id.view2);
        cv2.setCard(randCards.get(1));
        CardView cv3 = (CardView) findViewById(R.id.view3);
        cv3.setCard(randCards.get(2));
        CardView cv4 = (CardView) findViewById(R.id.view4);
        cv4.setCard(randCards.get(3));
        CardView cv5 = (CardView) findViewById(R.id.view5);
        cv5.setCard(randCards.get(4));
        CardView cv6 = (CardView) findViewById(R.id.view6);
        cv6.setCard(randCards.get(5));
        CardView cv7 = (CardView) findViewById(R.id.view7);
        cv7.setCard(randCards.get(6));
        CardView cv8 = (CardView) findViewById(R.id.view8);
        cv8.setCard(randCards.get(7));
        CardView cv9 = (CardView) findViewById(R.id.view9);
        cv9.setCard(randCards.get(8));
        CardView cv10 = (CardView) findViewById(R.id.view10);
        cv10.setCard(randCards.get(9));
        CardView cv11 = (CardView) findViewById(R.id.view11);
        cv11.setCard(randCards.get(10));
        CardView cv12 = (CardView) findViewById(R.id.view12);
        cv12.setCard(randCards.get(11));

        cvArr = new CardView[]{cv1,cv2,cv3,cv4,cv5,cv6,cv7,cv8,cv9,cv10,cv11,cv12};

        View.OnTouchListener cardListener = new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {

                    for(CardView cardview:cvArr) {
                        if (v.getId() == cardview.getId()) {

                            if (cardsFlipped == 0) {
                                cardview.flip();
                                cardsFlipped++;
                                card1 = v.getId();
                            } else if (cardsFlipped == 1 && v.getId() != card1) {
                                cardview.flip();
                                cardsFlipped++;
                                card2 = v.getId();

                                for (CardView cv:cvArr)
                                {
                                    if(cv.getId() != card1 || cv.getId() != card2) // disable cards that aren't flipped
                                    {
                                        cv.setEnabled(false);
                                    }
                                }
                            }

                        }
                        if (cardsFlipped == 2) {

                            cardsFlipped = 0;

                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                public void run() {

                                    cardsFlipped = 0;
                                    for (CardView c1 : cvArr){
                                        if (c1.getId() == card1){
                                            for (CardView c2 : cvArr){
                                                if (c2.getId() == card2){
                                                    if (c1.getCard().getPairId() == c2.getCard().getPairId()) {

                                                        Toast.makeText(getApplicationContext(), "Match ",
                                                               Toast.LENGTH_SHORT).show();

                                                        c1.setVisibility(View.INVISIBLE);
                                                        c2.setVisibility(View.INVISIBLE);
                                                        cardsFlipped = 0;

                                                        int count = 0;

                                                        for (CardView c3 : cvArr)
                                                        {
                                                            if(c3.getCard().isFlipped())
                                                            {
                                                                count++; // total cards flipped
                                                            }
                                                        }
                                                        if(count == 12)
                                                        {
                                                            Toast.makeText(getApplicationContext(), "You Won! ",
                                                                    Toast.LENGTH_SHORT).show();

                                                            submitButton.setEnabled(true);
                                                            submitButton.setVisibility(View.VISIBLE);
                                                            nameEditTxt.setEnabled(true);
                                                            nameEditTxt.setVisibility(View.VISIBLE);

                                                            timerHandler.removeCallbacks(timerRunnable); // stop timer

                                                        }

                                                    }
                                                    else {

                                                        Toast.makeText(getApplicationContext(), "Not a Match! ",
                                                                Toast.LENGTH_SHORT).show();

                                                        c1.flip();
                                                        c2.flip();
                                                        cardsFlipped = 0;

                                                    }
                                                    for (CardView cv:cvArr)
                                                    {
                                                        if(cv.getId() != card1 || cv.getId() != card2)
                                                        {
                                                            cv.setEnabled(true);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }

                                }
                            }, 1000);
                        }
                    }
                }
                return false;
            }
        };

        for ( CardView cardview:cvArr  )
        {
            cardview.setOnTouchListener(cardListener);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.game, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}

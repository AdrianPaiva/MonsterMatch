package ca.gbc.mobile.adrianpaiva.matchit;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

/*
*************************************************
* Adrian Paiva
* 100864588
* ‎Friday, ‎October ‎3, ‎2014
* lastEdit: October ‎11, ‎2014
**************************************************/
public class CardView extends ImageView {


    private Card card;

    private int frontSrc;

    public CardView(Context context) {
        super(context);

    }

    public CardView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public CardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);


    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card)

    {
        this.card = card;
        frontSrc = card.getImage();

    }

    public void update(){
        if (card.isFlipped())
            setImageResource(card.getImage());
        else
            setImageResource(R.drawable.mainback);
    }

    public void flip()
    {
        if(card.isFlipped())
        {
            card.setFlipped(false);
        }
        else if(!card.isFlipped())
        {
            card.setFlipped(true);

        }
        update();
    }

    /*
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getActionMasked();
        if (action==MotionEvent.ACTION_DOWN){

                flip();
                update();

        }

        return super.onTouchEvent(event);
    }
    */



}

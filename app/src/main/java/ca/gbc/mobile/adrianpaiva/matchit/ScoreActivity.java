package ca.gbc.mobile.adrianpaiva.matchit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*
*************************************************
* Adrian Paiva
* 100864588
* created: ‎Monday, ‎October ‎6, ‎2014
* lastEdit: October ‎25, ‎2014
**************************************************/

public class ScoreActivity extends Activity {

    ListView listv;
    String name;
    String timeString;
    Long time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        //ScoreBoard sb = new ScoreBoard();




        if (getIntent().hasExtra("name") && getIntent().hasExtra("time") && getIntent().hasExtra("timeString"))
        {
            name = getIntent().getExtras().getString("name");
            time = getIntent().getExtras().getLong("time");
            timeString = getIntent().getExtras().getString("timeString");
            //sb.addPlayer(name, time, timeString);
            Player p1 = new Player(name,time,timeString);
            writePlayer(p1);

        }

        listv = (ListView) findViewById(R.id.scoreListView);
        ArrayList<HashMap<String, String>> feedList= new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("Name", "Name");//Scoreboard Headers
        map.put("Time", "Time");
        feedList.add(map);

        if(!readPlayers().isEmpty()) {

            ArrayList<Player> plist = readPlayers();
            Collections.sort(plist, new TimeComparator()); // sort by best score

            for (Player p : plist) {

                map = new HashMap<String, String>();
                map.put("Name", p.getName());
                map.put("Time", p.getTimeString());
                feedList.add(map);
            }
        }

        SimpleAdapter simple = new SimpleAdapter(this, feedList, R.layout.listview_row, new String[]{"Name", "Time"}, new int[]{R.id.scoreName, R.id.scoreScore});
        listv.setAdapter(simple);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.score, menu);
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
    public void goHome(View view)
    {
        Intent intent = new Intent(ScoreActivity.this, MainActivity.class);
        startActivity(intent);
        //finish();
    }
    public void writePlayer(Player p) {

        try
        {
            File file = getFileStreamPath("scoreboard2");
            ArrayList<Player> playerList = new ArrayList<Player>();

            if(file.exists())
            {
                playerList = readPlayers();
                playerList.add(p);
            }

            //FileOutputStream fos = new FileOutputStream("scoreboard");
            FileOutputStream fos = openFileOutput("scoreboard2",Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(playerList);
            fos.close();
            oos.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public ArrayList<Player> readPlayers()
    {
        ArrayList<Player> playerList = new ArrayList<Player>();

        try
        {
            File file = getFileStreamPath("scoreboard2");

            if(file.exists())
            {
                //FileInputStream fis = new FileInputStream("scoreboard");
                FileInputStream fis = openFileInput("scoreboard2");
                ObjectInputStream ois = new ObjectInputStream(fis);

                playerList = (ArrayList<Player>)ois.readObject();

                fis.close();
                ois.close();
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return playerList;
    }
}

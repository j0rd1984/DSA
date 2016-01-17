package edu.upc.eetac.dsa.listapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // create data
        createExampleData();

        // set list adapter
        ListView list = (ListView)findViewById(R.id.list);
        ExampleDataAdapter  adapter = new ExampleDataAdapter(this, exampleData);
        list.setAdapter(adapter);

        // set list OnItemClick listener
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, exampleData.get(position).getMainText());
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public final static String[] items = {"Lorem", "fistrum", "dise", "usteer", "papaar", "gloria", "quietooor", "fistro", "no puedor", "pecador", "diodenoo", "gramenawer", "benemeritaar"};
    public final static String TAG = MainActivity.class.toString();
    public ArrayList<ExampleData> exampleData = null;

    private void createExampleData(){
        exampleData = new ArrayList<>();
        for(int i = 0; i < 50; i++){
            ExampleData data = new ExampleData();
            data.setMainText("Main Text #" + (i+1));
            data.setLeftText("Left Text #" + (i + 1));
            data.setRightText("Right Text #" + (i + 1));
            exampleData.add(data);
        }
    }
}

package nbii.na.edu.busapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

import nbii.na.edu.busapp.Model.Frequency;

public class BusFrequencyActivity extends AppCompatActivity  {

    private static final String FIREBASE_URL = "https://busapp.firebaseio.com/";

    private ArrayList<Frequency> mfrequencies;
    private Context mcontext;
    private ListView mListView; //Defining android ListView
    private Firebase mRef;
    private  ArrayAdapter<Frequency> frequencyAdapter ;

    private String [] id = {"10A","10L","10KV","10KP","10KJ","10L","10K","10KL","17/226","17/227"};
    private String [] origin = {"Wernhnill Mall","Women Center","Suiderhof","Ombili","Robert Mugabe","Havana","Goreangab","Wernill","Marua Mall","Wanaheda"};
    private String [] destination = {"Women Center","Wernhill Mall","Ombili","Suiderhof","Havana","Robert Mugabe","Wernhill Mall","Goreangab","Wanaheda","Marua Mall"};
    private String [] time = {"01:00","01:00","00:30","00:15","00:15","03:00","00:45","00:55","01:15","01:15"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_frequency);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mfrequencies = new ArrayList<Frequency>();

        loadData();

        mcontext = getApplicationContext();

        frequencyAdapter = new FrequencyAdapter<Frequency>(mcontext,R.layout.frequency_layout,mfrequencies);

        mListView = (ListView)findViewById(R.id.listview);
        mListView.setAdapter(frequencyAdapter);

        //frequencyAdapter = new FrequencyAdapter<Frequency>(mcontext,R.layout.frequency_layout,mfrequencies);

        //mListView = (ListView)findViewById(R.id.listview);



        //mListView = (ListView) findViewById(R.id.list);

        //Declaring Array adapter
        //FrequencyAdapter frequencyAdapter = new FrequencyAdapter(this,android.R.layout.simple_list_item_1, mfrequencies);

        /*mfrequencies = new ArrayList<Frequency>();

        frequencyAdapter = new FrequencyAdapter(this , R.layout.frequency_layout , mfrequencies);
        mListView.setAdapter(frequencyAdapter);


        Firebase.setAndroidContext(this);

        // Setup our Firebase ref
        Firebase ref = new Firebase(FIREBASE_URL).child("bus_frequency");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Map<String, Object> data = (Map<String, Object>) dataSnapshot.getValue();
                Frequency addedFrequency = new Frequency(data);
                BusFrequencyActivity.this.mfrequencies.add(addedFrequency);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Toast.makeText(mcontext, "Server error. Refresh page", Toast.LENGTH_SHORT).show();
            }
        });

        //Setting the android ListView's adapter to the newly created adapter
       // mListView.setAdapter(frequencyAdapter)

        //Toast.makeText(mcontext, name ,Toast.LENGTH_SHORT).show();*/

    }

    public void loadData(){

        String no;
        String dest;
        String orig;
        String freqtime;

        for(int i=0;i<id.length;i++){

            no = id[i];
            dest = destination[i];
            orig = origin[i];
            freqtime = time[i];

            Frequency feq = new Frequency(no,dest,orig,freqtime);

            mfrequencies.add(feq);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {

            case android.R.id.home:
                Intent upIntent = NavUtils.getParentActivityIntent(this);
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                    // This activity is NOT part of this app's task, so create a new task
                    // when navigating up, with a synthesized back stack.
                    TaskStackBuilder.create(this)
                            // Add all of this activity's parents to the back stack
                            .addNextIntentWithParentStack(upIntent)
                                    // Navigate up to the closest parent
                            .startActivities();
                } else {
                    // This activity is part of this app's task, so simply
                    // navigate up to the logical parent activity.
                    NavUtils.navigateUpTo(this, upIntent);
                }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

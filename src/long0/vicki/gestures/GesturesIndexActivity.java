//***************************************************************
//  GesturesIndexActivity.java     Author: Vicki Long
//
//  The main activity that shows up when the app opens. The user
//  starts the game from this activity. When the game ends, the
//  user is sent back to this activity.
//***************************************************************

package long0.vicki.gestures;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class GesturesIndexActivity extends Activity {
	private Button mStartButton;
	private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestures_index);
        
        getInit(); //Initializes all variables
        addClickListener(); //Adds click listener to start button to allow the user to play the game
    }
    
    //public void getInit ()
    //Initializes all variables
    public void getInit () {
    	mStartButton = (Button) findViewById(R.id.start_gestures_button);
    }
    
    public void addClickListener () {
    	//Adds click listener to start button
    	mStartButton.setOnClickListener(new View.OnClickListener() {
    		//When the start button is pressed, starts GesturesActivity
            public void onClick(View v) {
            	i = new Intent(GesturesIndexActivity.this, GesturesActivity.class);
            	startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.gestures_index, menu);
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

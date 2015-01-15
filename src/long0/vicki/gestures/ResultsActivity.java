//***************************************************************
//  ResultsActivity.java     Author: Vicki Long
//
//  When the game ends, shows the user the final score and
//  allows user to restart the game.
//***************************************************************

package long0.vicki.gestures;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends Activity {
	private Button mRestartButton;
	private TextView mFinalScore;
	private int mScore;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        
        getInit(); //Initializes all variables
        
        mFinalScore.setText(String.valueOf(mScore)); //Changes score shown to the user's final score
        
        //When the restart button is clicked, closes activity and goes back to main activity
        mRestartButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	finish();
            }
        });
    }
	
	//public void getInit ()
	//Initializes all variables
	public void getInit () {
		mRestartButton = (Button) findViewById(R.id.restart_button);
        mFinalScore = (TextView) findViewById(R.id.final_score);
        
        //Obtains the user's score from an int sent through the Intent
        mScore = getIntent().getExtras().getInt(getResources().getString(R.string.score));
	}
	
}

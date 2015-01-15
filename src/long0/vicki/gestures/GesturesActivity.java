//***************************************************************
//  GesturesActivity.java     Author: Vicki Long
//
//  The activity that allows the user to play the game. Lasts
//  only for 60 seconds due to a CountDownTimer. Random images
//  appear on the screen and the user must perform a gesture
//  that corresponds with the image. Score changes accordingly.
//***************************************************************

package long0.vicki.gestures;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GesturesActivity extends FragmentActivity implements ButtonFragment.ButtonListener {
	private RelativeLayout mBackground;
	private TextView mTimer;
	private View mRootView;
	private SwipeImage mBackgroundImage;
	private int mScore, mGesture;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestures);
        
        mBackground = (RelativeLayout) findViewById(R.id.gesturesBackground);
        mTimer = (TextView) findViewById(R.id.timer);
        mRootView = findViewById(android.R.id.content);
        
        mBackgroundImage = new SwipeImage(); //Initializes a new SwipeImage to enable changing of background image
        
        mScore = 0; //Sets starting score to 0
        mGesture = -1; //Sets gesture to none of the available gestures
        
        startTimer(); //Starts a CountDownTimer that counts down from 60 seconds
        changeBackground(); //Changes the background image to a random image out of 4 arrows and a circle
        
        //When the screen is clicked or "tapped", changes the background image to a new random image and
        //increases or decreases score accordingly
        mRootView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
            	mGesture = 0; //Sets a variable to check if the image corresponds with the gesture
            	modifyScore(); //Changes score based on whether or not the gesture is correct
            	changeBackground(); //Changes background of screen to random image
            }
        });
        
        mRootView.setOnTouchListener(new OnSwipeTouchListener(GesturesActivity.this) {
        	//When the user swipes up
            public boolean onSwipeUp() {
                mGesture = 1; //Sets a variable to check if the image corresponds with the gesture
            	modifyScore(); //Changes score based on whether or not the gesture is correct
            	changeBackground(); //Changes background of screen to random image
                return true;
            }
            //When the user swipes right
            public boolean onSwipeRight() {
                mGesture = 2; //Sets a variable to check if the image corresponds with the gesture
            	modifyScore(); //Changes score based on whether or not the gesture is correct
            	changeBackground(); //Changes background of screen to random image
                return true;
            }
            //When the user swipes left
            public boolean onSwipeLeft() {
                mGesture = 3; //Sets a variable to check if the image corresponds with the gesture
            	modifyScore(); //Changes score based on whether or not the gesture is correct
            	changeBackground(); //Changes background of screen to random image
                return true;
            }
            //When the user swipes down
            public boolean onSwipeDown() {
                mGesture = 4; //Sets a variable to check if the image corresponds with the gesture
            	modifyScore(); //Changes score based on whether or not the gesture is correct
            	changeBackground(); //Changes background of screen to random image
                return true;
            }
        });
    }
    
	//public void startTimer ()
	//Creates a new timer that only lasts for 10 seconds
	//When the 10 seconds are over, the game ends and the ResultsActivity opens, finishing GesturesActivity
    public void startTimer () {
    	new CountDownTimer(10000, 1000) {
    		//On each tick or second, the timer counts down to show the user the amount of time left
    	     public void onTick(long millisUntilFinished) {
    	         mTimer.setText(Long.toString(millisUntilFinished / 1000));
    	     }
    	     
    	     //When the timer finishes, starts a new activity and stores the score
    	     //Finishes GesturesActivity
    	     public void onFinish() {
    	    	 Intent intent = new Intent(GesturesActivity.this, ResultsActivity.class);
    	    	 intent.putExtra(getResources().getString(R.string.score), mScore);
    	    	 intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    	    	 startActivity(intent);
    	         finish();
    	     }
    	}.start();
    }
    
    //public boolean gestureIsCorrect ()
    //Checks if the gesture value corresponds with the gesture value of the image
    public boolean gestureIsCorrect () {
    	if (mBackgroundImage.getCurrentImageId() == mGesture) {
    		return true;
    	}
    	return false;    			
    }
    
    //public void increaseScore ()
    //Increases score by 1
    public void increaseScore () {
    	mScore++;
    }
    
    //public void decreaseScore ()
    //Decreases score by 1
    public void decreaseScore () {
    	mScore--;
    }
    
    //public void modifyScore ()
    //If the user's gesture is correct, increases score
    //Otherwise, decreases score
    public void modifyScore () {
    	if (gestureIsCorrect()) {
        	increaseScore();
        }
        else {
        	decreaseScore();
        }
    }
    
    //public void changeBackground ()
    //Changes the background of the screen to a new random image
    public void changeBackground () {
    	mBackground.setBackgroundResource(mBackgroundImage.getRandomImage());
    }
    
    //public void onButtonClick ()
    //When the Exit button is clicked, finishes the current Activity
    public void onButtonClick () {
    	finish();
    }
	
}

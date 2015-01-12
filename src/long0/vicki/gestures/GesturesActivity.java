package long0.vicki.gestures;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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
        
        mBackgroundImage = new SwipeImage();
        
        mScore = 0;
        mGesture = 0;
        
        startTimer();
        changeBackground();
        
        mRootView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
            	Toast.makeText(GesturesActivity.this, "tap", Toast.LENGTH_SHORT).show();
            	mGesture = 0;
            	modifyScore();
            	changeBackground();
            }
        });
        
        mRootView.setOnTouchListener(new OnSwipeTouchListener(GesturesActivity.this) {
            public boolean onSwipeUp() {
                Toast.makeText(GesturesActivity.this, "up", Toast.LENGTH_SHORT).show();
                mGesture = 1;
                modifyScore();
                changeBackground();
                return true;
            }
            public boolean onSwipeRight() {
                Toast.makeText(GesturesActivity.this, "right", Toast.LENGTH_SHORT).show();
                mGesture = 2;
                modifyScore();
                changeBackground();
                return true;
            }
            public boolean onSwipeLeft() {
                Toast.makeText(GesturesActivity.this, "left", Toast.LENGTH_SHORT).show();
                mGesture = 3;
                modifyScore();
                changeBackground();
                return true;
            }
            public boolean onSwipeDown() {
                Toast.makeText(GesturesActivity.this, "down", Toast.LENGTH_SHORT).show();
                mGesture = 4;
                modifyScore();
                changeBackground();
                return true;
            }
        });
    }
    
    public void startTimer () {
    	new CountDownTimer(10000, 1000) {
    	     public void onTick(long millisUntilFinished) {
    	         mTimer.setText(Long.toString(millisUntilFinished / 1000));
    	     }

    	     public void onFinish() {
    	    	 Intent intent = new Intent(GesturesActivity.this, ResultsActivity.class);
    	    	 intent.putExtra("score", mScore);
    	    	 intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    	    	 startActivity(intent);
    	         finish();
    	     }
    	}.start();
    }
    
    public boolean gestureIsCorrect() {
    	if (mBackgroundImage.getCurrentImageId() == mGesture) {
    		return true;
    	}
    	return false;    			
    }
    
    public void increaseScore () {
    	mScore++;
    }
    
    public void decreaseScore () {
    	mScore--;
    }
    
    public void modifyScore () {
    	if (gestureIsCorrect()) {
        	increaseScore();
        }
        else {
        	decreaseScore();
        }
    }
    
    public void changeBackground () {
    	mBackground.setBackgroundResource(mBackgroundImage.getRandomImage());
    }
    
    public void onButtonClick() {
    	finish();
    }
	
}

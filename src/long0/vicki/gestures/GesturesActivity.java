package long0.vicki.gestures;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentActivity;
import android.widget.Button;
import android.widget.TextView;

public class GesturesActivity extends FragmentActivity implements ButtonFragment.ButtonListener {
	private TextView mTimer;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestures);
        
        mTimer = (TextView) findViewById(R.id.timer);
        
        startTimer();
    }
    
    public void startTimer () {
    	new CountDownTimer(60000, 1000) {
    	     public void onTick(long millisUntilFinished) {
    	         mTimer.setText("seconds remaining: " + millisUntilFinished / 1000);
    	     }

    	     public void onFinish() {
    	         mTimer.setText("done!");
    	     }
    	}.start();
    }
    
    public void onButtonClick() {
    	finish();
    }
	
}

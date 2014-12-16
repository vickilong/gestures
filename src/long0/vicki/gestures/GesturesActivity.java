package long0.vicki.gestures;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class GesturesActivity extends FragmentActivity implements ButtonFragment.ButtonListener {
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestures);
        
        getInit();
    }
    
    public void getInit () {
    	
    }
    
    public void onButtonClick(boolean close) {
    	finish();
    }
	
}

package long0.vicki.gestures;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResultsActivity extends Activity {
	private Button mRestartButton;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        
        mRestartButton = (Button) findViewById(R.id.restart_button);
        
        mRestartButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	finish();
            }
        });
    }
	
}

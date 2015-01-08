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
        
        mRestartButton = (Button) findViewById(R.id.restart_button);
        mFinalScore = (TextView) findViewById(R.id.final_score);
        
        mScore = getIntent().getExtras().getInt("score");
        mFinalScore.setText(String.valueOf(mScore));
        
        mRestartButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	finish();
            }
        });
    }
	
}

//***************************************************************
//  ButtonFragment.java     Author: Vicki Long
//
//  A button fragment that allows the user to exit the game
//  before the timer reaches 0.
//***************************************************************

package long0.vicki.gestures;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ButtonFragment extends Fragment {
	
	private static Button sExitButton;
	
	ButtonListener activityCallback;
	
	public interface ButtonListener {
		public void onButtonClick();
	}
	
   public void onAttach(Activity activity) {
     super.onAttach(activity);
     activityCallback = (ButtonListener) activity;
   }
	
	@Override
	public View onCreateView(LayoutInflater inflater,
							ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.button_fragment, container, false);
		sExitButton = (Button) view.findViewById(R.id.exit_gestures_button);
		
		//When the Exit button is clicked, closes the activity
		sExitButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				buttonClicked(v);
			}
		});
		
		return view;
	}
	
	public void buttonClicked (View view) {
		activityCallback.onButtonClick();
	}
	
}

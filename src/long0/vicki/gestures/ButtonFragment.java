package long0.vicki.gestures;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ButtonFragment extends Fragment {
	
private static Button sExitButton;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
							ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.button_fragment, container, false);
		sExitButton = (Button) view.findViewById(R.id.exit_gestures_button);
		return view;
	}
	
}

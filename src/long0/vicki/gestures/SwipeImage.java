package long0.vicki.gestures;

import java.util.ArrayList;

public class SwipeImage {
	
	private ArrayList<Integer> imageIds;
	
	public SwipeImage () {
		imageIds = new ArrayList<Integer>(5);
		imageIds.add(R.drawable.up);
		imageIds.add(R.drawable.down);
		imageIds.add(R.drawable.left);
		imageIds.add(R.drawable.right);
		imageIds.add(R.drawable.tap);
	}
	
	public int getRandomImage () {
		switch ((int) Math.random() * 5) {
			case 0:
				return Integer.valueOf(imageIds.get(0));
			case 1:
				return Integer.valueOf(imageIds.get(1));
			case 2:
				return Integer.valueOf(imageIds.get(2));
			case 3:
				return Integer.valueOf(imageIds.get(3));
			case 4:
				return Integer.valueOf(imageIds.get(4));
			default:
				return -1;
		}
	}
	
}

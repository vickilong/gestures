package long0.vicki.gestures;

import java.util.ArrayList;

public class SwipeImage {
	
	private ArrayList<Integer> imageIds;
	private int currentImageId;
	
	public SwipeImage () {
		imageIds = new ArrayList<Integer>(5);
		currentImageId = -1;
		imageIds.add(R.drawable.tap);
		imageIds.add(R.drawable.up);
		imageIds.add(R.drawable.right);
		imageIds.add(R.drawable.left);
		imageIds.add(R.drawable.down);
	}
	
	public int getRandomImage () {
		switch ((int) (Math.random() * 5)) {
			case 0:
				currentImageId = 0;
				return Integer.valueOf(imageIds.get(0));
			case 1:
				currentImageId = 1;
				return Integer.valueOf(imageIds.get(1));
			case 2:
				currentImageId = 2;
				return Integer.valueOf(imageIds.get(2));
			case 3:
				currentImageId = 3;
				return Integer.valueOf(imageIds.get(3));
			case 4:
				currentImageId = 4;
				return Integer.valueOf(imageIds.get(4));
			default:
				currentImageId = -1;
				return -1;
		}
	}

	/**
	 * @return the imageIds
	 */
	public ArrayList<Integer> getImageIds() {
		return imageIds;
	}

	/**
	 * @return the currentImageId
	 */
	public int getCurrentImageId() {
		return currentImageId;
	}

	/**
	 * @param imageIds the imageIds to set
	 */
	public void setImageIds(ArrayList<Integer> imageIds) {
		this.imageIds = imageIds;
	}

	/**
	 * @param currentImageId the currentImageId to set
	 */
	public void setCurrentImageId(int currentImageId) {
		this.currentImageId = currentImageId;
	}
	
}

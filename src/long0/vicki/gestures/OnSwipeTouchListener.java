//***************************************************************
//  OnSwipeTouchListener.java     Author: Vicki Long
//
//  Creates a listener for user swipes and implements different
//  methods based on the type of fling the user performs.
//***************************************************************

package long0.vicki.gestures;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class OnSwipeTouchListener implements OnTouchListener {

	private final GestureDetector gestureDetector;
	
	//public OnSwipeTouchListener(Context context)
	//Initializes a new GestureDetector to detect for common gestures
    public OnSwipeTouchListener(Context context) {
        gestureDetector = new GestureDetector(context, new GestureListener());
    }
    
    //public boolean onTouch(View v, MotionEvent event)
    //Checks if the gestureDetector has detected a touch
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private final class GestureListener extends SimpleOnGestureListener {
    	
    	//Two thresholds that the flings must meet before they qualify as flings
        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            try {
            	//Calculates the difference of the x and y starting and ending coordinates
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                //If the fling was mostly horizontal
                if (Math.abs(diffX) > Math.abs(diffY)) {
                	//If the fling qualifies as a fling based on the thresholds
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    	//If the fling was to the right
                        if (diffX > 0) {
                        	//Carries out onSwipeRight()
                            result = onSwipeRight();
                        }
                        //If the fling was to the left
                        else {
                        	//Carries out onSwipeLeft()
                            result = onSwipeLeft();
                        }
                    }
                }
                //If the fling was mostly vertical
                else {
                	//If the fling qualifies as a fling based on the thresholds
                    if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    	//If the fling was down
                        if (diffY > 0) {
                        	//Carries out onSwipeDown()
                            result = onSwipeDown();
                        }
                      //If the fling was up
                        else {
                        	//Carries out onSwipeUp()
                            result = onSwipeUp();
                        }
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }
    }
    
    //public boolean onSwipeRight()
    //Returns false if method isn't reached
    public boolean onSwipeRight() {
        return false;
    }
    
    //public boolean onSwipeLeft()
    //Returns false if method isn't reached
    public boolean onSwipeLeft() {
        return false;
    }

    //public boolean onSwipeUp()
    //Returns false if method isn't reached
    public boolean onSwipeUp() {
        return false;
    }
    
    //public boolean onSwipeDown()
    //Returns false if method isn't reached
    public boolean onSwipeDown() {
        return false;
    }
}

package organizer.CarFuel;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import  java.lang.Class;

class GenericActivity extends Activity {
    public void backActivity() {
        Intent intent = new Intent();
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    public void changeActivity(View view, Class c) {
        changeActivity(view, c, 0);
    }

    public void changeActivity(View view, Class c, int activity_id) {
        // refs:
        // http://www.warriorpoint.com/blog/2009/05/24/android-how-to-switch-between-activities/
        // http://stackoverflow.com/questions/449484/android-capturing-the-return-of-an-activity
        Intent add_intent = new Intent(view.getContext(), c);
        startActivityForResult(add_intent, activity_id);
    }

    public CarFuelApp getApp() {
        return (CarFuelApp) getApplication();
    }

}

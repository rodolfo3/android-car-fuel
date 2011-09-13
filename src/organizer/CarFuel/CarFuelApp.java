package organizer.CarFuel;

import android.app.Application;
import java.util.ArrayList;

public class CarFuelApp extends Application {
    private ArrayList data = new ArrayList();

    public void add(Object el) {
        this.data.add(el);
    }

    public ArrayList get() {
        return this.data;
    }

}


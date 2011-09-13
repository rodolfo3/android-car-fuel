package organizer.CarFuel;

import java.util.GregorianCalendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import java.text.SimpleDateFormat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.DatePicker;

public class Add extends GenericActivity {
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        installEvents();
    }

    public void done(View view) {
        // date
        DatePicker dp = (DatePicker) findViewById(R.id.date);
        GregorianCalendar date = new GregorianCalendar(dp.getYear(),
            dp.getMonth(), dp.getDayOfMonth());
        SimpleDateFormat sdf =
                  new SimpleDateFormat("yyyy-MM-dd");
        String dates = sdf.format(date.getTime());

        // liters
        EditText aux;
        aux = (EditText) findViewById(R.id.liters);
        String liters = aux.getText().toString();

        // cost
        aux = (EditText) findViewById(R.id.cost);
        String cost = aux.getText().toString();

        // km
        aux = (EditText) findViewById(R.id.km);
        String km = aux.getText().toString();

        // "save"
        CarFuelApp app = getApp();
        String[] data = {dates, liters, cost, km};
        app.add(data);

        backActivity();
    }

    private void installEvents() {
        final Button btn = (Button) findViewById(R.id.done);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                done(v);
            }
        });
    }

}

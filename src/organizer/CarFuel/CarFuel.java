package organizer.CarFuel;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;

import java.util.ArrayList;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.GridView;

import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CarFuel extends GenericActivity
{
    private final int ADD_NEW = 1;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        installEvents();
    }

    public void add(View view) {
        changeActivity(view, Add.class, ADD_NEW);
    }

    private void installEvents() {
        final Button btn = (Button) findViewById(R.id.add);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // FIXME: DRY
                add(v);
            }
        });
    }

    private void refresh() {
        Toast.makeText(getApplicationContext(), ":)", 10).show();
        CarFuelApp app = getApp();
        ArrayList list = app.get();

        List<HashMap<String, String>> fillMaps =
            new ArrayList<HashMap<String, String>>();

        for(Object data: list) {
            HashMap<String, String> map = new HashMap<String, String>();
            String[] d = (String[]) data;
            map.put("date", d[0]);
            map.put("liters", d[1]);
            map.put("cost", d[2]);
            map.put("km", d[3]);
            fillMaps.add(map);
        }

        String[] from = new String[] {"date", "liters", "cost", "km"};
        int[] to = new int[] { R.id.date, R.id.liters, R.id.cost, R.id.km, };
        SimpleAdapter adapter =
            new SimpleAdapter(this, fillMaps, R.layout.grid_item, from, to);
        ListView lv = (ListView)findViewById(R.id.listview);
        lv.setAdapter(adapter);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case (ADD_NEW):
                    if (resultCode == Activity.RESULT_OK) {
                        refresh();
                    }
                break;
        }
    }
}

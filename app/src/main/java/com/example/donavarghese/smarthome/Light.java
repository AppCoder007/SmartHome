package com.example.donavarghese.smarthome;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Light extends AppCompatActivity {
    private static SeekBar seek_bar;

    String popUpContents[];
    PopupWindow popupWindowDogs;
    Button buttonShowDropDown;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);


        Fragment fragment;
        fragment = new EmptyRoom();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frag_placeholder, fragment);
        fragmentTransaction.commit();



                final AlertDialog.Builder alert = new AlertDialog.Builder(
                                        Light.this);

                             alert.setTitle("Info:");

                                alert.setMessage("Select a room to start control lights!!");
                                alert.setPositiveButton("OK",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.cancel();
                                            }
                                        });
                                alert.show();


        List<String> dogsList = new ArrayList<String>();
        dogsList.add("Living Room::1");
        dogsList.add("Bedroom 1::2");
        dogsList.add("Bedroom 2::3");
        dogsList.add("Bedroom 3::4");

        // convert to simple array
        popUpContents = new String[dogsList.size()];
        dogsList.toArray(popUpContents);


        // initialize pop up window
        popupWindowDogs = popupWindowDogs();

        // button on click listener

        View.OnClickListener handler = new View.OnClickListener() {
            public void onClick(View v) {

                switch (v.getId()) {

                    case R.id.buttonShowDropDown:
                        // show the list view as dropdown
                        popupWindowDogs.showAsDropDown(v, -5, 0);

                        break;
                }
            }
        };

        // our button
        textView = (TextView) findViewById(R.id.textView);
        // textView.setOnClickListener(handler);
        buttonShowDropDown = (Button) findViewById(R.id.buttonShowDropDown);
        buttonShowDropDown.setOnClickListener(handler);


    }

    public PopupWindow popupWindowDogs() {

        // initialize a pop up window type
        PopupWindow popupWindow = new PopupWindow(this);

        // the drop down list is a list view
        ListView listViewDogs = new ListView(this);

        // set our adapter and pass our pop up window contents
        listViewDogs.setAdapter(dogsAdapter(popUpContents));

        // set the item click listener
        listViewDogs.setOnItemClickListener(new
                DogsDropdownOnItemClickListener());

        // some other visual settings
        popupWindow.setFocusable(true);
        popupWindow.setWidth(500);
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);

        // set the list view as pop up window content
        popupWindow.setContentView(listViewDogs);

        return popupWindow;
    }

    /*
     * adapter where the list values will be set
     */
    private ArrayAdapter<String> dogsAdapter(String dogsArray[]) {

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, dogsArray) {

            @Override
            public View getView(int position, View convertView,
                                ViewGroup parent) {

                // setting the ID and text for every items in the list
                String item = getItem(position);
                String[] itemArr = item.split("::");
                String text = itemArr[0];
                String id = itemArr[1];

                // visual settings for the list item
                TextView listItem = new TextView(Light.this);

                listItem.setText(text);
                listItem.setTag(id);
                listItem.setTextSize(22);
                listItem.setPadding(10, 10, 10, 10);
                listItem.setTextColor(Color.WHITE);

                return listItem;
            }
        };

        return adapter;
    }


    public void seebbarr() {


        //final ToggleButton button = (ToggleButton) button.findViewById();
        final ImageView image = (ImageView) findViewById(R.id.image);

        seek_bar = (SeekBar) findViewById(R.id.seekBar);


        // text_view = (TextView) findViewById(R.id.textView5);
        // text_view.setText("Brightness : " + seek_bar.getProgress() + " /" + seek_bar.getMax());
        seek_bar.setProgress(0);
        seek_bar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    int progress_value;

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int
                            progress, boolean fromUser) {
                        progress_value = progress;
                        //    text_view.setText("Brightness : " + progress + " / " + seek_bar.getMax());

                        switch (progress_value) {
                            case 0:
                                image.setImageResource(R.drawable.light_bulb_off);

                                break;
                            case 1:
                                image.setImageResource(R.drawable.light_bulb_on1);
                                break;
                            case 2:
                                image.setImageResource(R.drawable.light_bulb_on2);
                                break;
                            case 3:
                                image.setImageResource(R.drawable.light_bulb_on3);
                                break;
                            case 4:
                                image.setImageResource(R.drawable.light_bulb_on4);
                                break;
                            case 5:
                                image.setImageResource(R.drawable.light_bulb_on5);
                                break;
                            case 6:
                                image.setImageResource(R.drawable.light_bulb_on6);
                                break;
                            case 7:
                                image.setImageResource(R.drawable.light_bulb_on7);
                                break;
                            case 8:
                                image.setImageResource(R.drawable.light_bulb_on8);
                                break;
                            case 9:
                                image.setImageResource(R.drawable.light_bulb_on9);
                                break;

                            case 10:
                                image.setImageResource(R.drawable.light_bulb_on);
                                break;


                        }


                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                        switch (progress_value) {
                            case 0:
                                image.setImageResource(R.drawable.light_bulb_off);

                                break;
                            case 1:
                                image.setImageResource(R.drawable.light_bulb_on1);
                                break;
                            case 2:
                                image.setImageResource(R.drawable.light_bulb_on2);
                                break;
                            case 3:
                                image.setImageResource(R.drawable.light_bulb_on3);
                                break;
                            case 4:
                                image.setImageResource(R.drawable.light_bulb_on4);
                                break;
                            case 5:
                                image.setImageResource(R.drawable.light_bulb_on5);
                                break;
                            case 6:
                                image.setImageResource(R.drawable.light_bulb_on6);
                                break;
                            case 7:
                                image.setImageResource(R.drawable.light_bulb_on7);
                                break;
                            case 8:
                                image.setImageResource(R.drawable.light_bulb_on8);
                                break;
                            case 9:
                                image.setImageResource(R.drawable.light_bulb_on9);
                                break;

                            case 10:
                                image.setImageResource(R.drawable.light_bulb_on);
                                break;


                        }


                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        //       text_view.setText("Brightness : " +
                        //           progress_value + " / " + seek_bar.getMax());

                        switch (progress_value) {
                            case 0:
                                image.setImageResource(R.drawable.light_bulb_off);
                           /*        final AlertDialog.Builder alert = new AlertDialog.Builder(
                                        Light.this);

                             alert.setTitle("Info:");

                                alert.setMessage("Light will turn off at this brightness level !!");
                                alert.setPositiveButton("OK",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.cancel();
                                            }
                                        });
                                alert.show();8*/
                                break;
                            case 1:
                                image.setImageResource(R.drawable.light_bulb_on1);
                                break;
                            case 2:
                                image.setImageResource(R.drawable.light_bulb_on2);
                                break;
                            case 3:
                                image.setImageResource(R.drawable.light_bulb_on3);
                                break;
                            case 4:
                                image.setImageResource(R.drawable.light_bulb_on4);
                                break;
                            case 5:
                                image.setImageResource(R.drawable.light_bulb_on5);
                                break;
                            case 6:
                                image.setImageResource(R.drawable.light_bulb_on6);
                                break;
                            case 7:
                                image.setImageResource(R.drawable.light_bulb_on7);
                                break;
                            case 8:
                                image.setImageResource(R.drawable.light_bulb_on8);
                                break;
                            case 9:
                                image.setImageResource(R.drawable.light_bulb_on9);
                                break;

                            case 10:
                                image.setImageResource(R.drawable.light_bulb_on);
                                break;


                        }
                    }

                });
    }


    public void changeActivity() {

        Fragment fragment1;
        fragment1 = new LivingRoom();
        FragmentManager fragmentManager1 = getFragmentManager();
        FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
        fragmentTransaction1.replace(R.id.frag_placeholder, fragment1);
        // fragmentTransaction.hide(fragment);
        fragmentTransaction1.commit();

       // seebbarr();
    }
}






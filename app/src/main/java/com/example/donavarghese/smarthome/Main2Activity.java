package com.example.donavarghese.smarthome;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Main2Activity extends ActionBarActivity {
    private static SeekBar seek_bar;
    private static TextView text_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        seebbarr();
    }






    public void seebbarr() {


        final ToggleButton button = (ToggleButton) findViewById(R.id.button);
        final ImageView image = (ImageView) findViewById(R.id.image);

        seek_bar = (SeekBar) findViewById(R.id.seekBar);
        text_view = (TextView) findViewById(R.id.textView5);
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
                         /*       final AlertDialog.Builder alert = new AlertDialog.Builder(
                                        Main2Activity.this);

                                alert.setTitle("Info:");

                                alert.setMessage("Light will turn off at this brightness level !!");
                                alert.setPositiveButton("OK",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.cancel();
                                            }
                                        });
                                alert.show(); */
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
}












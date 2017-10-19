package com.example.donavarghese.smarthome;


/**********************************************************************************************************************

 Name   : Dona varghese
 Course : COP2660
 Date   : 10/19/2017
 Project: Smart Home App

***********************************************************************************************************************/


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {


    private String TAG = "MDC_ANDROID_CLASS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);







    }

  public  void lightmenu(View view){

      Intent intent = new Intent(MainActivity.this, Light.class);

      startActivity(intent);
  }


    public void opendoor(View view) throws IOException {

        Intent intent6 = new Intent(this, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int)
                System.currentTimeMillis(), intent6, 0);



        Context context = getApplicationContext();
        CharSequence text = "Door opening!!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text ,duration );

        toast.show();
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);



        // Build notification
        // Actions are just fake
        Notification noti = new Notification.Builder(this)
                .setContentTitle("Front door is open")
                .setContentText("Welcome home").setSmallIcon(R.drawable.ic_launcher)
                .setContentIntent(pIntent)
                .addAction(R.drawable.ic_launcher, "Call", pIntent)
                .addAction(R.drawable.ic_launcher, "More", pIntent)
                .addAction(R.drawable.ic_launcher, "And more", pIntent).build();

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // hide the notification after its selected
        noti.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(0, noti);

            DateFormat formato = new SimpleDateFormat("d MMM yyyy, HH:mm");
            String dateo = formato.format(Calendar.getInstance().getTime());
            String fileName = "myFileo";
            try {
                FileOutputStream fileOutputStream = openFileOutput(fileName, MODE_APPEND);
                fileOutputStream.write(" ".getBytes());
                fileOutputStream.write(dateo.getBytes());
                fileOutputStream.write("\n".getBytes());
                fileOutputStream.close();
            } catch (FileNotFoundException f) {
                Log.e(TAG, "file not available for writing");
                f.printStackTrace(); //help with debugging
            } catch (IOException i) {
                Log.e(TAG, "IO Exception");
            }





    }



    public void closedoor(View view){

        Intent intent6 = new Intent(this, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int)
                System.currentTimeMillis(), intent6, 0);

        Context context = getApplicationContext();
        CharSequence text = "Door closing!!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text ,duration );

        toast.show();
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);


        // Build notification
        // Actions are just fake
        Notification noti = new Notification.Builder(this)
                .setContentTitle("Front door is closed")
                .setContentText(" ").setSmallIcon(R.drawable.ic_launcher)
                .setContentIntent(pIntent)
                .addAction(R.drawable.ic_launcher, "Call", pIntent)
                .addAction(R.drawable.ic_launcher, "More", pIntent)
                .addAction(R.drawable.ic_launcher, "And more", pIntent).build();

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // hide the notification after its selected
        noti.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(0, noti);

        DateFormat formatc = new SimpleDateFormat("d MMM yyyy, HH:mm");
        String datec = formatc.format(Calendar.getInstance().getTime());
        String fileName = "myFilec";
        try {
            FileOutputStream fileOutputStream = openFileOutput(fileName, MODE_APPEND);
            fileOutputStream.write(" ".getBytes());
            fileOutputStream.write(datec.getBytes());
            fileOutputStream.write("\n".getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException f) {
            Log.e(TAG, "file not available for writing");
            f.printStackTrace(); //help with debugging
        } catch (IOException i) {
            Log.e(TAG, "IO Exception");
        }

    }


    public void showLogFront(View view) {


        ArrayList<String>  doorOpenarray = new ArrayList<>();
        ArrayList<String>  doorClosearray = new ArrayList<>();

        //TextView textView = (TextView) findViewById(R.id.display);
        String fileName = "myFileo";
        StringBuffer stringBuffer = new StringBuffer(); //append is useful with StringBuffer
      //  stringBuffer.append("ID" + "    " + "First Name" + "     " + "Last Name" + "     " + "CIS Student");
        stringBuffer.append("\n");
        try {
            FileInputStream fileInputStream = openFileInput("myFileo");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                stringBuffer.append(data); //data we are reading from the file!
                stringBuffer.append("\n"); // new line
                doorOpenarray.add(data); // add date and time ro arraylist
            }
        } catch (FileNotFoundException f) {
            f.printStackTrace();
            Log.e(TAG, "file can not be opened");
        } catch (IOException i) {
            Log.e(TAG, "IO EXCEPTION READING FILE");
        }
        //  textView.setText(stringBuffer.toString());
        //if we forget to make it visible, the user will not see the data!
        Log.v(TAG, "SHOWING THE DATA.");




        //TextView textView = (TextView) findViewById(R.id.display);
        String fileName2 = "myFilec";
        StringBuffer stringBuffer2 = new StringBuffer(); //append is useful with StringBuffer
   //     stringBuffer.append("ID" + "    " + "First Name" + "     " + "Last Name" + "     " + "CIS Student");
        stringBuffer.append("\n");
        try {
            FileInputStream fileInputStream2 = openFileInput("myFilec");
            InputStreamReader inputStreamReader2 = new InputStreamReader(fileInputStream2);
            BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader2);
            String data;
            while ((data = bufferedReader2.readLine()) != null) {
                stringBuffer2.append(data); //data we are reading from the file!
                stringBuffer2.append("\n"); // new line
                doorClosearray.add(data); // add date and time ro arraylist
            }
        } catch (FileNotFoundException f) {
            f.printStackTrace();
            Log.e(TAG, "file can not be opened");
        } catch (IOException i) {
            Log.e(TAG, "IO EXCEPTION READING FILE");
        }
        //  textView.setText(stringBuffer.toString());
        //if we forget to make it visible, the user will not see the data!
        Log.v(TAG, "SHOWING THE DATA.");



     /*   Intent intent = new Intent(MainActivity.this, LogActivity.class);
        intent.putExtra("TextBox", stringBuffer.toString());
        intent.putExtra("TextBox1", stringBuffer2.toString());
        startActivity(intent);
*/

        Intent intent = new Intent(MainActivity.this, FrontDoorLog.class);
        intent.putStringArrayListExtra("TextBox", doorOpenarray);
        intent.putStringArrayListExtra("TextBox1", doorClosearray);

        startActivity(intent);



    }

    public void opengarage(View view){




        Toast toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);
        View vieew = toast.getView();
        //  vieew.setBackgroundColor(Color.parseColor("#BD8BDC"));
        vieew.setBackgroundResource(R.drawable.garageopen);
        toast.setView(vieew);
        toast.show();
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);

        DateFormat formato = new SimpleDateFormat("d MMM yyyy, HH:mm");
        String dateo = formato.format(Calendar.getInstance().getTime());
        String fileName = "garageopen";
        try {
            FileOutputStream fileOutputStream = openFileOutput(fileName, MODE_APPEND);
            fileOutputStream.write(" ".getBytes());
            fileOutputStream.write(dateo.getBytes());
            fileOutputStream.write("\n".getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException f) {
            Log.e(TAG, "file not available for writing");
            f.printStackTrace(); //help with debugging
        } catch (IOException i) {
            Log.e(TAG, "IO Exception");
        }

    }

    public void closegarage(View view){


        Context context = getApplicationContext();
        CharSequence text = "Garage door closing!!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);
        View vieew = toast.getView();
        //  vieew.setBackgroundColor(Color.parseColor("#BD8BDC"));
        vieew.setBackgroundResource(R.drawable.garageclose);
        toast.setView(vieew);
        toast.show();
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);

        DateFormat formato = new SimpleDateFormat("d MMM yyyy, HH:mm");
        String dateo = formato.format(Calendar.getInstance().getTime());
        String fileName = "garageclose";
        try {
            FileOutputStream fileOutputStream = openFileOutput(fileName, MODE_APPEND);
            fileOutputStream.write(" ".getBytes());
            fileOutputStream.write(dateo.getBytes());
            fileOutputStream.write("\n".getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException f) {
            Log.e(TAG, "file not available for writing");
            f.printStackTrace(); //help with debugging
        } catch (IOException i) {
            Log.e(TAG, "IO Exception");
        }

    }
    public void showGarageLog(View view){

        ArrayList<String>  garageOpenarray = new ArrayList<>();
        ArrayList<String>  garageClosearray = new ArrayList<>();


        //TextView textView = (TextView) findViewById(R.id.display);
        String fileName = "garageopen";
        StringBuffer stringBuffer = new StringBuffer(); //append is useful with StringBuffer
        //  stringBuffer.append("ID" + "    " + "First Name" + "     " + "Last Name" + "     " + "CIS Student");
        stringBuffer.append("\n");
        try {
            FileInputStream fileInputStream = openFileInput(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                stringBuffer.append(data); //data we are reading from the file!
                stringBuffer.append("\n"); // new line
                garageOpenarray.add(data); // add date and time ro arraylist
            }
        } catch (FileNotFoundException f) {
            f.printStackTrace();
            Log.e(TAG, "file can not be opened");
        } catch (IOException i) {
            Log.e(TAG, "IO EXCEPTION READING FILE");
        }
        //  textView.setText(stringBuffer.toString());
        //if we forget to make it visible, the user will not see the data!
        Log.v(TAG, "SHOWING THE DATA.");




        //TextView textView = (TextView) findViewById(R.id.display);
        String fileName2 = "garageclose";
        StringBuffer stringBuffer2 = new StringBuffer(); //append is useful with StringBuffer
        //     stringBuffer.append("ID" + "    " + "First Name" + "     " + "Last Name" + "     " + "CIS Student");
        stringBuffer.append("\n");
        try {
            FileInputStream fileInputStream2 = openFileInput(fileName);
            InputStreamReader inputStreamReader2 = new InputStreamReader(fileInputStream2);
            BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader2);
            String data;
            while ((data = bufferedReader2.readLine()) != null) {
                stringBuffer2.append(data); //data we are reading from the file!
                stringBuffer2.append("\n"); // new line
                  garageClosearray.add(data); // add date and time ro arraylist


            }
        } catch (FileNotFoundException f) {
            f.printStackTrace();
            Log.e(TAG, "file can not be opened");
        } catch (IOException i) {
            Log.e(TAG, "IO EXCEPTION READING FILE");
        }
        //  textView.setText(stringBuffer.toString());
        //if we forget to make it visible, the user will not see the data!
        Log.v(TAG, "SHOWING THE DATA.");



     /*   Intent intent = new Intent(MainActivity.this, Log2Activity.class);
        intent.putExtra("TextBox", stringBuffer.toString());
        intent.putExtra("TextBox1", stringBuffer2.toString());
        startActivity(intent);
8*/
        Intent intent2 = new Intent(MainActivity.this, LogDislpay.class);
        intent2.putStringArrayListExtra("TextBox", garageOpenarray);
        intent2.putStringArrayListExtra("TextBox1", garageClosearray);

        startActivity(intent2);

    }




}

